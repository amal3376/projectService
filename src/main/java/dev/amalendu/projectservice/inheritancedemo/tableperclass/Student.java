package dev.amalendu.projectservice.inheritancedemo.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {
    private String psp;
    private double attendance;
}
