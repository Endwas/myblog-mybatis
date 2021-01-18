package com.endwas.service;

import com.endwas.entity.Message;

import java.util.List;

/**
 * @author ：endwas
 * @description：留言页面服务层接口
 * @date ：Created in 2021/1/12 19:03
 * @url ：https://endwas.cn
 * @version： 1.0
 */
public interface MessageService {

    void deleteMessage(Long id);

    List<Message> listMessage();

    int saveMessage(Message message);
}
