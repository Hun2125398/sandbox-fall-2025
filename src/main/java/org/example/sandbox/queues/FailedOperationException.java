package org.example.sandbox.queues;

public class FailedOperationException extends RuntimeException {

    public FailedOperationException() {
    }

    public FailedOperationException(String message) {
        super(message);
    }

    public FailedOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedOperationException(Throwable cause) {
        super(cause);
    }
}
