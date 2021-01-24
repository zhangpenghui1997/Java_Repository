
import cn.zph.eshop.common.util.FileUtil;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        String filePath = "db/db_user.txt";
        filePath = FileUtil.class.getClassLoader().getResource(filePath).getFile();
        System.out.println(filePath);
        File file = new File("db/db_user.txt");
        System.out.println(file.exists());
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String str = br.readLine();
            while (str != null) {
                System.out.println(str);
                str=br.readLine();
            }
            br.close();

        }
    }
}
