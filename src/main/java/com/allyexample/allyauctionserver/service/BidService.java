package com.allyexample.allyauctionserver.service;

import com.allyexample.allyauctionserver.model.BidItem;
import com.allyexample.allyauctionserver.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {

    @Autowired
    private BidRepository repository;

    public BidItem addBid(BidItem item) {
        return this.repository.save(item);
    }

    public Iterable<BidItem> getAll() {
        return this.repository.findAll();
    }

}
