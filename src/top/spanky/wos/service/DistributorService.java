package top.spanky.wos.service;

import java.util.List;

import top.spanky.wos.model.Distributor;

public interface DistributorService {

    public List getAll();

    public Distributor getById(int id);

    public boolean add(Distributor distributor);

    public boolean update(Distributor distributor);

    public boolean deleteById(int id);
}
