package com.allyexample.allyauctionserver.model.exception;

public class InvalidBidException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidBidException() {
        super("Invalid bid.");
    }
}
