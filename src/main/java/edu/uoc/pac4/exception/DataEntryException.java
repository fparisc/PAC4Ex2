package edu.uoc.pac4.exception;

public class DataEntryException extends AppException {

    public static final String ERROR_ID = "ID cannot be negative or zero.";
    public static final String ERROR_TIMESTAMP = "Timestamp cannot be null or in the future.";
    public static final String ERROR_OBSERVATIONS = "Observations cannot be null.";
    public static final String ERROR_TITLE = "Title cannot be null or blank.";
    public static final String ERROR_PARTICLE = "Particle cannot be null.";

    public DataEntryException(String message) {
        super(message);
    }
}
