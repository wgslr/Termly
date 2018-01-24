package agh.cs.lab.termly.exceptions;

/**
 * Describes an error caused by unexpected response from the API
 * or connection problems.
 */
public class ApiConnectionException extends RuntimeException{
    public ApiConnectionException() {
        super();
    }

    public ApiConnectionException(String s) {
        super(s);
    }

    public ApiConnectionException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ApiConnectionException(Throwable throwable) {
        super(throwable);
    }
}
