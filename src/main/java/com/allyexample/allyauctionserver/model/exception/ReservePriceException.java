package com.allyexample.allyauctionserver.model.exception;

public class ReservePriceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ReservePriceException() {
        super("Reserve price has not been met.");
    }
}
