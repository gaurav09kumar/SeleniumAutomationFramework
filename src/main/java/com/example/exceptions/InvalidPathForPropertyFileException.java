package com.example.exceptions;

@SuppressWarnings("serial")
public class InvalidPathForPropertyFileException extends InvalidPathForExcelException {
    public InvalidPathForPropertyFileException(String message) {
        super(message);
    }

    public InvalidPathForPropertyFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
