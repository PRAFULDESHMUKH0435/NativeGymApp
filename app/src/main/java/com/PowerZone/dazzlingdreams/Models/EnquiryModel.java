package com.PowerZone.dazzlingdreams.Models;

public class EnquiryModel {
    String UserName,UserMobile;

    public EnquiryModel() {
    }

    public EnquiryModel(String userName, String userMobile) {
        UserName = userName;
        UserMobile = userMobile;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserMobile() {
        return UserMobile;
    }

    public void setUserMobile(String userMobile) {
        UserMobile = userMobile;
    }
}
