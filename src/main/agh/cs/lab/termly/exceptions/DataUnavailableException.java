package agh.cs.lab.termly.exceptions;

/**
 * Exception raied when unavailable data were requested.
 */
public class DataUnavailableException extends RuntimeException {
    public DataUnavailableException() {
        super();
    }

    public DataUnavailableException(String s) {
        super(s);
    }
}
