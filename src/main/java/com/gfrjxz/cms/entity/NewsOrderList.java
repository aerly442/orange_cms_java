package com.gfrjxz.cms.entity;
 
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import com.baomidou.mybatisplus.annotation.TableField;



public class NewsOrderList {


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
private int newsid;
public int getNewsid() {
    return newsid;
}
public void setNewsid(int newsid) {
    this.newsid = newsid;
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
@TableField(value = "user_code")
private String userCode;
public String getUserCode() {
    return userCode;
}
public void setUserCode(String userCode) {
    this.userCode = userCode;
}
//@NotEmpty(message = "")
/* */
private String note;
public String getNote() {
    return note;
}
public void setNote(String note) {
    this.note = note;
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
@TableField(value = "pay_state")
private int payState;
public int getPayState() {
    return payState;
}
public void setPayState(int payState) {
    this.payState = payState;
}
//@NotEmpty(message = "")
/* */
@TableField(value = "pay_price")
private int payPrice;
public int getPayPrice() {
    return payPrice;
}
public void setPayPrice(int payPrice) {
    this.payPrice = payPrice;
}
//@NotEmpty(message = "")
/* */
@TableField(value = "pay_time")
private String payTime;
public String getPayTime() {
    return payTime;
}
public void setPayTime(String payTime) {
    this.payTime = payTime;
}
//@NotEmpty(message = "")
/* */
@TableField(value = "trade_no")
private String tradeNo;
public String getTradeNo() {
    return tradeNo;
}
public void setTradeNo(String tradeNo) {
    this.tradeNo = tradeNo;
}
//@NotEmpty(message = "")
/* */
private String orderId;
public String getOrderId() {
    return orderId;
}
public void setOrderId(String orderId) {
    this.orderId = orderId;
}
//@NotEmpty(message = "")
/* */
private String payUrl;
public String getPayUrl() {
    return payUrl;
}
public void setPayUrl(String payUrl) {
    this.payUrl = payUrl;
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

    

    
    
 
/* json 
{
  
  "id":"",
"newsid":"",
"email":"",
"userCode":"",
"note":"",
"createtime":"",
"updatetime":"",
"payState":"",
"payPrice":"",
"payTime":"",
"tradeNo":"",
"orderId":"",
"payUrl":"",
"userid":"",


}

*/
    
}
