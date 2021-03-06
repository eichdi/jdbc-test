import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.test.jdbc.user.dao.UsersDao;
import ru.test.jdbc.user.model.User;
import ru.test.jdbc.user.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
/**
 * Created by SOTI on 29.06.2016 17:45.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {


    @Mock
    private UsersDao usersDao;

    @InjectMocks
    private UserServiceImpl service;

    public void UserEquals(User expected, User actual){
        assertEquals(expected.getBornYear(),actual.getBornYear());
        assertEquals(expected.getEmail(),actual.getEmail());
        assertEquals(expected.getInfo(),actual.getInfo());
        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.isSex(),actual.isSex());
        assertEquals(expected.isSex(),actual.isSex());
        assertEquals(expected.getId(),actual.getId());
    }

    public UserServiceTest(){

    }


    public static User anyUser (){
        return new User("name","info","email",1,2000,true);
    }

    public static List<User> userList(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("name","info","email",1,2000,true));
        userList.add(new User("name1","info1","email1",2,2001,false));
        return  userList;
    }

    @Before
    public void setUp(){
        when(usersDao.findeUserById(0)).thenReturn(anyUser());
        when(usersDao.findAll()).thenReturn(userList());
        when(usersDao.findNameById(0)).thenReturn("name");
    }

    @Test
    public void testGetUserById(){
        User actual = service.getUserById(anyInt());
        User expected = anyUser();
        UserEquals(expected, actual);
    }

    @Test
    public void testGetAllUsers(){
        List<User> actual = service.getAllUsers();
        List<User> expected = userList();
        assertEquals(actual.size(),expected.size());
        for (int i=0; i<actual.size(); i++){
            UserEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testGetNameById(){
        String actual = service.getNameById(0);
        String expected = "user";
        assertEquals(expected, actual);
    }


}
