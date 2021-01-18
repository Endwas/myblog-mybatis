package com.endwas.service.impl;

import com.endwas.dao.UserDao;
import com.endwas.entity.User;
import com.endwas.service.UserService;
import com.endwas.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：endwas
 * @description：用户服务层接口实现类
 * @date ：Created in 2021/1/10 18:21
 * @url ：https://endwas.cn
 * @version： 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

}
