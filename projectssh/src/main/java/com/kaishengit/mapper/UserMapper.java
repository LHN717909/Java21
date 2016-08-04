package com.kaishengit.mapper;

import com.kaishengit.pojo.User;

/**
 * Created by lhn on 2016/7/30.
 */
public interface UserMapper {

    User findById(Integer id);
    void save(User user);
    User findByName(String name);
}
