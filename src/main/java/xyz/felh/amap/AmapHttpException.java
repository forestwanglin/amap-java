package xyz.felh.amap;

public class AmapHttpException extends RuntimeException {

    public AmapHttpException(String message) {
        super(message);
    }

    public AmapHttpException(String message, Throwable t) {
        super(message, t);
    }

}
