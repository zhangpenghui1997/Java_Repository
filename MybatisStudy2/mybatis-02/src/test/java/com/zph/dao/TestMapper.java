package com.zph.dao;

import com.zph.pojo.Blog;
import com.zph.utils.IDutils;
import com.zph.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class TestMapper {

    @Test
    public void test(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog1=new Blog(IDutils.getUUID(),"Java程序设计","张三",new Date(),1);
        mapper.addBlog(blog1);

        Blog blog2=new Blog(IDutils.getUUID(),"C++程序设计","王五",new Date(),2);
        mapper.addBlog(blog2);

        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,String> map=new HashMap<String, String>();
        //map.put("author","张三");

        List<Blog> blog1 = mapper.findBlog(map);
        for (Blog blog2 : blog1) {
            System.out.println(blog2);
        }
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,String> map=new HashMap<String, String>();
        map.put("title","C++程序设计");
        map.put("views","10");
        List<Blog> blogs = mapper.queryByChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("title","Java编程思想");
        map.put("id","37e2f884d6c3488dbc94ea6b0c118c63");
        map.put("views",200);
        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void test5(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("37e2f884d6c3488dbc94ea6b0c118c63");
        arrayList.add("2");
        arrayList.add("3");
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("ids",arrayList);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
       sqlSession.close();
    }
}
