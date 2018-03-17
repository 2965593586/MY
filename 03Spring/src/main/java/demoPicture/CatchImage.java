package demoPicture;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mycom on 2018/3/9.
 */
public class CatchImage {
    //你要抓取那个网页的地址
    private static final String URL="http://www.ivsky.com/tupian/jianshen_t2148/";
    //设置字符编码
    private static final String encoding="utf-8";
    //获取img的正则编码
    private static final String imgUrl="<img.*src=(.*?)[^>]*?>";
    //图片src的正则
    private static final String imgSrc="http:\\\"?(.*?)(\\\"|>|\\\\s+)";


    /**
     * 使用main方法测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        CatchImage cm = new CatchImage();
        //获得html文本内容
        String HTML = cm.getHTML(URL);
        //获取图片标签
        List<String> imgUrl = cm.getImageUrl(HTML);
        //获取图片src地址
        List<String> imgSrc = cm.getImageSrc(imgUrl);
        //下载图片
        cm.Download(imgSrc);
    }




    /***
     * 获取HTML内容
     *
     * @param url
     * @return
     * @throws Exception
     */
    private String getHTML(String url) throws Exception {
        URL uri = new URL(url);
        URLConnection connection = uri.openConnection();
        InputStream in = connection.getInputStream();
        byte[] buf = new byte[1024];
        int length = 0;
        StringBuffer sb = new StringBuffer();
        while ((length = in.read(buf, 0, buf.length)) > 0) {
            sb.append(new String(buf, encoding));
        }
        in.close();
        return sb.toString();
    }

    /***
     * 获取ImageUrl地址
     *
     * @param HTML
     * @return
     */
    private List<String> getImageUrl(String HTML) {
        Matcher matcher = Pattern.compile(imgUrl).matcher(HTML);
        List<String> listImgUrl = new ArrayList<String>();
        while (matcher.find()) {
            listImgUrl.add(matcher.group());
        }
        return listImgUrl;
    }

    /***
     * 获取ImageSrc地址
     *
     * @param listImageUrl
     * @return
     */
    private List<String> getImageSrc(List<String> listImageUrl) {
        List<String> listImgSrc = new ArrayList<String>();
        for (String image : listImageUrl) {
            Matcher matcher = Pattern.compile(imgSrc).matcher(image);
            System.out.println("imgSrc"+imgSrc);
            while (matcher.find()) {
                listImgSrc.add(matcher.group().substring(0, matcher.group().length() - 1));
            }
        }
        return listImgSrc;
    }


    /***
     * 下载图片
     *
     * @param listImgSrc
     */
    private void Download(List<String> listImgSrc) {
        try {
            for (String url : listImgSrc) {
                String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
                URL uri = new URL(url);
                InputStream in = uri.openStream();
                FileOutputStream fo = new FileOutputStream(new File(imageName));
                byte[] buf = new byte[1024];
                int length = 0;
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                in.close();
                fo.close();
                System.out.println(imageName + "下载完成");
            }
        } catch (Exception e) {
            System.out.println("下载失败");
        }
    }




}
