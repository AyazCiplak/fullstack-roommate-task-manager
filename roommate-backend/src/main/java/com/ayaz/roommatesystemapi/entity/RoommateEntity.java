package com.ayaz.roommatesystemapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roommates")
public class RoommateEntity {
    // Model for data structure
    // Auto-generates roommate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

}
