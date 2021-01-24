package com.zph.dao;

import com.zph.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    //查询所有的学生信息以及对应的老师信息
    List<Student> getStudentAndTeacherInfo();
    List<Student> getStudentAndTeacherInfo2();
}
