package com.allyexample.allyauctionserver.service;

import com.allyexample.allyauctionserver.model.AuctionItem;
import com.allyexample.allyauctionserver.model.BidItem;
import com.allyexample.allyauctionserver.model.exception.InvalidBidException;
import com.allyexample.allyauctionserver.model.exception.ReservePriceException;
import org.assertj.core.util.IterableUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BidServiceTest {

    @Autowired
    private BidService bidService;

    @Autowired
    private AuctionItemService auctionItemService;

    @Test
    public void getAll() {
        var a1 = new AuctionItem();
        a1.setCurrentBid(5000);
        var b1 = new BidItem();
        b1.setMaxAutoBidAmount(5001);
        b1.setAuctionItemId(a1.getAuctionItemId());
        var a2 = new AuctionItem();
        a2.setCurrentBid(5000);
        var b2 = new BidItem();
        b2.setMaxAutoBidAmount(5001);
        b2.setAuctionItemId(a2.getAuctionItemId());
        this.auctionItemService.addAuctionItem(a1);
        this.auctionItemService.addAuctionItem(a2);
        this.bidService.addBid(b1);
        this.bidService.addBid(b2);

        assertThat(IterableUtil.sizeOf(this.bidService.getAll())).isGreaterThan(0);
    }

    @Test()
    public void bidProper() throws Exception {
        var a = new AuctionItem();
        a.setCurrentBid(5000);
        a.setBidderName("dev1");
        this.auctionItemService.addAuctionItem(a);
        var b = new BidItem();
        b.setAuctionItemId(a.getAuctionItemId());
        b.setMaxAutoBidAmount(6000);
        b.setBidderName("dev2");
        assertThat(this.bidService.addBid(b)).isNotNull();
        assertThat(this.auctionItemService.getById(a.getAuctionItemId()).getCurrentBid()).isEqualTo(5001);
        assertThat(this.auctionItemService.getById(a.getAuctionItemId()).getBidderName()).isEqualTo("dev2");
    }

    @Test()
    public void bidProperWithReserve() throws Exception {
        var a = new AuctionItem();
        a.setCurrentBid(5000);
        a.setReservePrice(5500);
        a.setBidderName("dev1");
        this.auctionItemService.addAuctionItem(a);
        var b = new BidItem();
        b.setAuctionItemId(a.getAuctionItemId());
        b.setMaxAutoBidAmount(6000);
        b.setBidderName("dev2");
        assertThat(this.bidService.addBid(b)).isNotNull();
        assertThat(this.auctionItemService.getById(a.getAuctionItemId()).getCurrentBid()).isEqualTo(5500);
        assertThat(this.auctionItemService.getById(a.getAuctionItemId()).getBidderName()).isEqualTo("dev2");
    }

    @Test()
    public void bidProperWithReserve2() throws Exception {
        var a = new AuctionItem();
        a.setCurrentBid(5000);
        a.setReservePrice(1100);
        this.auctionItemService.addAuctionItem(a);
        var b = new BidItem();
        b.setAuctionItemId(a.getAuctionItemId());
        b.setMaxAutoBidAmount(6000);
        b.setBidderName("dev2");
        assertThat(this.bidService.addBid(b)).isNotNull();
        assertThat(this.auctionItemService.getById(a.getAuctionItemId()).getCurrentBid()).isEqualTo(5001);
        assertThat(this.auctionItemService.getById(a.getAuctionItemId()).getBidderName()).isEqualTo("dev2");
    }

    @Test()
    public void invalidBid() throws Exception  {
        var a = new AuctionItem();
        a.setCurrentBid(5000);
        a.setBidderName("dev1");
        this.auctionItemService.addAuctionItem(a);
        var b = new BidItem();
        b.setAuctionItemId(a.getAuctionItemId());
        b.setMaxAutoBidAmount(5000);
        b.setBidderName("dev2");
        Assertions.assertThrows(InvalidBidException.class, () -> {
            bidService.addBid(b);
        });

        assertThat(this.auctionItemService.getById(a.getAuctionItemId()).getBidderName()).isEqualTo("dev1");
    }

    @Test()
    public void invalidBid2() throws Exception  {
        var a = new AuctionItem();
        a.setCurrentBid(5000);
        a.setBidderName("dev1");
        this.auctionItemService.addAuctionItem(a);
        var b = new BidItem();
        b.setAuctionItemId(a.getAuctionItemId());
        b.setMaxAutoBidAmount(6000);
        b.setBidderName("dev1");
        bidService.addBid(b);

        var b2 = new BidItem();
        b2.setAuctionItemId(a.getAuctionItemId());
        b2.setMaxAutoBidAmount(6000);
        b2.setBidderName("dev2");

        Assertions.assertThrows(InvalidBidException.class, () -> {
            bidService.addBid(b2);
        });

        assertThat(this.auctionItemService.getById(a.getAuctionItemId()).getCurrentBid()).isEqualTo(6000);
        assertThat(this.auctionItemService.getById(a.getAuctionItemId()).getBidderName()).isEqualTo("dev1");
    }

    @Test()
    public void reservePriceExceptionBid() throws Exception {
        var a = new AuctionItem();
        a.setCurrentBid(0);
        a.setReservePrice(10000);
        this.auctionItemService.addAuctionItem(a);
        var b = new BidItem();
        b.setAuctionItemId(a.getAuctionItemId());
        b.setMaxAutoBidAmount(5000);
        Assertions.assertThrows(ReservePriceException.class, () -> {
            bidService.addBid(b);
        });

        assertThat(this.auctionItemService.getById(a.getAuctionItemId()).getCurrentBid()).isEqualTo(5000);
    }
}
