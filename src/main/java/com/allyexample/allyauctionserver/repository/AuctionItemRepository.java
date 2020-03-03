package com.allyexample.allyauctionserver.repository;

import com.allyexample.allyauctionserver.model.AuctionItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuctionItemRepository extends PagingAndSortingRepository<AuctionItem, UUID> {

    @Override
    Iterable<AuctionItem> findAll();

    @Override
    Optional<AuctionItem> findById(UUID id);
}
