package agh.cs.lab.termly.exceptions;

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
