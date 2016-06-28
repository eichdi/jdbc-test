package ru.test.jdbc.user.service;

import ru.test.jdbc.user.model.User;

import java.util.List;

public interface UsersService {

    int addUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    List<User> getUsersBySex(String sex);

    List<User> getUsersByAge(int age);
}
