package com.sankuai.headcount.model.exception;

public class InnerException extends Exception {

    private String message;

    private CauseEnum cause;

    public String getMessage() {
        return this.message;
    }

    public InnerException() {
        super();
    }

    public InnerException(Exception ex, CauseEnum cause, String message) {
        super(ex);
        this.cause = cause;
        this.message = message;
    }
}