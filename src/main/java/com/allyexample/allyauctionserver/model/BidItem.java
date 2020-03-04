package com.allyexample.allyauctionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "bid")
public class BidItem implements Serializable {
    private static final long serialVersionUID = 1L;

//    @Id
//    @Getter
//    @Setter
//    @ManyToOne
//    @MapsId
//    private AuctionItem auctionItem;
//    TODO: foreign key to auction_item
    @Id
    @Getter
    @Setter
    @Column(name = "auction_item_id")
    @JsonProperty("auctionItemId")
    private UUID auctionItemId;

    @Getter
    @Setter
    @Column(name = "max_auto_bid_amount")
    @JsonProperty("maxAutoBidAmount")
    private String maxAutoBidAmount;

    @Getter
    @Setter
    @Column(name = "bidder_name")
    @JsonProperty("bidderName")
    private String bidderName;

}

