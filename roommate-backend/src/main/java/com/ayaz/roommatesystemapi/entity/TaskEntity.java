package com.ayaz.roommatesystemapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class TaskEntity {
    // Model for data structure
    // Auto-generates user ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String responsible;
    private String date;

}
