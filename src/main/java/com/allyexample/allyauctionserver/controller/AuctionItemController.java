package com.allyexample.allyauctionserver.controller;

import com.allyexample.allyauctionserver.model.AuctionItem;
import com.allyexample.allyauctionserver.service.AuctionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AuctionItemController {
    @Autowired
    private AuctionItemService service;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/auctionItems",
            produces = "application/json")
    public Object getAuctionItems() {
        return this.service.getAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/auctionItems/{id}",
            produces = "application/json")
    public Object getAuctionItem(@PathVariable UUID id) throws Exception {
        return this.service.getById(id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/auctionItems",
            consumes = "application/json",
            produces = "application/json")
    public Object postAuctionItem(@RequestBody AuctionItem auctionItem) throws Exception {
        return this.service.addAuctionItem(auctionItem).getAuctionItemId();
    }
}
