package com.endwas.dao;

import com.endwas.entity.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：endwas
 * @description：友链管理持久层接口
 * @date ：Created in 2021/1/12 10:42
 * @url ：https://endwas.cn
 * @version：
 */
@Mapper
@Repository
public interface FriendLinkDao {
    List<FriendLink> listFriendLink();

    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    int saveFriendLink(FriendLink friendLink);

    Object getFriendLink(Long id);

    int updateFriendLink(FriendLink friendLink);

    void deleteFriendLink(Long id);
}
