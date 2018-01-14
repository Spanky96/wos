package top.spanky.wos.service;

import top.spanky.wos.exception.ParameterException;
import top.spanky.wos.exception.ServiceException;
import top.spanky.wos.model.User;

public interface UserService {

    public User login(String username, String password) throws ParameterException, ServiceException;

    public User getByOpenid(String openid);
}
