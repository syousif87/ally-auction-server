package com.allyexample.allyauctionserver.repository;

import com.allyexample.allyauctionserver.model.BidItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BidRepository extends PagingAndSortingRepository<BidItem, UUID> {

    @Override
    Iterable<BidItem> findAll();

    @Override
    Optional<BidItem> findById(UUID id);

    @Modifying
    @Query(value =
            "SELECT max_auto_bid_amount FROM bid WHERE :id = bid_id",
            nativeQuery = true)
    double findMaxAutoBidById(@Param("id") UUID id);

}
