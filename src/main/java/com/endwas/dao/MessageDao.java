package com.endwas.dao;

import com.endwas.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：endwas
 * @description：留言信息持久层接口
 * @date ：Created in 2021/1/12 19:07
 * @url ：https://endwas.cn
 * @version： 1.0
 */
@Mapper
@Repository
public interface MessageDao {
    List<Message> findByParentIdNull(long parseLong);

    List<Message> findByParentIdNotNull(Long id);

    List<Message> findByReplayId(Long childId);

    int saveMessage(Message message);
}
