package ru.test.jdbc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.jdbc.user.dao.UsersDao;
import ru.test.jdbc.user.model.User;

import java.util.List;

/**
 * Created by SOTI on 27.06.2016 15:09.
 */
@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    private UsersDao userDao;

    public int addUser(User user) {
        return 0;
    }

    public User getUserById(int id) {
        return null;
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public List<User> getUsersBySex(String sex) {
        return null;
    }

    public List<User> getUsersByAge(int age) {
        return null;
    }
}
