package top.spanky.wos.dao.mybatis;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import top.spanky.wos.dao.UserDao;
import top.spanky.wos.model.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    private static final String CLASS_NAME = User.class.getName();
    private static final String SQL_ID_USER_GET_USER_BY_USERNAME = ".getByUsername";
    private static final String SQL_ID_USER_GET_USER_BY_OPENID = ".getByOpenID";
    private static final String SQL_ID_USER_ADD_USER_BY_WX = ".addUserByWX";

    @Override
    public User getByUsername(String username) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_USER_GET_USER_BY_USERNAME, username);
    }

    @Override
    public User getByOpenID(String openid) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_USER_GET_USER_BY_OPENID, openid);
    }

    @Override
    public boolean addByWX(User user) {
        int num = getSqlSession().insert(CLASS_NAME + SQL_ID_USER_ADD_USER_BY_WX, user);
        return num == 1 ? true : false;
    }

}
