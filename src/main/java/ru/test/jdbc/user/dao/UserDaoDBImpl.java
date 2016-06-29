package ru.test.jdbc.user.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.test.jdbc.user.model.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoDBImpl implements UsersDao, InitializingBean {

    @Autowired
    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private static final Log log = LogFactory.getLog(UserDaoDBImpl.class);

    private static final String selectAllSql = "SELECT * FROM userinfo ";
    private static final String selectByNameSql = "SELECT * FROM userinfo WHERE name=:userName";
    private static final String selectNameByIdSql = "SELECT name FROM userinfo WHERE id = :userId";
    private static final String selectUserByIdSql = "SELECT * FROM userinfo WHERE id = :userId";
    private static final String insertUserSql = "INSERT INTO userinfo (name, info, email, bornyear, sex) values (:userName+, :userInfo, :userEmail, :userBornyear, :userSex)";
    private static final String updeteUserSql = "UPDATE userinfo SET name = :userName, info = :userInfo, email = :userEmail, bornyear = :userBornyear, sex = :userSex WHERE id = :userId";
    private static final String deleteUserSql = "DELETE FROM userinfo WHERE id = :userId";

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll() {
        log.info("findAll");
        return jdbcTemplate.query(selectAllSql,new HashMap(),new UserMapper());
    }

    @Override
    public List<User> findByName(String name) {
        Map<String, String> namedParam= new HashMap<>();
        namedParam.put("userName",name);
        return jdbcTemplate.query(selectByNameSql, namedParam, new UserMapper());
    }

    @Override
    public String findNameById(int id){
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("userId",id);
        String result;
        //на случай если нет такого id
        try{
            result = (String) jdbcTemplate.queryForObject(selectNameByIdSql,namedParam,String.class);
        }
        catch (Exception e){
            result = "noresult";
        }
        return  result;
    }

    @Override
    public User findeUserById(int id) {
        Map<String, Object> namedParam= new HashMap<>();
        namedParam.put("userId",id);
        log.info("userId param = "+id);
        List<User> resultList =  jdbcTemplate.query(selectUserByIdSql, namedParam, new UserMapper());
        return resultList.get(0);
    }

    @Override
    public void insert(User user) {
        Map<String, Object> namedParam = new HashMap<>();
        //TODO вынести заполнение карты
        namedParam.put("userName", user.getName());
        namedParam.put("userInfo", user.getInfo());
        namedParam.put("userEmail", user.getEmail());
        namedParam.put("userBornyear", user.getBornYear());
        namedParam.put("userSex", user.isSex());

        jdbcTemplate.update(insertUserSql,namedParam);
    }

    @Override
    public void update(User user, int id) {
        Map<String, Object> namedParam = new HashMap<>();
        //TODO вынести заполнение карты
        namedParam.put("userName", user.getName());
        namedParam.put("userInfo", user.getInfo());
        namedParam.put("userEmail", user.getEmail());
        namedParam.put("userBornyear", user.getBornYear());
        namedParam.put("userSex", user.isSex());
        namedParam.put("userId",id);

        jdbcTemplate.update(updeteUserSql,namedParam);
    }

    @Override
    public void delete(User user) {
        this.delete(user.getId());
    }

    @Override
    public void delete(int id) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("userId",id);

        jdbcTemplate.update(deleteUserSql,namedParam);
    }

    //Реализация InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null){
            throw new BeanCreationException("Must set DataSourse on UserDao");
        }
    }
}
