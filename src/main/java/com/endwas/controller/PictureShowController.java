package com.endwas.controller;

import com.endwas.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：endwas
 * @description：图片展示控制层
 * @date ：Created in 2021/1/13 11:33
 * @url ：https://endwas.cn
 * @version： 1.0
 */
@Controller
public class PictureShowController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("/picture")
    public String friends(Model model) {
        model.addAttribute("pictures",pictureService.listPicture());
        return "picture";
    }

}
