package hack.sheremetievo.navigator.exception;

public class PathNotFoundException extends RuntimeException {

    public PathNotFoundException() {
    }

    public PathNotFoundException(String message) {
        super(message);
    }
}
