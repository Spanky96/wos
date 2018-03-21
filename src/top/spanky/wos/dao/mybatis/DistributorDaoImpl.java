package top.spanky.wos.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import top.spanky.wos.dao.DistributorDao;
import top.spanky.wos.model.Distributor;

public class DistributorDaoImpl extends SqlSessionDaoSupport implements DistributorDao {

    private static final String CLASS_NAME = Distributor.class.getName();

    @Override
    public List getAll() {
        return getSqlSession().selectList(CLASS_NAME + ".getAll");
    }

    @Override
    public Distributor getById(int id) {
        return getSqlSession().selectOne(CLASS_NAME + ".getByID", id);
    }

    @Override
    public boolean add(Distributor distributor) {
        return getSqlSession().insert(CLASS_NAME + ".add", distributor) > 0 ? true : false;
    }

    @Override
    public boolean update(Distributor distributor) {
        return getSqlSession().insert(CLASS_NAME + ".update", distributor) > 0 ? true : false;
    }

    @Override
    public boolean deleteById(int id) {
        return getSqlSession().insert(CLASS_NAME + ".deleteById", id) > 0 ? true : false;
    }

}
