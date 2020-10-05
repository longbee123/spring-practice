package com.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Task {
    @Id
    private int id;
    private String name;
    private int priority;
}
