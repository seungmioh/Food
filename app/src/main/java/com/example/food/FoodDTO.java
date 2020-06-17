package com.example.food;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class FoodDTO{
    private int no;
    private Date food_recordDate ;
    private String food_expirationDate;
    private String food_name;
    private String kategore;
    private int preference;
    private int food_cheak;
    private int food_remainDate;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Date getFood_recordDate() {
        return food_recordDate;
    }

    public void setFood_recordDate(Date food_recordDate) {
        this.food_recordDate = food_recordDate;
    }

    public String getFood_expirationDate() {
        return food_expirationDate;
    }

    public void setFood_expirationDate(String food_expirationDate) {
        this.food_expirationDate = food_expirationDate;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getKategore() {
        return kategore;
    }

    public void setKategore(String kategore) {
        this.kategore = kategore;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }

    public int getFood_cheak() {
        return food_cheak;
    }

    public void setFood_cheak(int food_cheak) {
        this.food_cheak = food_cheak;
    }

    public int getFood_remainDate() {
        return food_remainDate;
    }

    public void setFood_remainDate(int food_remainDate) {
        this.food_remainDate = food_remainDate;
    }

    public FoodDTO(String food_name, String food_expirationDate){
        this.food_name = food_name;
        this.food_expirationDate = food_expirationDate;
    }
    public FoodDTO(){

    }

}

