package com.endwas.service;

import com.endwas.entity.Type;

import java.util.List;

/**
 * @author ：endwas
 * @description：文字分类业务层接口
 * @date ：Created in 2021/1/10 16:23
 * @url ：https://endwas.cn
 * @version： 1.0
 */
public interface TypeService {
    List<Type> getAllType();

    Type getType(Long id);

    Type getTypeByName(String name);

    int saveType(Type type);

    int updateType(Type type);

    void deleteType(Long id);

    List<Type> getAllTypeAndBlog();
}
