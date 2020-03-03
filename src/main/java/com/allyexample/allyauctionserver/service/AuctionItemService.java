package com.allyexample.allyauctionserver.service;

import com.allyexample.allyauctionserver.model.AuctionItem;
import com.allyexample.allyauctionserver.repository.AuctionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuctionItemService {

    @Autowired
    private AuctionItemRepository repository;

    public AuctionItem addAuctionItem(AuctionItem item) {
        return this.repository.save(item);
    }

    public Iterable<AuctionItem> getAll() {
        return this.repository.findAll();
    }

    public AuctionItem getById(UUID id) throws Exception {
        Optional<AuctionItem> auctionItem =  this.repository.findById(id);
        return auctionItem.orElseThrow(() -> new Exception());
    }

}
