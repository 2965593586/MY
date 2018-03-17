package demoEmail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mycom on 2018/3/9.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://tieba.baidu.com/p/4529628420");
        // 打开连接
        URLConnection conn = url.openConnection();
        // 设置连接网络超时时间
        conn.setConnectTimeout(1000 * 10);
        // 读取指定网络地址中的文件
        BufferedReader bufr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = null;
        String reg = "[a-zA-Z0-9_-]+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        Pattern p = Pattern.compile(reg);
        while ((line = bufr.readLine()) != null) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                System.out.println(m.group());
            }
        }
    }
}
