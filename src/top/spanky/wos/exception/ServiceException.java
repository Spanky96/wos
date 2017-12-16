package top.spanky.wos.exception;

import top.spanky.wos.util.ExceptionPropertyUtil;

public class ServiceException extends Exception {

    private static final long serialVersionUID = -8266903423110808610L;
    
    //There are service excption code
    public static final int VALID_LOGIN_MESSAGE = 1000;
    
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
    
    public ServiceException(int code) {
        super(ExceptionPropertyUtil.getExcpetionMessage(code));
        this.code = code;
    }

}
