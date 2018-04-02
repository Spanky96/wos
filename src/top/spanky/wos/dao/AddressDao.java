package top.spanky.wos.dao;

import java.util.List;

import top.spanky.wos.model.Address;

public interface AddressDao {

    public List getAllAddressByUserId(int userId);

    public Address getById(int id);

    public boolean update(Address newAddress);

    public boolean add(Address newAddress);

    public boolean deleteById(int id);
}
