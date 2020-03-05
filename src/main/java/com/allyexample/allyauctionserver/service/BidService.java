package com.allyexample.allyauctionserver.service;

import com.allyexample.allyauctionserver.model.AuctionItem;
import com.allyexample.allyauctionserver.model.BidItem;
import com.allyexample.allyauctionserver.model.exception.InvalidBidException;
import com.allyexample.allyauctionserver.model.exception.ReservePriceException;
import com.allyexample.allyauctionserver.repository.AuctionItemRepository;
import com.allyexample.allyauctionserver.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionItemService auctionItemService;

    @Autowired
    private AuctionItemRepository auctionItemRepository;

    public AuctionItem addBid(BidItem bid) throws ReservePriceException, InvalidBidException {
        AuctionItem auctionItem = null;
        this.bidRepository.save(bid);
        Optional<AuctionItem> item = this.auctionItemRepository.findById(bid.getAuctionItemId());

        if (item != null) {
            auctionItem = this.processBid(bid, item.get());
        }

        return auctionItem;
    }

    private AuctionItem processBid(BidItem bid, AuctionItem auctionItem) {
        AuctionItem returnAuctionItem = null;
        if (bid != null && auctionItem != null) {
            if (bid.getMaxAutoBidAmount() < auctionItem.getReservePrice()) {
                auctionItem.setCurrentBid(Math.max(auctionItem.getCurrentBid(), bid.getMaxAutoBidAmount()));
                auctionItem.setBidderName(bid.getBidderName());

                if (bid.getMaxAutoBidAmount() > auctionItem.getCurrentBid()) {
                    this.notifyUserOutbid(auctionItem.getBidderName());
                }

                this.auctionItemRepository.save(auctionItem);
                throw new ReservePriceException();
            } else if (bid.getMaxAutoBidAmount() <= auctionItem.getCurrentBid()) {
                throw new InvalidBidException();
            }

            if (auctionItem.getLastValidBid() != null) {
                double lastBidMaxAutoBid = bidRepository.findMaxAutoBidById(auctionItem.getLastValidBid());

                if (bid.getMaxAutoBidAmount() == lastBidMaxAutoBid) {
                    throw new InvalidBidException();
                } else if (bid.getMaxAutoBidAmount() < lastBidMaxAutoBid) {
                    auctionItem.setCurrentBid(bid.getMaxAutoBidAmount() + 1);
                    this.auctionItemRepository.save(auctionItem);
                    throw new InvalidBidException();
                } else {
                    auctionItem.setCurrentBid(lastBidMaxAutoBid + 1);
                    auctionItem.setBidderName(bid.getBidderName());
                    auctionItem.setLastValidBid(bid.getBidId());
                    return this.auctionItemRepository.save(auctionItem);
                }
            }

            this.notifyUserOutbid(auctionItem.getBidderName());

            auctionItem.setLastValidBid(bid.getBidId());
            auctionItem.setBidderName(bid.getBidderName());
            auctionItem.setCurrentBid(Math.max(auctionItem.getCurrentBid(), auctionItem.getReservePrice()));
            returnAuctionItem = this.auctionItemRepository.save(auctionItem);
        }

        return returnAuctionItem;
    }

    private void notifyUserOutbid(String user) {
        if (user != null && user.length() > 0) {
            // TODO: assuming proper authentication with an email, email user that user has been outbid
            // TODO: assuming proper authentication and establishment of web socket or stomp to the UI, push live notification
        }
    }

    public Iterable<BidItem> getAll() {
        return this.bidRepository.findAll();
    }

}
