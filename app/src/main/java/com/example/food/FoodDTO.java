package com.example.food;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class FoodDTO{
    private int no;
    private String user;
    private Date recordDate ;
    private String expirationDate;
    private String foodName;
    private String kategore;
    private int preference;
    private int foodCheak;
    private int remainDate;

    public FoodDTO(String foodName, String expirationDate){
        this.foodName = foodName;
        this.expirationDate = expirationDate;
    }
    public FoodDTO(String foodName, String expirationDate, String kategore){
        this.foodName = foodName;
        this.expirationDate = expirationDate;
        this.kategore = kategore;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }

    public int getFoodCheak() {
        return foodCheak;
    }

    public void setFoodCheak(int foodCheak) {
        this.foodCheak = foodCheak;
    }
    public int getRemainDate(){
        return remainDate;
    }
    public void setKategore(String kategore){
        this.kategore = kategore;
    }
    public String getKategore(){
        return kategore;
    }
    public void setRemainDate(int remainDate){
        this.remainDate= remainDate;
    }



}

