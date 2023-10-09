package com.example.muncihe_user_db.model;



import org.springframework.data.annotation.Id;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table(name="restaurant")
public class Restaurant {
     @Id
 
    private long id;
    @Column("name")
    private String name;
    @Column("city")
    private String city;
    @Column("descrip")
    private String descrip;
    @Column("address")
    private String address;
    @Column("license_id")
    private String license_id;
    @Column("open_time")
    private int open_time;
    @Column("close_time")
    private int close_time;
    @Column("cuisine_type")
    private String cuisineType;
    @Column("phone_Number")
    private long phoneNumber;
    @Column("ratings")
    private double ratings;
    @Column("is_pureveg")
    private boolean is_pureveg;
    @Column("picture")
    private String picture;
    
   

    public Restaurant(int id,String name, String city, String descrip, String address, String license_id, int open_time,
            int close_time, String cuisineType, long phoneNumber, double ratings, boolean is_pureveg, String picture) {
                super();
                this.id=id;
        this.name = name;
        this.city = city;
        this.descrip = descrip;
        this.address = address;
        this.license_id = license_id;
        this.open_time = open_time;
        this.close_time = close_time;
        this.cuisineType = cuisineType;
        this.phoneNumber = phoneNumber;
        this.ratings = ratings;
        this.is_pureveg = is_pureveg;
        this.picture=picture;
    }
    public Restaurant() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDescrip() {
        return descrip;
    }
    public void setDescrip(String desc) {
        this.descrip = desc;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getLicense_id() {
        return license_id;
    }
    public void setLicense_id(String license_id) {
        this.license_id = license_id;
    }
    public int getOpen_time() {
        return open_time;
    }
    public void setOpen_time(int open_time) {
        this.open_time = open_time;
    }
    public int getClose_time() {
        return close_time;
    }
    public void setClose_time(int close_time) {
        this.close_time = close_time;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public double getRatings() {
        return ratings;
    }
    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
    public boolean isIs_pureveg() {
        return is_pureveg;
    }
    public void setIs_pureveg(boolean is_pureveg) {
        this.is_pureveg = is_pureveg;
    }
    public String getCuisineType() {
        return cuisineType;
    }
    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
