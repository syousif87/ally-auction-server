package com.allyexample.allyauctionserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "bid", indexes = { @Index(columnList = "bid_id") })
public class BidItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @JsonIgnore
    @Column(name = "bid_id", unique = true)
    private UUID bidId = UUID.randomUUID();

    @Getter
    @Setter
    @Column(name = "auction_item_id")
    @JsonProperty("auctionItemId")
    private UUID auctionItemId;

    @Getter
    @Setter
    @Column(name = "max_auto_bid_amount")
    @JsonProperty("maxAutoBidAmount")
    private double maxAutoBidAmount;

    @Getter
    @Setter
    @Column(name = "bidder_name")
    @JsonProperty("bidderName")
    private String bidderName;

}

