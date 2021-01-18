package com.endwas.service;

import com.endwas.entity.User;

/**
 * @author ：endwas
 * @description：用户服务层接口
 * @date ：Created in 2021/1/10 18:20
 * @url ：https://endwas.cn
 * @version： 1.0
 */
public interface UserService {
    User checkUser(String username, String password);
}
