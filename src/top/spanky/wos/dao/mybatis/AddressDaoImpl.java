package top.spanky.wos.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import top.spanky.wos.dao.AddressDao;
import top.spanky.wos.model.Address;

public class AddressDaoImpl extends SqlSessionDaoSupport implements AddressDao {

    private static final String CLASS_NAME = Address.class.getName();

    @Override
    public List getAllAddressByUserId(int userId) {
        return getSqlSession().selectList(CLASS_NAME + ".getAllByUserId", userId);
    }

    @Override
    public boolean update(Address newAddress) {
        return getSqlSession().update(CLASS_NAME + ".update", newAddress) > 0 ? true : false;
    }

    @Override
    public boolean add(Address newAddress) {
        return getSqlSession().insert(CLASS_NAME + ".add", newAddress) > 0 ? true : false;
    }

    @Override
    public boolean deleteById(int id) {
        return getSqlSession().update(CLASS_NAME + ".deleteById", id) > 0 ? true : false;
    }

}
