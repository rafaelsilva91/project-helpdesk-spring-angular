package com.rafaelsilva91.dev.helpdesk.services.exceptions;

public class ObjectNotFoundExceptions extends RuntimeException{

    private static final long serialVersionUID = -8981510161454059603L;

    public ObjectNotFoundExceptions() {
    }

    public ObjectNotFoundExceptions(String message) {
        super(message);
    }

    public ObjectNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
