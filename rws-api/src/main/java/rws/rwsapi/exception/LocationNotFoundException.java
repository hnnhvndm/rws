package rws.rwsapi.exception;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(String error) {
        super(error);
    }
}
