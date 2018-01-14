package top.spanky.wos.service.impl;

import top.spanky.wos.dao.UserDao;
import top.spanky.wos.exception.ParameterException;
import top.spanky.wos.exception.ServiceException;
import top.spanky.wos.model.User;
import top.spanky.wos.service.UserService;
import top.spanky.wos.util.StringUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String username, String password) throws ParameterException, ServiceException {
        ParameterException parameterException = null;

        if (StringUtil.isEmpty(username)) {
            parameterException = new ParameterException();
            parameterException.addErrorField("username", "Username is required");
        }

        if (StringUtil.isEmpty(password)) {
            if (parameterException == null) {
                parameterException = new ParameterException();
            }
            parameterException.addErrorField("password", "Password is required");
        }

        if (parameterException != null)
            throw parameterException;

        User user = userDao.getByUsername(username);

        if ((user == null) || !password.equals(user.getPassword()))
            throw new ServiceException(ServiceException.VALID_LOGIN_MESSAGE);

        return user;

    }

    @Override
    public User getByOpenid(String openid) {
        return userDao.getByOpenID(openid);
    }

}
