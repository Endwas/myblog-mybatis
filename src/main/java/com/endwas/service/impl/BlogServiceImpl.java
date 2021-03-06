package com.endwas.service.impl;

import com.endwas.NotFoundException;
import com.endwas.dao.BlogDao;
import com.endwas.entity.Blog;
import com.endwas.queryvo.*;
import com.endwas.service.BlogService;
import com.endwas.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：endwas
 * @description：博客列表业务层接口实现类
 * @date ：Created in 2021/1/10 10:50
 * @url ：https://endwas.cn
 * @version: 1.0
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;


    @Override
    public ShowBlog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }

    @Override
    public List<BlogQuery> getAllBlog() {
        return blogDao.getAllBlogQuery();
    }

    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteBlog(id);
    }

    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogDao.getFirstPageBlog();
    }

    @Override
    public List<RecommendBlog> getRecommendedBlog() {
        List<RecommendBlog> allRecommendBlog = blogDao.getAllRecommendBlog();
        return allRecommendBlog;
    }

    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
//        System.out.println(id);
        DetailedBlog detailedBlog = blogDao.getDetailedBlog(id);
        if (detailedBlog == null) {
            try {
                throw new NotFoundException("该博客不存在");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
//        文章访问数量自增
        blogDao.updateViews(id);
//        文章评论数量更新
        blogDao.getCommentCountById(id);
        return detailedBlog;
    }

    @Override
    public List<FirstPageBlog> getByTypeId(Long typeId) {
        return blogDao.getByTypeId(typeId);
    }

    @Override
    public Integer getBlogTotal() {
        return blogDao.getBlogTotal();
    }

    @Override
    public Integer getBlogViewTotal() {
        return blogDao.getBlogViewTotal() == null ? 0 : blogDao.getBlogViewTotal();
    }

    @Override
    public Integer getBlogCommentTotal() {
        return blogDao.getBlogCommentTotal();
    }

    @Override
    public Integer getBlogMessageTotal() {

        return blogDao.getBlogMessageTotal();
    }

    @Override
    public List<BlogQuery> getBlogBySearch(SearchBlog searchBlog) {
        return blogDao.searchByTitleOrTypeOrRecommend(searchBlog);
    }

    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogDao.updateBlog(showBlog);
    }

    @Override
    public int saveBlog(Blog blog) {
        if ("".equals(blog.getFlag())){
            blog.setFlag("原创");
        }
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogDao.saveBlog(blog);
    }
}
