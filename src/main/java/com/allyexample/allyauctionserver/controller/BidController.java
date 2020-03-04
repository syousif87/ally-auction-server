package com.allyexample.allyauctionserver.controller;

import com.allyexample.allyauctionserver.model.BidItem;
import com.allyexample.allyauctionserver.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BidController {
    @Autowired
    private BidService service;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/bids",
            consumes = "application/json",
            produces = "application/json")
    public BidItem postBid(@RequestBody BidItem bid) throws Exception {
        return this.service.addBid(bid);
    }
}
