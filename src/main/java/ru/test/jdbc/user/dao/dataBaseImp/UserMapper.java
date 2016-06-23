package ru.test.jdbc.user.dao.dataBaseImp;

import org.springframework.jdbc.core.RowMapper;
import ru.test.jdbc.user.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SOTI on 21.06.2016.
 */
public class UserMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User(
                resultSet.getString("name"),
                resultSet.getString("info"),
                resultSet.getString("email"),
                resultSet.getLong("id"),
                resultSet.getInt("bornyear"),
                resultSet.getBoolean("sex"));
        return user;
    }
}
