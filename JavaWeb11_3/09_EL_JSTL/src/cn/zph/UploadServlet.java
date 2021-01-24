package cn.zph;



import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("文件上传过来了get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("文件上传过来了post");
       /* ServletInputStream inputStream = req.getInputStream();
        byte[] buffer=new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            System.out.println(new String(buffer,0,len));
        }*/
       //1.判断上传的数据是否是多段数据
        if(ServletFileUpload.isMultipartContent(req)){
            //创建FileItemFactory实现类
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : list) {
                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name值："+fileItem.getFieldName());
                        //参数utf-8解决乱码问题
                        System.out.println("表单项的value值："+fileItem.getString("UTF-8"));
                    }else {
                        //上传的文件
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());
                        System.out.println("上传的文件名："+fileItem.getName());
                        //fileItem.write(new File("E:\\"+fileItem.getName()));
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
