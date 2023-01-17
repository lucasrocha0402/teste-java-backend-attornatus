package com.teste.avaliacaoattornatus.exception;

import java.util.Date;

public class ErrorMessage {

    private int statusCode;

    private Date timesTamp;

    private String message;

    private String description;

    public ErrorMessage(int statusCode, Date timesTamp, String message, String description) {
        this.statusCode = statusCode;
        this.timesTamp = timesTamp;
        this.message = message;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Date getTimesTamp() {
        return timesTamp;
    }
}
