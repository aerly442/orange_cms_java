package com.gfrjxz.cms.util;


import org.apache.commons.codec.binary.Hex;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {

    public static boolean  isNullOrEmpty(String s){
        if(s==null||s.length()==0)
            return true;
        return false;
    }

    //往字符串数组追加新数据
    public static String[] insert(String[] arr, String str) {
        int size = arr.length;  //获取数组长度
        String[] tmp = new String[size + 1];  //新建临时字符串数组，在原来基础上长度加一
        for (int i = 0; i < size; i++){  //先遍历将原来的字符串数组数据添加到临时字符串数组
            tmp[i] = arr[i];
        }
        tmp[size] = str;  //在最后添加上需要追加的数据
        return tmp;  //返回拼接完成的字符串数组
    }


    /* 获取密码*/
    public  static String getPassWord(String passWord){

        if (StrUtil.isNullOrEmpty(passWord) == false ) {
            String p = getMD5(passWord);
            return p.substring(0,16);
        }
        else{
            return null;
        }

    }

    public  static  String getMD5(String str){

        try{

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes(StandardCharsets.UTF_8));
            return new String(Hex.encodeHex(md5.digest()));

        }
        catch (Exception ex){
            return null;
        }
    }


    public  static  String getHttpRequestContent(HttpServletRequest request){

        String inputLine = null;
        StringBuffer recieveData = new StringBuffer();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    request.getInputStream(), "UTF-8"));
            while ((inputLine = in.readLine()) != null) {
                recieveData.append(inputLine);
            }
        } catch (IOException e) {
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }

        return recieveData.toString();


    }


    public static boolean isValidDate(String str) {
        boolean convertSuccess=true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyMM");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess=false;
        }
        return convertSuccess;
    }


    public static String getClearString(String str){

           if (isNullOrEmpty(str)){
               return "";
           }

           str = str.replace("'","");
           str = str.replace("!","");
           str = str.replace("--","");
           str = str.replace("<","");
           str = str.replace(">","");
           str = str.replace("&","");
           str = str.replace("?","");
           str = str.replace("*","");
           str = str.replace("#","");
           if (str.length()>50){
               str = str.substring(0,50);
           }

           return str;


    }

    public static String GetFileExt(String fileName){
        
        String   ext = "png";

        if (fileName!=null){
            String[] aryRightExt = "JPG,PNG,PDF,CSV,Xls,Xlsx,Doc,Docx".split(",");
            String[] aryFileInfo = fileName.split("\\.");
           
            if (aryFileInfo.length>0){
                ext = aryFileInfo[aryFileInfo.length-1];
            }

            for (String f : aryRightExt) {

                if (f.toLowerCase().equals(ext.toLowerCase())){
                    return f.toLowerCase();
                }
                
            }
        }

        return ext;
        

    }

    /*
    public  static  Boolean check_input(Object objValue,String ruler){

        String[] aryRuler = ruler.split("|");
       for (int i=0;i<aryRuler.length;i++){



       }

        //required|regex_match[/regex/]|is_unique[table.field]|numeric|valid_email

        return true ;

    }


     */
}
