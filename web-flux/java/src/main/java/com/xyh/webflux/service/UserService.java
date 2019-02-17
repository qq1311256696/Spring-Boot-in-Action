package com.xyh.webflux.service;

import com.xyh.webflux.model.User;

import java.util.List;

public interface UserService {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<User> findAllCity();

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    User findCityById(Long id);

    /**
     * 新增城市信息
     *
     * @param user
     * @return
     */
    Long saveCity(User user);

    /**
     * 更新城市信息
     *
     * @param user
     * @return
     */
    Long updateCity(User user);

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    Long deleteCity(Long id);
}