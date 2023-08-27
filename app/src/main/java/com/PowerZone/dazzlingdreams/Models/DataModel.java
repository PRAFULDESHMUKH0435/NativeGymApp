package com.PowerZone.dazzlingdreams.Models;

import java.util.Date;

public class DataModel {

    String UserName, UserWeight,UserMobile,Userplan,Total_amount,Paid_amount,Start_Date,End_Date;

    public DataModel ( ) {
    }

    public DataModel (String start_Date, String end_Date) {
        Start_Date = start_Date;
        End_Date = end_Date;
    }

    public String getUserplan ( ) {
        return Userplan;
    }

    public void setUserplan (String userplan) {
        Userplan = userplan;
    }

    public DataModel (String userplan) {
        Userplan = userplan;
    }

    public DataModel (String userName, String userWeight, String userMobile, String total_amount, String paid_amount, Date start_date, Date end_date) {
        UserName = userName;
        UserWeight = userWeight;
        UserMobile = userMobile;
        Total_amount = total_amount;
        Paid_amount = paid_amount;

    }

    public String getStart_Date ( ) {
        return Start_Date;
    }

    public void setStart_Date (String start_Date) {
        Start_Date = start_Date;
    }

    public String getEnd_Date ( ) {
        return End_Date;
    }

    public void setEnd_Date (String end_Date) {
        End_Date = end_Date;
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



    public String getTotal_amount ( ) {
        return Total_amount;
    }

    public void setTotal_amount (String total_amount) {
        Total_amount = total_amount;
    }

    public String getPaid_amount ( ) {
        return Paid_amount;
    }

    public void setPaid_amount (String paid_amount) {
        Paid_amount = paid_amount;
    }




}
