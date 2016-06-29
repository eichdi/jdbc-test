package ru.test.jdbc.user.dao;

import ru.test.jdbc.user.model.User;

import java.util.List;

/**
 * Created by SOTI on 25.05.2016.
 */
public interface UsersDao {
    List findAll();
    List<User> findByName(String name);
    String findNameById(int id);
    User findeUserById(int id);
    void insert(User user);
    void update(User user, int id);
    void delete(User user);
    void delete(int id);
}
