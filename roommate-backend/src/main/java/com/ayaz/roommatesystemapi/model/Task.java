package com.ayaz.roommatesystemapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private long id;
    private String title;
    private String description;
    private String responsible;
    private String date;
}
