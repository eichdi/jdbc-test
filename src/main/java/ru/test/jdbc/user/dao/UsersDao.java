package ru.test.jdbc.user.dao;

import ru.test.jdbc.user.model.User;

import java.util.List;

/**
 * Created by SOTI on 25.05.2016.
 */
public interface UsersDao {
    List findAll();
    List<User> findByName(String name);
    String findNameById(Long id);
    User findeUserById(Long id);
    void insert(User user);
    void update(User user, Long id);
    void delete(User user);
    void delete(Long id);
}
