package com.example.muncihe_user_db.model;





import org.springframework.data.annotation.Id;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;





@Table(name="dishes")
public class Dishes {
     public Dishes() {
    }

    public Dishes(int id,String descrip, boolean is_veg, String picture, String name, double price, long restaurant_fk) {
        this.id=id;
        this.descrip = descrip;
        this.is_veg = is_veg;
        this.picture = picture;
        this.name = name;
        this.price = price;
        this.restaurant_fk = restaurant_fk;
    }

    @Id
 
    private int id;

    @Column("descrip")
    private String descrip;
  
    @Column("is_veg")
    private boolean is_veg;
    @Column("picture")
    private String picture;
    @Column("name")
    private String name;

    @Column("price")
    private double price;

    private long restaurant_fk;
    
    

    public long getRestaurantId() {
        return restaurant_fk;
    }

    public void setRestaurantId(long restaurant_fk) {
        this.restaurant_fk = restaurant_fk;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public boolean isIs_veg() {
        return is_veg;
    }

    public void setIs_veg(boolean is_veg) {
        this.is_veg = is_veg;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getRestaurant_fk() {
        return restaurant_fk;
    }

    public void setRestaurant_fk(long restaurant_fk) {
        this.restaurant_fk = restaurant_fk;
    }


    
    }
