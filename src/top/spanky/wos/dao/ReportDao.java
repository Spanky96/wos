package top.spanky.wos.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public abstract class ReportDao<T> extends SqlSessionDaoSupport {

    public abstract List<T> getAll();
}
