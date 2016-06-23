package ru.test.jdbc.user.dao.dataBaseImp;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.test.jdbc.user.dao.UsersDao;
import ru.test.jdbc.user.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SOTI on 21.06.2016.
 */
public class UserDaoDBImpl implements UsersDao, InitializingBean {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM \"user\"";
        return jdbcTemplate.query(sql,new HashMap(),new UserMapper());
    }

    @Override
    public List<User> findByName(String name) {
        String sql = "SELECT * FROM \"user\" WHERE name=:userName";
        Map<String, String> namedParam= new HashMap<>();
        namedParam.put("userName",name);
        return jdbcTemplate.query(sql, namedParam, new UserMapper());
    }

    public String findNameById(Long id){
        String sql = "SELECT name FROM \"user\" WHERE id = :userId";
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("userId",id);
        String result;
        //на случай если нет такого id
        try{
            result = (String) jdbcTemplate.queryForObject(sql,namedParam,String.class);
        }
        catch (Exception e){
            result = "noresult";
        }
        return  result;
    }

    @Override
    public User findeUserById(Long id) {
        String sql = "SELECT name, info, email, bornyear, sex FROM \"user\" WHERE id = :userId";
        Map<String, Object> namedParam= new HashMap<>();
        namedParam.put("userId",id);
        List<User> resultList =  jdbcTemplate.query(sql, namedParam, new UserMapper());
        return resultList.get(0);
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO \"user\" (name, info, email, bornyear, sex) values (:userName+, :userInfo, :userEmail, :userBornyear, :userSex)";

        Map<String, Object> namedParam = new HashMap<>();
        //TODO вынести заполнение карты
        namedParam.put("userName", user.getName());
        namedParam.put("userInfo", user.getInfo());
        namedParam.put("userEmail", user.getEmail());
        namedParam.put("userBornyear", user.getBornYear());
        namedParam.put("userSex", user.isSex());

        jdbcTemplate.update(sql,namedParam);
    }



    @Override
    public void update(User user, Long id) {
        String sql = "UPDATE \"user\" SET name = :userName, info = :userInfo, email = :userEmail, bornyear = :userBornyear, sex = :userSex WHERE id = :userId";

        Map<String, Object> namedParam = new HashMap<>();
        //TODO вынести заполнение карты
        namedParam.put("userName", user.getName());
        namedParam.put("userInfo", user.getInfo());
        namedParam.put("userEmail", user.getEmail());
        namedParam.put("userBornyear", user.getBornYear());
        namedParam.put("userSex", user.isSex());
        namedParam.put("userId",id);

        jdbcTemplate.update(sql,namedParam);
    }

    @Override
    public void delete(User user) {
        this.delete(user.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM \"user\" WHERE id = :userId";
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("userId",id);

        jdbcTemplate.update(sql,namedParam);
    }

    //Реализация InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null){
            throw new BeanCreationException("Must set DataSourse on UserDao");
        }
    }
}
