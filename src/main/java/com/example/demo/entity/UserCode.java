package com.example.demo.entity;


import java.util.Date;

public class UserCode {

  private int userPid;
  private String userOpenid;
  private String userSessionkey;
  private Date lasttime;


  public int getUserPid() {
    return userPid;
  }

  public void setUserPid(int userPid) {
    this.userPid = userPid;
  }


  public String getUserOpenid() {
    return userOpenid;
  }

  public void setUserOpenid(String userOpenid) {
    this.userOpenid = userOpenid;
  }


  public String getUserSessionkey() {
    return userSessionkey;
  }

  public void setUserSessionkey(String userSessionkey) {
    this.userSessionkey = userSessionkey;
  }



  public Date getLasttime() {
    return lasttime;
  }

  public void setLasttime(Date lasttime) {
    this.lasttime = lasttime;
  }

}
