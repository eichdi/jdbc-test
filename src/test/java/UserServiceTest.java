import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.test.jdbc.user.controllers.UserController;
import ru.test.jdbc.user.dao.UsersDao;
import ru.test.jdbc.user.model.User;
import ru.test.jdbc.user.service.UserServiceImpl;
import ru.test.jdbc.user.service.UsersService;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by SOTI on 29.06.2016 17:45.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {


    @Mock
    private UsersDao usersDao;

    @InjectMocks
    private UserServiceImpl service;

    public UserServiceTest(){

    }

    public static User anyUser (){
        return new User("name","info","email",1,2000,true);
    }

    @Before
    public void setUp(){
        when(usersDao.findeUserById(0)).thenReturn(anyUser());
    }

    @Test
    public void testGetUserById(){
        User user = service.getUserById(anyInt());
        verify(usersDao).findeUserById(0);
    }

}
