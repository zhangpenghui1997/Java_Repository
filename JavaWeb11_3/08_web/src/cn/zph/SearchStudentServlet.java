package cn.zph;

import com.zph.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取前端的请求参数
        //2.通过sql向数据库中查询数据
        //以上两步使用for循环模拟
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i < 10; ++i) {
            int t = i + 1;
            studentList.add(new Student(t, "name" + t, 18 + t, "phone" + t));
        }

        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/showStudent.jsp").forward(request,response);
    }
}
