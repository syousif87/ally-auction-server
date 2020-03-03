package com.allyexample.allyauctionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "auction_item")
public class AuctionItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    private UUID auctionItemId = UUID.randomUUID();

    @Getter
    @Setter
    @Column(name = "current_bid")
    @JsonProperty("current_bid")
    private double currentBid;

    @Getter
    @Setter
    @Column(name = "bidder_name")
    @JsonProperty("bidder_name")
    private String bidderName;

    @Getter
    @Setter
    @Column(name = "reserve_price")
    @JsonProperty("reserve_price")
    private double reservePrice;

    @Getter
    @Setter
    @JsonProperty("item")
    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Item item;

}
