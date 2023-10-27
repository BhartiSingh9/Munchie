
package com.example.muncihe_user_db.dishes;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Table("dishes")
@Data
public class Dishes {
    @Id
    private int id;

    @Column("descrip")
    private String descrip;

    @Column("is_veg")
    private Boolean is_veg;
    @Column("picture")
    private String picture;
    @Column("name")
    private String name;
    @Column("price")
    private Double price;

    @Column("restaurant_fk")
    private int restaurantId;
}
