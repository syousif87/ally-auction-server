package com.allyexample.allyauctionserver.controller;

import com.allyexample.allyauctionserver.model.AuctionItem;
import com.allyexample.allyauctionserver.model.BidItem;
import com.allyexample.allyauctionserver.model.exception.InvalidBidException;
import com.allyexample.allyauctionserver.model.exception.ReservePriceException;
import com.allyexample.allyauctionserver.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BidController {
    @Autowired
    private BidService service;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/bids",
            produces = "application/json")
    public Iterable<BidItem> getBidItems() {
        return this.service.getAll();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/bids",
            consumes = "application/json",
            produces = "application/json")
    public AuctionItem postBid(@RequestBody BidItem bid) throws ReservePriceException, InvalidBidException {
        return this.service.addBid(bid);
    }
}
