package com.ph.shopping.common.util.regeximg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @package : com.ph.shopping.common.util.regeximg
 * @progect : factoring-parent
 * @Description :
 * @Created by : hangxin
 * @Creation Date ：2017年12月01日18:27
 * @author hangxin
 */
public class RegexImg {

    private static String regeximg = "<(?!img)[^>]*>";

    private static String a = "<img src=\"";

    private static String b = "\" alt=\"\" />";

    private static String c = "&nbsp;";

    private static String d = "\n";

    private static String e = "\r";

    private static String f = "\t";

    public static String sssss(String regexstring){
        regexstring = regexstring.replaceAll(d , "");
        regexstring = regexstring.replaceAll(e , "");
        regexstring = regexstring.replaceAll(f , "");
        Pattern pattern = Pattern.compile(regeximg);
        Matcher matcher = pattern.matcher(regexstring);
        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        while (result1) {
            matcher.appendReplacement(sb, "");
            result1 = matcher.find();
        }
        matcher.appendTail(sb);
        String str = strs(sb.toString());
        return str;
    }

    public static String strs(String sb){
        String imgs = sb.replaceAll(a,"=");
        String imges = imgs.replaceAll(b,"=");
        String img = imges.replaceAll(c,"");
        return img.trim();
    }

}
