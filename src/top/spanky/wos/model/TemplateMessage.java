package top.spanky.wos.model;

import java.util.Map;

public class TemplateMessage {

    private String toUser;
    private String template_id;
    private Map data;
    
    public String getToUser() {
        return toUser;
    }
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
    public String getTemplate_id() {
        return template_id;
    }
    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }
    public Map getData() {
        return data;
    }
    public void setData(Map data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "TemplateMessage [toUser=" + toUser + ", template_id=" + template_id + ", data=" + data + "]";
    }
    
}
