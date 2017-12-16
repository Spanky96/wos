package top.spanky.wos.exception;

public class ServiceException extends Exception {

    private static final long serialVersionUID = -8266903423110808610L;

    private int code;
    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }
    
    public ServiceException(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
