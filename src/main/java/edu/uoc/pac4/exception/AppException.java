package edu.uoc.pac4.exception;

public abstract class AppException extends Exception {

    public AppException(String message) {
        super("[ERROR] " + message);
    }
}
