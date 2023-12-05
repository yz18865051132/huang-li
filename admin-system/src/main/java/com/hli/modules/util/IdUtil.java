package com.hli.modules.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 框架中自定义方法
 * @Author MARS
 */
public class IdUtil {
    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    private static final String CAPIYSL_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SMALL_LETTER = "abcdefghijklmnopqrstuvwxyz";
    private static final String FIGURE = "0123456789";

    /**
     * md5加密
     * @param str
     * @return
     */
    public static String getMD5Str(String str) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest  = md5.digest(str.getBytes("utf-8"));
        }catch (Exception e) {
           e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        return md5Str;
    }
    /**
     * 获取6位数，大写+小写+数字的随机数
     * @return
     */
    public static String random (){
        return SALT(6,0);
    }
    /**
     * 获取x位数，大写+小写+数字的随机数
     * @return
     */
    public static String random (int x){
        return SALT(x,0);
    }
    /**
     * 获取x位数，大写、小写、数字任意组合的随机数
     * @return
     */
    public static String random (int x,int y){
        return SALT(x,y);
    }
    /**
     * 后去32位的uuid
     * @return
     */
    public static String UUID(){
        String uuid = UUID.randomUUID().toString();
        //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
        return uuid.replace("-", "");
    }
    /**
     *  驼峰转下划线
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        String substring = sb.toString().substring(0);
        return substring;
    }
    /**
     * 获取随机码
     * @param x 需要随机码的长度
     * @param y 随机码的组合方式（0、数字+小写+大写;1、小写+数字;2、大写+数字;3、小写加大写;4、小写;5、大写;6、数字;）
     * @return
     */
    public static String SALT(int x,int y){
        String str = "";
        if(0 == y){
            str = CAPIYSL_LETTER + SMALL_LETTER + FIGURE;
        }else if(1 == y){
            str = SMALL_LETTER + FIGURE;
        }else if(2 == y){
            str = CAPIYSL_LETTER + FIGURE;
        }else if(3 == y){
            str = CAPIYSL_LETTER + SMALL_LETTER;
        }else if(4 == y){
            str = SMALL_LETTER;
        }else if(5 == y){
            str = CAPIYSL_LETTER;
        }else if(6 == y){
            str = FIGURE;
        }else {
            return "";
        }
        StringBuilder sb = new StringBuilder(x);
        for(int i = 0;i < x; i++)
        {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * 下划线转驼峰法
     * @param line 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰
     * @return 转换后的字符串
     */
    public static String calemToLine(String line,boolean smallCamel){
        if(line==null||"".equals(line)){
            return "";
        }
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(smallCamel&&matcher.start()==0?Character.toLowerCase(word.charAt(0)):Character.toUpperCase(word.charAt(0)));
            int index=word.lastIndexOf('_');
            if(index>0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }
}
