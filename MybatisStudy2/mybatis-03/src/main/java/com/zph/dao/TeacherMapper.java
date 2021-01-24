package com.zph.dao;

import com.zph.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
   List<Teacher> getTeacher();

   Teacher getTeacherById(@Param("tid") int id);

   Teacher getTeacherById2(@Param("tid") int id);
}
