package com.catban.common.demo.form;

import com.catban.common.constant.RegexpConstant;
import com.catban.common.demo.controller.UserController;
import com.catban.common.form.constraints.Remote;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by meitu on 17/1/12.
 *
 *  错误验证中的message用于生成前端验证规则时，服务于前端错误输入提示；TODO by hgh
 */
public class UserForm {
    private Integer userId;
    private String userName;
    private String userPass;
    private String userNickname;

    private String userEmail;
    private String phoneNumber;
    private String qq;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @NotBlank
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NotBlank
    @Remote(message = "密码强度太弱",checkClass = UserController.class,checkMethod = "checkPwdStrength")
    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @NotBlank
    @Email
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Pattern(regexp = RegexpConstant.CELL_PHONE,message = "手机号码格式不正确")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
