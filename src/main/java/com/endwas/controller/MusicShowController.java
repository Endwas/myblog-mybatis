package com.endwas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：endwas
 * @description：音乐盒页面控制层
 * @date ：Created in 2021/1/12 17:57
 * @url ：https://endwas.cn
 * @version： 1.0
 */
@Controller
public class MusicShowController {
    @GetMapping("/music")
    public String about() {
        return "music";
    }
}
