package dev.amalendu.projectservice.inheritancedemo.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private double averageRating;
}
