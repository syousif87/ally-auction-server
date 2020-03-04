package com.allyexample.allyauctionserver.repository;

import com.allyexample.allyauctionserver.model.BidItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BidRepository extends PagingAndSortingRepository<BidItem, UUID> {

    @Override
    Iterable<BidItem> findAll();

}
