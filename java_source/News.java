package com.gfrjxz.cms.entity;
 
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;



public class News {


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
private String title;
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
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
private String author;
public String getAuthor() {
    return author;
}
public void setAuthor(String author) {
    this.author = author;
}
//@NotEmpty(message = "")
/* */
private String source;
public String getSource() {
    return source;
}
public void setSource(String source) {
    this.source = source;
}
//@NotEmpty(message = "")
/* */
private String newsCategoriesCode;
public String getNewsCategoriesCode() {
    return newsCategoriesCode;
}
public void setNewsCategoriesCode(String newsCategoriesCode) {
    this.newsCategoriesCode = newsCategoriesCode;
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
private String mainpic;
public String getMainpic() {
    return mainpic;
}
public void setMainpic(String mainpic) {
    this.mainpic = mainpic;
}
//@NotEmpty(message = "")
/* */
private String file;
public String getFile() {
    return file;
}
public void setFile(String file) {
    this.file = file;
}
//@NotEmpty(message = "")
/* */
private String url;
public String getUrl() {
    return url;
}
public void setUrl(String url) {
    this.url = url;
}
//@NotEmpty(message = "")
/* */
private int sort;
public int getSort() {
    return sort;
}
public void setSort(int sort) {
    this.sort = sort;
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
private int hot;
public int getHot() {
    return hot;
}
public void setHot(int hot) {
    this.hot = hot;
}
//@NotEmpty(message = "")
/* */
private String keyWord;
public String getKeyWord() {
    return keyWord;
}
public void setKeyWord(String keyWord) {
    this.keyWord = keyWord;
}
//@NotEmpty(message = "")
/* */
private String abstract;
public String getAbstract() {
    return abstract;
}
public void setAbstract(String abstract) {
    this.abstract = abstract;
}
//@NotEmpty(message = "")
/* */
private int visit;
public int getVisit() {
    return visit;
}
public void setVisit(int visit) {
    this.visit = visit;
}
//@NotEmpty(message = "")
/* */
private int isCharge;
public int getIsCharge() {
    return isCharge;
}
public void setIsCharge(int isCharge) {
    this.isCharge = isCharge;
}
//@NotEmpty(message = "收费开始日期")
/* 收费开始日期*/
private String chargeStarttime;
public String getChargeStarttime() {
    return chargeStarttime;
}
public void setChargeStarttime(String chargeStarttime) {
    this.chargeStarttime = chargeStarttime;
}
//@NotEmpty(message = "收费截止日期")
/* 收费截止日期*/
private String chargeEndtime;
public String getChargeEndtime() {
    return chargeEndtime;
}
public void setChargeEndtime(String chargeEndtime) {
    this.chargeEndtime = chargeEndtime;
}
//@NotEmpty(message = "价格")
/* 价格*/
private int price;
public int getPrice() {
    return price;
}
public void setPrice(int price) {
    this.price = price;
}
//@NotEmpty(message = "")
/* */
private int isComment;
public int getIsComment() {
    return isComment;
}
public void setIsComment(int isComment) {
    this.isComment = isComment;
}
//@NotEmpty(message = "")
/* */
private int chargeType;
public int getChargeType() {
    return chargeType;
}
public void setChargeType(int chargeType) {
    this.chargeType = chargeType;
}

    

    
    
 
/* json 
{
  
  "id":"",
"title":"",
"content":"",
"author":"",
"source":"",
"newsCategoriesCode":"",
"createtime":"",
"mainpic":"",
"file":"",
"url":"",
"sort":"",
"state":"",
"hot":"",
"keyWord":"",
"abstract":"",
"visit":"",
"isCharge":"",
"chargeStarttime":"",
"chargeEndtime":"",
"price":"",
"isComment":"",
"chargeType":"",


}

*/
    
}
