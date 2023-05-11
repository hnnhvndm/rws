package main.exception;

public class IncorrectZipcodeException extends Exception {

    public IncorrectZipcodeException(String error) {
        super(error);
    }
}
