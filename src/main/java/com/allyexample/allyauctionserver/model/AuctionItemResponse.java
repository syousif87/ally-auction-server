package com.allyexample.allyauctionserver.model;

import java.util.UUID;

public class AuctionItemResponse {
    public UUID auctionItemId;

    public AuctionItemResponse(UUID id) {
        this.auctionItemId = id;
    }
}
