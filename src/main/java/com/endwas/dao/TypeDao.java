package com.endwas.dao;

import com.endwas.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：endwas
 * @description：文章分类持久层接口
 * @date ：Created in 2021/1/10 16:26
 * @url ：https://endwas.cn
 * @version：1.0
 */
@Mapper
@Repository
public interface TypeDao {
    List<Type> getAllType();

    Type getType(Long id);

    Type getTypeByName(String name);

    int saveType(Type type);

    int updateType(Type type);

    void deleteType(Long id);

    List<Type> getAllTypeAndBlog();
}
