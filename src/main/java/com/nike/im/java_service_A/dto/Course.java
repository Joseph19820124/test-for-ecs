package com.nike.im.java_service_A.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private int id;
    public int getId(){
        return this.id;
    }
    private String name;
    private double price;
}

