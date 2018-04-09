package top.spanky.wos.service.impl;

import java.util.List;

import top.spanky.wos.dao.DistributorDao;
import top.spanky.wos.model.Distributor;
import top.spanky.wos.service.DistributorService;

public class DistributorServiceImpl implements DistributorService {

    private DistributorDao distributorDao;

    public void setDistributorDao(DistributorDao distributorDao) {
        this.distributorDao = distributorDao;
    }

    @Override
    public List getAll() {
        return distributorDao.getAll();
    }

    @Override
    public Distributor getById(int id) {
        return distributorDao.getById(id);
    }

    @Override
    public boolean add(Distributor distributor) {
        return distributorDao.add(distributor);
    }

    @Override
    public boolean update(Distributor distributor) {
        return distributorDao.update(distributor);
    }

    @Override
    public boolean deleteById(int id) {
        return distributorDao.deleteById(id);
    }

}
