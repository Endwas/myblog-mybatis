package com.endwas.controller.admin;

import com.endwas.entity.User;
import com.endwas.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: 用户登录控制器
 * @Author: endwas
 * @Date: Created in 2021/1/10 16:19
 * @url ：https://endwas.cn:
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
   

    @Autowired
    private UserService userService;

    /**
     * @Description: 跳转登录页面
     * @Auther: endwas
     * @Date: 2021/1/10 16:19
     * @Param:
     * @Return: 返回登录页面
     */
    @GetMapping
    public String loginPage(HttpServletRequest httpServletRequest){
   
      
        return "admin/login";
    }

    /**
     * @Description: 登录校验
     * @Auther: endwas
     * @Date: 2021/1/10 16:19
     * @Param: username:用户名
     * @Param: password:密码
     * @Param: session:session域
     * @Param: attributes:返回页面消息
     * @Return: 登录成功跳转登录成功页面，登录失败返回登录页面
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpServletRequest httpServletRequest,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);

        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
           

            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
         
            return "redirect:/admin";
        }
    }

    /**
     * @Description: 注销
     * @Auther: endwas
     * @Date: 2021/1/10 16:19
     * @Param: session:session域
     * @Return: 返回登录页面
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
