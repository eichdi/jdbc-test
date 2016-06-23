package ru.test.jdbc.user;

import ru.test.jdbc.user.dao.fileImpl.UsersDaoFileImpl;
import ru.test.jdbc.user.model.User;

import java.io.File;
import java.util.List;

public class UsersService {
    //TODO use interface
    public UsersDaoFileImpl userDao;

    public  UsersService(){

        userDao = new UsersDaoFileImpl(new File("").getAbsolutePath()+"\\user");
        //userDao = new UsersDaoFileImpl(path);
    }
    public void addUser(User user){
        userDao.addUser(user);
    }

    public User findUserbyName(String name){
        List<User> users = userDao.findAll();
        for (User user:
             users) {
            if(user.getName().equals(name)){
                return user;
            }

        }
        return null;
    }
}
