package com.xyh.webflux.service;

import com.xyh.webflux.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAllCity() {
        return jdbcTemplate.query("select uid, nickname from user",  new Object[]{}, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User findCityById(Long id) {
        return null;
    }

    @Override
    public Long saveCity(User user) {
        return null;
    }

    // 测试事务 先删除再操作失败
    @Override
    @Transactional
    public Long updateCity(User user) {
        jdbcTemplate.execute("delete from user where mobile='18810686819'");
        jdbcTemplate.execute("insert into user (uid) values (35370118372528128)" );
        return null;
    }

    @Override
    public Long deleteCity(Long id) {
        return null;
    }
}