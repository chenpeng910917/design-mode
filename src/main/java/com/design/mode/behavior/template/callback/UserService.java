package com.design.mode.behavior.template.callback;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * 用户信息
 *
 * @author chenpeng
 */
public class UserService {

    private JdbcTemplate jdbcTemplate;

    /**
     * 查询用户信息
     * @return 用户信息
     */
    public List<User> queryUser(Long id) {
        String sql = "select * from user where id=" + id;

//        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
//        List<User> query = jdbcTemplate.query(sql, rowMapper, id);

        List<User> query = jdbcTemplate.query(sql, new UserRowMapper());
        return query;
    }
}
