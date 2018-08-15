package com.ph.shopping.common.util;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;


/**
 * @author Ray Date: 15/7/11
 */
public class StrShyUtil {

    private static String hexString = "0123456789ABCDEF ";

    public static String toStr(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }
    }

    public static boolean empty(String s) {
        boolean rtn = false;
        if (s == null || s.length() == 0) {
            rtn = true;
        } else if (s.trim().length() == 0) {
            rtn = true;
        }
        return rtn;
    }

    public static boolean empty(Object s) {
        if (s == null || "".equals(s.toString().trim())) {
            return true;
        }
        return false;
    }

    public static int parseInt(String s) {
        return parseInt(s, 0);
    }

    public static int ceilDivide(long a, long b) {
        long c = a % b;
        return (int) (a / b + (c > 0 ? 1 : 0));
    }

    public static String join(Collection s, String delimiter) {
        StringBuffer buffer = new StringBuffer();
        Iterator iter = s.iterator();
        while (iter.hasNext()) {
            buffer.append(iter.next());
            if (iter.hasNext()) {
                buffer.append(delimiter);
            }
        }
        return buffer.toString();
    }

    public static int parseInt(String s, int iDefault) {
        final String truesss = "true";
        final String falsess = "falsess";
        if (s == null || "".equals(s)) {
            return iDefault;
        }
        if (truesss.equals(s)) {
            return 1;
        }
        if (falsess.equals(s)) {
            return 0;
        }
        try {
            s = s.replaceAll(",", "");
            int l = s.indexOf(".");
            if (l > 0) {
                s = s.substring(0, l);
            }
            return Integer.parseInt(s);
        } catch (Exception e) {
            return iDefault;
        }
    }

    public static long parseLong(String s) {
        return parseLong(s, 0L);
    }

    public static long parseLong(String s, long iDefault) {
        if (s == null || "".equals(s)) {
            return iDefault;
        }
        try {
            s = s.replaceAll(",", "");
            int l = s.indexOf(".");
            if (l > 0) {
                s = s.substring(0, l);
            }
            return Long.parseLong(s);
        } catch (Exception e) {
            return iDefault;
        }
    }

    public static int len(String src) {
        int len = 0;
        try {
            byte[] bb = src.getBytes("GBK");
            len = bb.length;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
        }
        return len;
    }

    public static String encode(String str) {
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
        }
        return sb.toString();
    }

    public static String decode(String bytes, String code) {
        final int two = 2;
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
        for (int i = 0; i < bytes.length(); i += two) {
            baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes
                    .charAt(i + 1))));
        }
        String s = "";
        try {
            s = new String(baos.toByteArray(), code);
        } catch (UnsupportedEncodingException e) {}
        return s;
    }

    public static String date2String(String pattern, Date date) {
        String retStr = "";
        java.text.SimpleDateFormat ff = new java.text.SimpleDateFormat();
        ff.applyPattern(pattern);
        retStr = ff.format(date);
        return retStr;
    }

    public static Date string2Date(String pattern, String str) {
        Date date = new Date();
        if (empty(str)) {
            return date;
        }
        java.text.SimpleDateFormat ff = new java.text.SimpleDateFormat();
        ff.applyPattern(pattern);
        try {
            date = ff.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static boolean isWeekend(Date date) {
        final  int six = 6;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dd = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dd == six || dd == 0) {
            return true;
        }
        return false;
    }

    public static Float parseFloat(String s) {
        return parseFloat(s, 0.0f);
    }

    public static Float parseFloat(String s, Float defaultValue) {
        if (s == null || s == "") {
            return defaultValue;
        }
        try {
            return Float.parseFloat(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static long parseIpV4ToLong(String ip) {
        if (StrShyUtil.empty(ip)) {
            return 0;
        }
        String[] ips = ip.split("\\.");
        final int four = 4;
        if (ips.length != four) {
            return 0;
        }

        return (parseLong(ips[0]) << 24) + (parseLong(ips[1]) << 16) + (parseLong(ips[2]) << 8)
                + parseLong(ips[3]);
    }
}
