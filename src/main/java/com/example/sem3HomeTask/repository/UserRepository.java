package com.example.sem3HomeTask.repository;

import com.example.sem3HomeTask.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;
    private static final String SQL_SAVE_USER = "INSERT INTO userTable VALUES (NULL, ?, ?, ?)";
    private static final String SQL_GET_ALL_USERS = "SELECT * FROM userTable";

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Сохранения пользователя в бд.
     * @param user объект пользователя.
     * @return объект сохраненного пользователя.
     */
    public User saveUser(User user){
        jdbc.update(SQL_SAVE_USER, user.getName(), user.getAge(), user.getEmail());
        return user;
    }

    /**
     * Получение всех пользователей из бд.
     * @return список всех пользователей.
     */
    public List<User> getUsers() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbc.query(SQL_GET_ALL_USERS , userRowMapper);
    }



}
