package agh.cs.lab.termly.exceptions;

/**
 * Exception caused by user providing invalid command line arguments.
 */
public class BadArgumentsException extends RuntimeException {
    public BadArgumentsException(String s) {
        super(s);
    }

    public BadArgumentsException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
