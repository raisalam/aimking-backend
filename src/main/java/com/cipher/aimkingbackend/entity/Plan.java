package com.cipher.aimkingbackend.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "final_price")
    private Double finalPrice;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "duration", nullable = false) // New duration field
    private Integer duration; // Duration in minutes

    @Column(name = "free") // Free hours for the plan
    private Integer free;

    @Column(name = "is_active", nullable = false) // Active status of the plan
    private Boolean isActive;

}
