package cn.zph;



import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.UUID;

public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取要下载的文件
        String downloadFileName = "皮卡丘.jpg";
        //2.读取要下载的文件(通过ServletContext对象)
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("下载的文件类型：" + mimeType);
        if(request.getHeader("User-Agent").contains("Firefox")){
            //火狐浏览器
            System.out.println("Firefox Browser");
        }else if(request.getHeader("User-Agent").contains("Chrome")){
            //谷歌浏览器
            System.out.println("Chrome Browser");

        }
        //3.在回传之前，通过响应头告诉客户端返回的数据类型
        response.setContentType(mimeType);
        //4.告诉客户端收到的数据使用于下载使用，还是使用响应头
        //response.setHeader("Content-Disposition","attachment; filename=?UTF-8?B"+new BASE64Encoder().encode(downloadFileName.getBytes("UTF-8"))+"?=");//base64编码
        response.setHeader("Content-Disposition","attachment; filename="+URLEncoder.encode(downloadFileName,"UTF-8"));//URL编码
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);

        //5.把下载的文件回传给客户端
        OutputStream outputStream = response.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);



    }

    /*public static void main(String[] args) throws Exception{
        String str="这是待编码的字符串";
        BASE64Encoder base64Encoder=new BASE64Encoder();
        String base64EncodeResult=base64Encoder.encode(str.getBytes());
        System.out.println(base64EncodeResult);
        BASE64Decoder base64Decoder=new BASE64Decoder();
        byte[] base64DecodeResult=base64Decoder.decodeBuffer(base64EncodeResult);
        System.out.println(new String(base64DecodeResult));
    }
*/

}
