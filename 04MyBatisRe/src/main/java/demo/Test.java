package demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mycom on 2018/3/9.
 */
public class Test {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("");
        Matcher matcher=pattern.matcher("");
        System.out.println(matcher.replaceAll(""));
    }
}
