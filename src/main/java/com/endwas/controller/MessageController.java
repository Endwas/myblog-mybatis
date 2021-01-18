package com.endwas.controller;

import com.endwas.entity.Message;
import com.endwas.entity.User;
import com.endwas.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：endwas
 * @description：留言页面控制层
 * @date ：Created in 2021/1/12 19:02
 * @url ：https://endwas.cn
 * @version： 1.0
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Value("${message.avatar}")
    private String avatar;

    @GetMapping("/message")
    public String message() {
        return "message";
    }

    // 查询留言
    @GetMapping("/messagecomment")
    public String messages(Model model) {
        List<Message> messages = messageService.listMessage();
        model.addAttribute("comments", messages);
        return "message::commentList";
    }

    // 新增留言
    @PostMapping("/message")
    public String post(Message message, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        //设置头像
        if (user != null) {
            message.setAvatar(user.getAvatar());
            message.setAdminMessage(true);
        } else {
            message.setAvatar(avatar);
        }
        if (message.getParentMessageId() == null) {
            message.setParentMessageId((long) -1);
        }
        messageService.saveMessage(message);
        List<Message> messages = messageService.listMessage();
        model.addAttribute("comments", messages);
        return "message::commentList";
    }

    // 删除留言
//    @GetMapping("/messages/{id}/delete")
//    public String delete(@PathVariable Long id, RedirectAttributes attributes, Model model){
//        messageService.deleteMessage(id);
//        return "redirect:/message";
//    }
}
