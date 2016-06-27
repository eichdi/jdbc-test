package ru.test.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.test.jdbc.user.dao.UserDaoDBImpl;
import ru.test.jdbc.user.dao.UsersDao;
import ru.test.jdbc.user.model.User;

import java.util.List;

/**
 * Created by SOTI on 20.06.2016 9:40.
 */
public class Program {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:beans.xml");
        ctx.refresh();
        UsersDao usersDao = ctx.getBean("usersDao", UsersDao.class);
        List<User> userList = usersDao.findAll();
        for (User user :
                userList) {
            System.out.print(user.toString());
        }

    }
}
