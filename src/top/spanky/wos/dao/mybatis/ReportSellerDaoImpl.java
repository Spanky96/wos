package top.spanky.wos.dao.mybatis;

import java.util.List;

import top.spanky.wos.dao.ReportDao;
import top.spanky.wos.model.ReportSeller;

public class ReportSellerDaoImpl extends ReportDao<ReportSeller> {

    private static final String CLASS_NAME = ReportSeller.class.getName();

    @Override
    public List<ReportSeller> getAll() {
        return getSqlSession().selectList(CLASS_NAME + ".getAll");
    }

}
