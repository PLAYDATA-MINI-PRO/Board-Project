package com.board.dao;

import com.board.domain.requset.SignupRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Integer signup(SignupRequest signupRequest){
        String sql = "insert into user(username,password,name) value(?,?,?)";
        return jdbcTemplate.update(
                sql,signupRequest.getUsername(),signupRequest.getPassword(),signupRequest.getName() );
    }
}
