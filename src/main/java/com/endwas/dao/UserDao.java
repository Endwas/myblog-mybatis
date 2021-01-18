package com.endwas.dao;

import com.endwas.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ：endwas
 * @description：用户持久层接口
 * @date ：Created in 2021/1/10 18:23
 * @url ：https://endwas.cn
 * @version： 1.0
 */
@Mapper
@Repository
public interface UserDao {
    User findByUsernameAndPassword(String username, String password);
}
