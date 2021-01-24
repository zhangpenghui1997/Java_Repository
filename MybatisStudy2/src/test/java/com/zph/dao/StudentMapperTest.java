package com.zph.dao;

import com.zph.pojo.Student;
import com.zph.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {





    @Test
    public void test1(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentAndTeacherInfo = mapper.getStudentAndTeacherInfo();
        for (Student student : studentAndTeacherInfo) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentAndTeacherInfo = mapper.getStudentAndTeacherInfo2();
        for (Student student : studentAndTeacherInfo) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
