package com.example.muncihe_user_db.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;


@Table("user")
@Data

public class User {
    @Id
    private Long id;

    @Column("address")
    private String address;

    @Column("dob")
    private Date dob;

    @Column("email")
    private String email;

    @Column("name")
    private String name;

    @Column("password")
    private String password;

    @Column("phone_number")
    private String phone_number;
}
