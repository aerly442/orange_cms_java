package com.gfrjxz.cms.entity;

import java.util.Date;


public class Member {


    //@NotEmpty(message = "")
    /* */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //@NotEmpty(message = "姓名")
    /* 姓名*/
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@NotEmpty(message = "头像")
    /* 头像*/
    private String headerpic;

    public String getHeaderpic() {
        return headerpic;
    }

    public void setHeaderpic(String headerpic) {
        this.headerpic = headerpic;
    }

    //@NotEmpty(message = "邮件")
    /* 邮件*/
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //@NotEmpty(message = "手机")
    /* 手机*/
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    //@NotEmpty(message = "性别")
    /* 性别*/
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //@NotEmpty(message = "生日")
    /* 生日*/
    private String birthday;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    //@NotEmpty(message = "年龄")
    /* 年龄*/
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //@NotEmpty(message = "简介")
    /* 简介*/
    private String intro;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    //@NotEmpty(message = "创建时间")
    /* 创建时间*/
    private String createtime;

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    //@NotEmpty(message = "家乡")
    /* 家乡*/
    private String homeplace;

    public String getHomeplace() {
        return homeplace;
    }

    public void setHomeplace(String homeplace) {
        this.homeplace = homeplace;
    }

    //@NotEmpty(message = "职业")
    /* 职业*/
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    //@NotEmpty(message = "学历")
    /* 学历*/
    private String education;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    //@NotEmpty(message = "证件号码")
    /* 证件号码*/
    private String idnumber;

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    //@NotEmpty(message = "状态")
    /* 状态*/
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    //@NotEmpty(message = "更新时间")
    /* 更新时间*/
    private String updatetime;

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    

    
    
 
/* json 
{
  
  "id":"",
"name":"",
"headerpic":"",
"email":"",
"mobile":"",
"sex":"",
"birthday":"",
"age":"",
"intro":"",
"createtime":"",
"homeplace":"",
"job":"",
"education":"",
"idnumber":"",
"state":"",
"updatetime":"",


}

*/

}
