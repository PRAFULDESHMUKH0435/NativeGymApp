package com.PowerZone.dazzlingdreams.Models;

import java.util.Date;

public class DataModel {

    String UserName, UserWeight,UserMobile,UserPlan,TotalAmount,PaidAmount,UserStartDate,UserEndDate,BalanceAmount;

    public DataModel ( ) {
    }

    public DataModel (String totalAmount, String paidAmount, String userStartDate, String userEndDate,String balanceAmount) {
        TotalAmount = totalAmount;
        PaidAmount = paidAmount;
        UserStartDate = userStartDate;
        UserEndDate = userEndDate;
        BalanceAmount = balanceAmount;
    }

    public String getBalanceAmount ( ) {
        return BalanceAmount;
    }

    public void setBalanceAmount (String balanceAmount) {
        BalanceAmount = balanceAmount;
    }

    public String getTotalAmount ( ) {
        return TotalAmount;
    }

    public void setTotalAmount (String totalAmount) {
        TotalAmount = totalAmount;
    }

    public String getPaidAmount ( ) {
        return PaidAmount;
    }

    public void setPaidAmount (String paidAmount) {
        PaidAmount = paidAmount;
    }

    public String getUserStartDate ( ) {
        return UserStartDate;
    }

    public void setUserStartDate (String userStartDate) {
        UserStartDate = userStartDate;
    }

    public String getUserEndDate ( ) {
        return UserEndDate;
    }

    public void setUserEndDate (String userEndDate) {
        UserEndDate = userEndDate;
    }

    public String getUserplan ( ) {
        return UserPlan;
    }

    public void setUserplan (String userplan) {
        UserPlan = userplan;
    }

    public DataModel (String userplan) {
        UserPlan = userplan;
    }

    public DataModel (String userName, String userWeight, String userMobile) {
        UserName = userName;
        UserWeight = userWeight;
        UserMobile = userMobile;

    }



    public String getUserName ( ) {
        return UserName;
    }

    public void setUserName (String userName) {
        UserName = userName;
    }

    public String getUserWeight ( ) {
        return UserWeight;
    }

    public void setUserWeight (String userWeight) {
        UserWeight = userWeight;
    }

    public String getUserMobile ( ) {
        return UserMobile;
    }

    public void setUserMobile (String userMobile) {
        UserMobile = userMobile;
    }







}
