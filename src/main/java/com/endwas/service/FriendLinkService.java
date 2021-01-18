package com.endwas.service;

import com.endwas.entity.FriendLink;

import java.util.List;

/**
 * @author ：endwas
 * @description：友链管理服务层接口
 * @date ：Created in 2021/1/12 10:43
 * @url ：https://endwas.cn
 * @version： 1.0
 */
public interface FriendLinkService {

    List<FriendLink> listFriendLink();

    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    int saveFriendLink(FriendLink friendLink);

    Object getFriendLink(Long id);

    int updateFriendLink(FriendLink friendLink);

    void deleteFriendLink(Long id);
}
