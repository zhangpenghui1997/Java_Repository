package com.zph.dao;

import com.zph.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入博客
    int addBlog(Blog blog);

    //查询博客
    List<Blog> findBlog(Map<String,String> map);

    List<Blog> queryByChoose(Map<String,String> map);

    int updateBlog(Map map);

    List<Blog> queryBlogForeach(Map map);

}
