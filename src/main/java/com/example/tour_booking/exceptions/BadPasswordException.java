package com.example.tour_booking.exceptions;

public class BadPasswordException extends RuntimeException {

    public BadPasswordException(String message) {
        super(message);
    }
}
