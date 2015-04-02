/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dubic.scribbles.admin.dto;

import java.util.Date;

/**
 *
 * @author dubem
 */
public class UserData {

    private Long id;
    private String screenName;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Date lastLoginDate;
    private boolean locked;
    private Date lockDate;
    private boolean activated;
    private Date passwordChangeDate;
    private boolean passwordExpired;
    private String phone;
   private Long jokes,quotes,proverbs;
    private String picture;
    private String updated;

    public UserData() {
    }

    
    public UserData(String screenName, String email, String password) {
        this.screenName = screenName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Date getLockDate() {
        return lockDate;
    }

    public void setLockDate(Date lockDate) {
        this.lockDate = lockDate;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Long getJokes() {
        return jokes;
    }

    public void setJokes(Long jokes) {
        this.jokes = jokes;
    }

    public Long getQuotes() {
        return quotes;
    }

    public void setQuotes(Long quotes) {
        this.quotes = quotes;
    }

    public Long getProverbs() {
        return proverbs;
    }

    public void setProverbs(Long proverbs) {
        this.proverbs = proverbs;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Date getPasswordChangeDate() {
        return passwordChangeDate;
    }

    public void setPasswordChangeDate(Date passwordChangeDate) {
        this.passwordChangeDate = passwordChangeDate;
    }

    public boolean isPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
  

    @Override
    public String toString() {
        return "UserData{" + "id=" + id + ", screenName=" + screenName + ", email=" + email + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", lastLoginDate=" + lastLoginDate + ", locked=" + locked + ", lockDate=" + lockDate + ", activated=" + activated + ", passwordChangeDate=" + passwordChangeDate + ", passwordExpired=" + passwordExpired + ", phone=" + phone + ", picture=" + picture + '}';
    }

}
