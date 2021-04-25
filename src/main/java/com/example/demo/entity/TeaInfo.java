package com.example.demo.entity;


public class TeaInfo {

  private int userPid;
  private String tphoto;
  private String tname;
  private String tsex;
  private String tnumber;
  private String tschool;
  private String tmajor;
  private String ttype;
  private String thome;
  private String tgrade;
  private String treward;
  private String tinfo;
  private String texp;

  @Override
  public String toString() {
    return "TeaInfo{" +
            "userPid=" + userPid +
            ", tphoto='" + tphoto + '\'' +
            ", tname='" + tname + '\'' +
            ", tsex='" + tsex + '\'' +
            ", tnumber='" + tnumber + '\'' +
            ", tschool='" + tschool + '\'' +
            ", tmajor='" + tmajor + '\'' +
            ", ttype='" + ttype + '\'' +
            ", thome='" + thome + '\'' +
            ", tgrade='" + tgrade + '\'' +
            ", treward='" + treward + '\'' +
            ", tinfo='" + tinfo + '\'' +
            ", texp='" + texp + '\'' +
            '}';
  }

  public int getUserPid() {
    return userPid;
  }

  public void setUserPid(int userPid) {
    this.userPid = userPid;
  }


  public String getTphoto() {
    return tphoto;
  }

  public void setTphoto(String tphoto) {
    this.tphoto = tphoto;
  }


  public String getTname() {
    return tname;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }


  public String getTsex() {
    return tsex;
  }

  public void setTsex(String tsex) {
    this.tsex = tsex;
  }


  public String getTnumber() {
    return tnumber;
  }

  public void setTnumber(String tnumber) {
    this.tnumber = tnumber;
  }


  public String getTschool() {
    return tschool;
  }

  public void setTschool(String tschool) {
    this.tschool = tschool;
  }


  public String getTmajor() {
    return tmajor;
  }

  public void setTmajor(String tmajor) {
    this.tmajor = tmajor;
  }


  public String getTtype() {
    return ttype;
  }

  public void setTtype(String ttype) {
    this.ttype = ttype;
  }


  public String getThome() {
    return thome;
  }

  public void setThome(String thome) {
    this.thome = thome;
  }


  public String getTgrade() {
    return tgrade;
  }

  public void setTgrade(String tgrade) {
    this.tgrade = tgrade;
  }


  public String getTreward() {
    return treward;
  }

  public void setTreward(String treward) {
    this.treward = treward;
  }


  public String getTinfo() {
    return tinfo;
  }

  public void setTinfo(String tinfo) {
    this.tinfo = tinfo;
  }


  public String getTexp() {
    return texp;
  }

  public void setTexp(String texp) {
    this.texp = texp;
  }

}
