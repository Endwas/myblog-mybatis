package com.endwas.controller;

import com.endwas.queryvo.BlogQuery;
import com.endwas.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author ：endwas
 * @description：时间轴页面显示控制层
 * @date ：Created in 2021/1/12 17:44
 * @url ：https://endwas.cn
 * @version： 1.0
 */
@Controller
public class ArchiveShowController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archive(Model model){
        List<BlogQuery> blogs = blogService.getAllBlog();
        model.addAttribute("blogs", blogs);
        return "archives";
    }
}
