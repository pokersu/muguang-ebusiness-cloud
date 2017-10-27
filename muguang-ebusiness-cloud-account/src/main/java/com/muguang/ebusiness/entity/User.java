package com.muguang.ebusiness.entity;

import com.muguang.ebusiness.utils.SignatureUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 * 用户
 * @author muguang
 * @date 2017/3/6 11:15.
 */
public class User implements Serializable{

    private static final long serialVersionUID = -2006581445655225993L;
    private Long id;
    private String name;
    private String password;
    private String salt;
    private String nickname;
    private short sex;
    private short age;
    private String mobile;
    private short mobileStatus;
    private String email;
    private short emailStatus;
    private int usertype;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    private int superior;

    private transient String sexName;
    private transient String emailStatusName;
    private transient String mobileStatusName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public short getSex() {
        return sex;
    }

    public void setSex(short sex) {
        this.sex = sex;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public short getMobileStatus() {
        return mobileStatus;
    }

    public void setMobileStatus(short mobileStatus) {
        this.mobileStatus = mobileStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(short emailStatus) {
        this.emailStatus = emailStatus;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getSuperior() {
        return superior;
    }

    public void setSuperior(int superior) {
        this.superior = superior;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getEmailStatusName() {
        return emailStatusName;
    }

    public void setEmailStatusName(String emailStatusName) {
        this.emailStatusName = emailStatusName;
    }

    public String getMobileStatusName() {
        return mobileStatusName;
    }

    public void setMobileStatusName(String mobileStatusName) {
        this.mobileStatusName = mobileStatusName;
    }

    public boolean validatePassword(String password){
        if(StringUtils.isBlank(password) || StringUtils.isBlank(this.password)){
            throw new RuntimeException("username/password is error!");
        }else{
            String pwdMd5 = SignatureUtil.md5(SignatureUtil.md5(password)+this.salt);
            return pwdMd5.equals(this.password);
        }
    }

    public void calcPassword(){
        Random random = new Random();
        this.salt = random.nextInt(99999999)+"";
        this.password = SignatureUtil.md5(SignatureUtil.md5(this.password)+this.salt);
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
