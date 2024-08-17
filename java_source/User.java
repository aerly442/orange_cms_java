package com.gfrjxz.cms.entity;
 
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;



public class User {


  //@NotEmpty(message = "")
/* */
private int id;
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
//@NotEmpty(message = "")
/* */
private String username;
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
//@NotEmpty(message = "")
/* */
private String email;
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
//@NotEmpty(message = "")
/* */
private String mobile;
public String getMobile() {
    return mobile;
}
public void setMobile(String mobile) {
    this.mobile = mobile;
}
//@NotEmpty(message = "")
/* */
private String password;
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
//@NotEmpty(message = "")
/* */
private String nickname;
public String getNickname() {
    return nickname;
}
public void setNickname(String nickname) {
    this.nickname = nickname;
}
//@NotEmpty(message = "")
/* */
private String headerpic;
public String getHeaderpic() {
    return headerpic;
}
public void setHeaderpic(String headerpic) {
    this.headerpic = headerpic;
}
//@NotEmpty(message = "")
/* */
private String sex;
public String getSex() {
    return sex;
}
public void setSex(String sex) {
    this.sex = sex;
}
//@NotEmpty(message = "")
/* */
private String birthday;
public String getBirthday() {
    return birthday;
}
public void setBirthday(String birthday) {
    this.birthday = birthday;
}
//@NotEmpty(message = "")
/* */
private int age;
public int getAge() {
    return age;
}
public void setAge(int age) {
    this.age = age;
}
//@NotEmpty(message = "")
/* */
private String openid;
public String getOpenid() {
    return openid;
}
public void setOpenid(String openid) {
    this.openid = openid;
}
//@NotEmpty(message = "")
/* */
private String sns;
public String getSns() {
    return sns;
}
public void setSns(String sns) {
    this.sns = sns;
}
//@NotEmpty(message = "")
/* */
private int snstype;
public int getSnstype() {
    return snstype;
}
public void setSnstype(int snstype) {
    this.snstype = snstype;
}
//@NotEmpty(message = "")
/* */
private String continent;
public String getContinent() {
    return continent;
}
public void setContinent(String continent) {
    this.continent = continent;
}
//@NotEmpty(message = "")
/* */
private String country;
public String getCountry() {
    return country;
}
public void setCountry(String country) {
    this.country = country;
}
//@NotEmpty(message = "")
/* */
private String city;
public String getCity() {
    return city;
}
public void setCity(String city) {
    this.city = city;
}
//@NotEmpty(message = "")
/* */
private String intro;
public String getIntro() {
    return intro;
}
public void setIntro(String intro) {
    this.intro = intro;
}
//@NotEmpty(message = "")
/* */
private int active;
public int getActive() {
    return active;
}
public void setActive(int active) {
    this.active = active;
}
//@NotEmpty(message = "")
/* */
private String activetime;
public String getActivetime() {
    return activetime;
}
public void setActivetime(String activetime) {
    this.activetime = activetime;
}
//@NotEmpty(message = "")
/* */
private int ismaster;
public int getIsmaster() {
    return ismaster;
}
public void setIsmaster(int ismaster) {
    this.ismaster = ismaster;
}
//@NotEmpty(message = "")
/* */
private int isauthorized;
public int getIsauthorized() {
    return isauthorized;
}
public void setIsauthorized(int isauthorized) {
    this.isauthorized = isauthorized;
}
//@NotEmpty(message = "")
/* */
private int state;
public int getState() {
    return state;
}
public void setState(int state) {
    this.state = state;
}
//@NotEmpty(message = "")
/* */
private String totalmoney;
public String getTotalmoney() {
    return totalmoney;
}
public void setTotalmoney(String totalmoney) {
    this.totalmoney = totalmoney;
}
//@NotEmpty(message = "")
/* */
private String lastlogindatetime;
public String getLastlogindatetime() {
    return lastlogindatetime;
}
public void setLastlogindatetime(String lastlogindatetime) {
    this.lastlogindatetime = lastlogindatetime;
}
//@NotEmpty(message = "")
/* */
private int logincount;
public int getLogincount() {
    return logincount;
}
public void setLogincount(int logincount) {
    this.logincount = logincount;
}
//@NotEmpty(message = "")
/* */
private String createtime;
public String getCreatetime() {
    return createtime;
}
public void setCreatetime(String createtime) {
    this.createtime = createtime;
}
//@NotEmpty(message = "")
/* */
private int totalscore;
public int getTotalscore() {
    return totalscore;
}
public void setTotalscore(int totalscore) {
    this.totalscore = totalscore;
}
//@NotEmpty(message = "")
/* */
private String masterScore;
public String getMasterScore() {
    return masterScore;
}
public void setMasterScore(String masterScore) {
    this.masterScore = masterScore;
}
//@NotEmpty(message = "")
/* */
private int funsCount;
public int getFunsCount() {
    return funsCount;
}
public void setFunsCount(int funsCount) {
    this.funsCount = funsCount;
}
//@NotEmpty(message = "")
/* */
private int friendsCount;
public int getFriendsCount() {
    return friendsCount;
}
public void setFriendsCount(int friendsCount) {
    this.friendsCount = friendsCount;
}
//@NotEmpty(message = "")
/* */
private int careusersCount;
public int getCareusersCount() {
    return careusersCount;
}
public void setCareusersCount(int careusersCount) {
    this.careusersCount = careusersCount;
}
//@NotEmpty(message = "")
/* */
private String homeplace;
public String getHomeplace() {
    return homeplace;
}
public void setHomeplace(String homeplace) {
    this.homeplace = homeplace;
}
//@NotEmpty(message = "")
/* */
private String job;
public String getJob() {
    return job;
}
public void setJob(String job) {
    this.job = job;
}
//@NotEmpty(message = "")
/* */
private String school;
public String getSchool() {
    return school;
}
public void setSchool(String school) {
    this.school = school;
}
//@NotEmpty(message = "")
/* */
private String language;
public String getLanguage() {
    return language;
}
public void setLanguage(String language) {
    this.language = language;
}
//@NotEmpty(message = "")
/* */
private String tripplace;
public String getTripplace() {
    return tripplace;
}
public void setTripplace(String tripplace) {
    this.tripplace = tripplace;
}
//@NotEmpty(message = "")
/* */
private String interest;
public String getInterest() {
    return interest;
}
public void setInterest(String interest) {
    this.interest = interest;
}
//@NotEmpty(message = "")
/* */
private String aim;
public String getAim() {
    return aim;
}
public void setAim(String aim) {
    this.aim = aim;
}
//@NotEmpty(message = "")
/* */
private String updatetime;
public String getUpdatetime() {
    return updatetime;
}
public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
}
//@NotEmpty(message = "")
/* */
private int usertype;
public int getUsertype() {
    return usertype;
}
public void setUsertype(int usertype) {
    this.usertype = usertype;
}
//@NotEmpty(message = "")
/* */
private String name;
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
//@NotEmpty(message = "")
/* */
private int recommendUserid;
public int getRecommendUserid() {
    return recommendUserid;
}
public void setRecommendUserid(int recommendUserid) {
    this.recommendUserid = recommendUserid;
}
//@NotEmpty(message = "")
/* */
private String recommendCode;
public String getRecommendCode() {
    return recommendCode;
}
public void setRecommendCode(String recommendCode) {
    this.recommendCode = recommendCode;
}
//@NotEmpty(message = "")
/* */
private int loginType;
public int getLoginType() {
    return loginType;
}
public void setLoginType(int loginType) {
    this.loginType = loginType;
}
//@NotEmpty(message = "")
/* */
private int adjustType;
public int getAdjustType() {
    return adjustType;
}
public void setAdjustType(int adjustType) {
    this.adjustType = adjustType;
}

    

    
    
 
/* json 
{
  
  "id":"",
"username":"",
"email":"",
"mobile":"",
"password":"",
"nickname":"",
"headerpic":"",
"sex":"",
"birthday":"",
"age":"",
"openid":"",
"sns":"",
"snstype":"",
"continent":"",
"country":"",
"city":"",
"intro":"",
"active":"",
"activetime":"",
"ismaster":"",
"isauthorized":"",
"state":"",
"totalmoney":"",
"lastlogindatetime":"",
"logincount":"",
"createtime":"",
"totalscore":"",
"masterScore":"",
"funsCount":"",
"friendsCount":"",
"careusersCount":"",
"homeplace":"",
"job":"",
"school":"",
"language":"",
"tripplace":"",
"interest":"",
"aim":"",
"updatetime":"",
"usertype":"",
"name":"",
"recommendUserid":"",
"recommendCode":"",
"loginType":"",
"adjustType":"",


}

*/
    
}
