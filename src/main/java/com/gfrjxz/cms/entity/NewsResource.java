package com.gfrjxz.cms.entity;
 
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.baomidou.mybatisplus.annotation.TableField;

public class NewsResource {


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
private String resource;
public String getResource() {
    return resource;
}
public void setResource(String resource) {
    this.resource = resource;
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
private String title;
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
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
private String checktime;
public String getChecktime() {
    return checktime;
}
public void setChecktime(String checktime) {
    this.checktime = checktime;
}
//@NotEmpty(message = "")
/* */
private String seed;
public String getSeed() {
    return seed;
}
public void setSeed(String seed) {
    this.seed = seed;
}
//@NotEmpty(message = "")
/* */
@TableField(value = "violation_cnt")
private int violationCnt;
public int getViolationCnt() {
    return violationCnt;
}
public void setViolationCnt(int violationCnt) {
    this.violationCnt = violationCnt;
}
//@NotEmpty(message = "")
/* */
@TableField(value = "click_pv")
private int clickPv;
public int getClickPv() {
    return clickPv;
}
public void setClickPv(int clickPv) {
    this.clickPv = clickPv;
}
//@NotEmpty(message = "")
/* */
@TableField(value = "save_pv")
private int savePv;
public int getSavePv() {
    return savePv;
}
public void setSavePv(int savePv) {
    this.savePv = savePv;
}
//@NotEmpty(message = "")
/* */
@TableField(value = "expired_days")
private int expiredDays;
public int getExpiredDays() {
    return expiredDays;
}
public void setExpiredDays(int expiredDays) {
    this.expiredDays = expiredDays;
}
//@NotEmpty(message = "")
/* */
@TableField(value = "expired_at")
private String expiredAt;
public String getExpiredAt() {
    return expiredAt;
}
public void setExpiredAt(String expiredAt) {
    this.expiredAt = expiredAt;
}
//@NotEmpty(message = "")
/* */
@TableField(value = "last_save_pv")
private int lastSavePv;
public int getLastSavePv() {
    return lastSavePv;
}
public void setLastSavePv(int lastSavePv) {
    this.lastSavePv = lastSavePv;
}
//@NotEmpty(message = "")
/* */
@TableField(value = "last_click_pv")
private int lastClickPv;
public int getLastClickPv() {
    return lastClickPv;
}
public void setLastClickPv(int lastClickPv) {
    this.lastClickPv = lastClickPv;
}

    

    
    
 
/* json 
{
  
  "id":"",
"resource":"",
"note":"",
"createtime":"",
"updatetime":"",
"title":"",
"state":"",
"checktime":"",
"seed":"",
"violationCnt":"",
"clickPv":"",
"savePv":"",
"expiredDays":"",
"expiredAt":"",
"lastSavePv":"",
"lastClickPv":"",


}

*/
    
}
