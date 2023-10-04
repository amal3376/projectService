package dev.amalendu.projectservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    //P: G
    //l to r -->1: 1
    //r to l -->M: 1
    //Ans =>    m: 1
    @ManyToOne
    private Category category;
    private double price;

    }
