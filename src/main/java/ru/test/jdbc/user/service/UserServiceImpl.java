package ru.test.jdbc.user.service;

import org.springframework.stereotype.Service;
import ru.test.jdbc.user.model.User;

import java.util.List;

/**
 * Created by SOTI on 27.06.2016 15:09.
 */
@Service
public class UserServiceImpl implements UsersService {
    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> getUsersBySex(String sex) {
        return null;
    }

    @Override
    public List<User> getUsersByAge(int age) {
        return null;
    }
}
