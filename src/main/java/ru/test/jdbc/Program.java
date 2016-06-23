package ru.test.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.test.jdbc.user.dao.UsersDao;
import ru.test.jdbc.user.model.User;

import java.util.List;

/**
 * Created by SOTI on 20.06.2016 9:40.
 */
public class Program {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UsersDao usersDao = applicationContext.getBean("userDao", UsersDao.class);
        List<User> userList = usersDao.findByName("Igor");
        usersDao.delete(userList.get(0));
        userList = usersDao.findAll();
        for (User user :
                userList) {
            System.out.print(user.toString());
        }

    }
}
