package com.gfrjxz.cms.entity;
 
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;



public class NewsComment {


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
private String nickname;
public String getNickname() {
    return nickname;
}
public void setNickname(String nickname) {
    this.nickname = nickname;
}
//@NotEmpty(message = "")
/* */
private String content;
public String getContent() {
    return content;
}
public void setContent(String content) {
    this.content = content;
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
private String updatetime;
public String getUpdatetime() {
    return updatetime;
}
public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
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
private int parentid;
public int getParentid() {
    return parentid;
}
public void setParentid(int parentid) {
    this.parentid = parentid;
}
//@NotEmpty(message = "")
/* */
private int userid;
public int getUserid() {
    return userid;
}
public void setUserid(int userid) {
    this.userid = userid;
}
//@NotEmpty(message = "")
/* */
private int likecount;
public int getLikecount() {
    return likecount;
}
public void setLikecount(int likecount) {
    this.likecount = likecount;
}
//@NotEmpty(message = "")
/* */
private int hatecount;
public int getHatecount() {
    return hatecount;
}
public void setHatecount(int hatecount) {
    this.hatecount = hatecount;
}
//@NotEmpty(message = "")
/* */
private int newsid;
public int getNewsid() {
    return newsid;
}
public void setNewsid(int newsid) {
    this.newsid = newsid;
}
//@NotEmpty(message = "")
/* */
private String title;
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}

    

    
    
 
/* json 
{
  
  "id":"",
"nickname":"",
"content":"",
"createtime":"",
"updatetime":"",
"state":"",
"parentid":"",
"userid":"",
"likecount":"",
"hatecount":"",
"newsid":"",
"title":"",


}

*/
    
}
