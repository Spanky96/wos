package top.spanky.wos.dao.mybatis;

import java.util.List;

import top.spanky.wos.dao.ReportDao;
import top.spanky.wos.model.ReportFoods;

public class ReportFoodDaoImpl extends ReportDao<ReportFoods> {

    private static final String CLASS_NAME = ReportFoods.class.getName();

    @Override
    public List<ReportFoods> getAll() {
        return getSqlSession().selectList(CLASS_NAME + ".getAll");
    }

}
