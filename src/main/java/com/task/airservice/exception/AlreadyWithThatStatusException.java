package com.task.airservice.exception;

public class AlreadyWithThatStatusException extends RuntimeException {
    public AlreadyWithThatStatusException(String message) {
        super(message);
    }
}
