package top.spanky.wos.dao;

import java.util.List;

import top.spanky.wos.model.Distributor;

public interface DistributorDao {

    public List getAll();

    public Distributor getById(int id);

    public boolean add(Distributor distributor);

    public boolean update(Distributor distributor);

    public boolean deleteById(int id);

}

