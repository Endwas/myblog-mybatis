package com.endwas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：endwas
 * @description：关于我页面控制层
 * @date ：Created in 2021/1/13 11:42
 * @url ：https://endwas.cn
 * @version： 1.0
 */
@Controller
public class AboutShowController {
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
