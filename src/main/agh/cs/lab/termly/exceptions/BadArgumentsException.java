package agh.cs.lab.termly.exceptions;

public class BadArgumentsException extends RuntimeException {
    public BadArgumentsException(String s) {
        super(s);
    }

    public BadArgumentsException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
