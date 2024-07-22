package com.gfrjxz.cms.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class ManagerDTO {

    @NotEmpty(message = "新密码是必须的")
    private String newPassword;
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @NotEmpty(message = "旧密码是必须的")
    private String oldPassword;
    public String getOldPassword() {
        return oldPassword;
    }
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }


/* json
{
"id":"",
"username":"",
"password":"",
"name":"",
"tel":"",
"depart":"",
"power":"",
"lastlogindatetime":"",
"c_role_id":"",
"lastloginip":"",
"createtime":"",
"corpid":"",
}

*/

}
