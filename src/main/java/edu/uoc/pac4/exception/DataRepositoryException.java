package edu.uoc.pac4.exception;

public class DataRepositoryException extends AppException {

    public static final String ERROR_NAME = "Name cannot be null or blank.";
    public static final String ERROR_DATA_ENTRY_NULL = "Data entry cannot be null.";
    public static final String ERROR_ENTRY_ALREADY_EXISTS = "Data entry with this ID already exists.";
    public static final String ERROR_DATA_ENTRY_NOT_FOUND = "Data entry not found.";

    public DataRepositoryException(String message) {
        super(message);
    }
}