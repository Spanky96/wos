package top.spanky.wos.service;

import java.util.List;

import top.spanky.wos.model.Address;

public interface AddressService {

    public List getAllAddressByUserId(int userId);

    public boolean update(Address newAddress);

    public boolean add(Address newAddress);

    public boolean deleteById(int id);
}

