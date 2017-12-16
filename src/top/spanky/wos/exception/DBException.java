package top.spanky.wos.exception;

public class DBException extends RuntimeException {

    private static final long serialVersionUID = -7393762686686986009L;

    public DBException() {
    }

    public DBException(Throwable cause) {
        super(cause);
    }

}
