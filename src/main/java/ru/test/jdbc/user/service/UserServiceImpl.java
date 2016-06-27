package ru.test.jdbc.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.jdbc.user.model.User;

import java.util.List;

/**
 * Created by SOTI on 27.06.2016 15:09.
 */
@Service
public class UserServiceImpl implements UsersService {
    @Transactional
    public int addUser(User user) {
        return 0;
    }

    @Transactional
    public User getUserById(int id) {
        return null;
    }

    @Transactional
    public List<User> getAllUsers() {
        return null;
    }

    @Transactional
    public List<User> getUsersBySex(String sex) {
        return null;
    }

    @Transactional
    public List<User> getUsersByAge(int age) {
        return null;
    }
}
