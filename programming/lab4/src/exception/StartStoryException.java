package exception;
import java.io.IOException;

public class StartStoryException extends IOException {
    public StartStoryException(String message) {
        super(message);
    }
}
