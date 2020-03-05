package com.allyexample.allyauctionserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "auction_item", indexes = { @Index(columnList = "auction_item_id") })
public class AuctionItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Column(unique = true, name = "auction_item_id")
    @JsonProperty("auctionItemId")
    private UUID auctionItemId = UUID.randomUUID();

    @Getter
    @Setter
    @JsonIgnore
    private UUID lastValidBid;

    @Getter
    @Setter
    @Column(name = "current_bid")
    @JsonProperty("currentBid")
    private double currentBid;

    @Getter
    @Setter
    @Column(name = "bidder_name")
    @JsonProperty("bidderName")
    private String bidderName;

    @Getter
    @Setter
    @Column(name = "reserve_price")
    @JsonProperty("reservePrice")
    private double reservePrice;

    @Getter
    @Setter
    @JsonProperty("item")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Item item;

}
