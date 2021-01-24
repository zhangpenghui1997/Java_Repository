package cn.zph.eshop.common.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileUtil {

    /*
     * 用字符缓冲流读取文件内容转成字符串并返回*/
    public static String readByBuffered(String filePath) throws Exception {
        StringBuilder sb = new StringBuilder();
        filePath="src/"+filePath;
        //使用ClassLoader加载资源，路径从src
        //filePath = FileUtil.class.getClassLoader().getResource(filePath).getFile();
        File file = new File(filePath);
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String str = br.readLine();
            while (str != null) {
                sb.append(str);
                str=br.readLine();
            }
            br.close();
            return sb.toString();
        }
        return null;
    }
}
