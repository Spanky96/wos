package top.spanky.wos.dao;

import top.spanky.wos.model.User;

public interface UserDao {
	public User getByUsername(String username);
}
