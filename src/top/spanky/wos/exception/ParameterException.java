package top.spanky.wos.exception;

import java.util.HashMap;
import java.util.Map;

public class ParameterException extends Exception {

    private static final long serialVersionUID = -225366382356947911L;
    Map<String, String> errorFields = new HashMap<String, String>();

    public Map<String, String> getErrorFields() {
        return errorFields;
    }

    public void setErrorFields(Map<String, String> errorFields) {
        this.errorFields = errorFields;
    }

    public void addErrorField(String errorField, String msg) {
        errorFields.put(errorField, msg);
    }

    public boolean hasError() {
        return !errorFields.isEmpty();
    }

}
