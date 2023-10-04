package dev.amalendu.projectservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel{
    private String name;


    @OneToMany( fetch =FetchType.EAGER,mappedBy = "category")
    private List<Product> products = new ArrayList<>();
    //this is the same relation being mapped by product class

}
//class Group{
//      M:M
//    List<User> members;
//      M:M
//    List<User> admins;
//      1-->1
//      M<--1
//      M : 1
//    User Creator;
//}
