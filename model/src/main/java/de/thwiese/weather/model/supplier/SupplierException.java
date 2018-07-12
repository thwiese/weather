package de.thwiese.weather.model.supplier;

public class SupplierException extends RuntimeException {

    public SupplierException() {
    }

    public SupplierException(String message) {
        super(message);
    }

    public SupplierException(String message, Throwable cause) {
        super(message, cause);
    }

    public SupplierException(Throwable cause) {
        super(cause);
    }

    public SupplierException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
