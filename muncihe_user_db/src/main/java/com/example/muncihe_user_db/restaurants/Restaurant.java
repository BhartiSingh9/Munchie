package com.example.muncihe_user_db.restaurants;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
import java.time.LocalTime;


@Table(name = "restaurant")
@Data
public class Restaurant {
    @Id
    private int id;

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
    private LocalTime open_time;

    @Column("close_time")
    private LocalTime close_time;

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

}
