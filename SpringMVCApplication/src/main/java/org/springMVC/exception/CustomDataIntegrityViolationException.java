package org.springMVC.exception;

public class CustomDataIntegrityViolationException extends Exception {
    public CustomDataIntegrityViolationException(String message) {
        super(message);
    }
}