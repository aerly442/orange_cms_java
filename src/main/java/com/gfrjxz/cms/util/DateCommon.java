package com.gfrjxz.cms.util;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateCommon {


    /** 把日期加上n秒 */
    public static String AddSeconds(String strDate,Long seconds){

        try {
            if (strDate.length()=="yyyy-MM-dd HH:mm".length()){
                strDate = strDate+":00";
            }
            if (strDate.length()=="yyyy-MM-dd".length()){
                strDate = strDate+" 00:00:00";
            }
            Date d1 = Str2Date(strDate);
            Long result = d1.getTime() + seconds *1000;

            Date d2= new Date(result);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String r = sdf.format(d2);
            return r;
        }
        catch (Exception ex){

            return null;
        }




    }

    public static Date Str2Date(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date Str2Date2(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String Str2Str(String dateStr){
        Date date  = Str2Date(dateStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(date);
    }
    public static String Str2Str2(String dateStr){
        Date date  = Str2Date(dateStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String r =  sdf.format(date);
        return r ;
    }
    public static String Str2StrShort(String dateStr){
        Date date  = Str2Date(dateStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(date);
    }



    public static String Date2Str(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String getToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    public static String getNowToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static String getNowToday2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    public static String getNowToday3() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    public static String getNowToday_mm() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        return sdf.format(new Date());
    }


    //


    public static  String now(){
        return Date2Str(new Date());
    }


    public static Integer getUserAge(String birthday) {

        if (StrUtil.isNullOrEmpty(birthday)){
            return 0 ;
        }

        // 如果不是正确的日期型则返回 0
        Date d1 = DateCommon.Str2Date2(birthday);
        if (d1 == null) {
            return 0;
        }

        String[] aryAge = birthday.trim() .split("-");

        //一定要是yyyy-MM-dd 这种格式
        if (aryAge.length >= 3 && aryAge[0].length() == 4
                &&  aryAge[1].length() ==2 && aryAge[2].length()==2
        ) {

            // 获取当前时间的月日
            SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
            String currDate = sdf.format(new Date());

            String userDate = aryAge[1] + aryAge[2];

            // 获取当前的年
            SimpleDateFormat dYear = new SimpleDateFormat("yyyy");
            String year = dYear.format(new Date());

            // 计算年龄
            Integer age = Integer.parseInt(year) - Integer.parseInt(aryAge[0]);

            // 如果没有过生日就减1
            if (userDate.compareTo(currDate) > 0) {
                age = age - 1;

            }
            //如果年龄小于0 则返回0
            return age >= 0 ? age : 0;

        }

        return 0;

    }

    /** 检测年龄限制 */
    public static boolean checkAgeLimit(String birthday, int min_age, int max_age) {

        if (min_age == 0 && max_age == 0) {
            return true;
        }

        int age = getUserAge(birthday);
        if (age == 0) {
            return true;
        }

        if (max_age == 0 ){ //
            return age >=min_age;
        }

        boolean result = age >= min_age && age <= max_age;
        return result;

    }

}
