package com.example.demo.entity;

public class StuInfo {

    @Override
    public String toString() {
        return "StuInfo{" +
                "userPid=" + userPid +
                ", orderid=" + orderid +
                ", username='" + username + '\'' +
                ", wxnumber='" + wxnumber + '\'' +
                ", usersex='" + usersex + '\'' +
                ", grade='" + grade + '\'' +
                ", situation='" + situation + '\'' +
                ", school='" + school + '\'' +
                ", address='" + address + '\'' +
                ", weektime='" + weektime + '\'' +
                ", daytime='" + daytime + '\'' +
                ", attime='" + attime + '\'' +
                ", asksex='" + asksex + '\'' +
                ", asktype='" + asktype + '\'' +
                ", askfor='" + askfor + '\'' +
                '}';
    }

  private int userPid;
  private int orderid;
  private String username;
  private String wxnumber;
  private String usersex;
  private String grade;
  private String situation;
  private String school;
  private String address;
  private String weektime;
  private String daytime;
  private String attime;
  private String asksex;
  private String asktype;
  private String askfor;


  public int getUserPid() {
    return userPid;
  }

  public void setUserPid(int userPid) {
    this.userPid = userPid;
  }


  public int getOrderid() {
    return orderid;
  }

  public void setOrderid(int orderid) {
    this.orderid = orderid;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getWxnumber() {
    return wxnumber;
  }

  public void setWxnumber(String wxnumber) {
    this.wxnumber = wxnumber;
  }


  public String getUsersex() {
    return usersex;
  }

  public void setUsersex(String usersex) {
    this.usersex = usersex;
  }


  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }


  public String getSituation() {
    return situation;
  }

  public void setSituation(String situation) {
    this.situation = situation;
  }


  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getWeektime() {
    return weektime;
  }

  public void setWeektime(String weektime) {
    this.weektime = weektime;
  }


  public String getDaytime() {
    return daytime;
  }

  public void setDaytime(String daytime) {
    this.daytime = daytime;
  }


  public String getAttime() {
    return attime;
  }

  public void setAttime(String attime) {
    this.attime = attime;
  }


  public String getAsksex() {
    return asksex;
  }

  public void setAsksex(String asksex) {
    this.asksex = asksex;
  }


  public String getAsktype() {
    return asktype;
  }

  public void setAsktype(String asktype) {
    this.asktype = asktype;
  }


  public String getAskfor() {
    return askfor;
  }

  public void setAskfor(String askfor) {
    this.askfor = askfor;
  }

}
