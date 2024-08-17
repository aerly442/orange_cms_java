package com.gfrjxz.cms.entity;
 
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;



public class UserAuthorizeCode {


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
private String openid;
public String getOpenid() {
    return openid;
}
public void setOpenid(String openid) {
    this.openid = openid;
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
private String email;
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
//@NotEmpty(message = "")
/* */
private String code;
public String getCode() {
    return code;
}
public void setCode(String code) {
    this.code = code;
}
//@NotEmpty(message = "")
/* */
private String sendtime;
public String getSendtime() {
    return sendtime;
}
public void setSendtime(String sendtime) {
    this.sendtime = sendtime;
}
//@NotEmpty(message = "")
/* */
private int sendstate;
public int getSendstate() {
    return sendstate;
}
public void setSendstate(int sendstate) {
    this.sendstate = sendstate;
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
private String createtime;
public String getCreatetime() {
    return createtime;
}
public void setCreatetime(String createtime) {
    this.createtime = createtime;
}
//@NotEmpty(message = "")
/* */
private String messagetype;
public String getMessagetype() {
    return messagetype;
}
public void setMessagetype(String messagetype) {
    this.messagetype = messagetype;
}

    

    
    
 
/* json 
{
  
  "id":"",
"nickname":"",
"openid":"",
"mobile":"",
"email":"",
"code":"",
"sendtime":"",
"sendstate":"",
"state":"",
"createtime":"",
"messagetype":"",


}

*/
    
}
