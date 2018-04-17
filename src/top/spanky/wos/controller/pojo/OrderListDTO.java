package top.spanky.wos.controller.pojo;

import top.spanky.wos.model.User;

public class OrderListDTO extends UserOrderDTO {
    private User user;

    public OrderListDTO() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
