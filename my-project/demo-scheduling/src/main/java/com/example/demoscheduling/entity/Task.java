package com.example.demoscheduling.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Task implements Serializable {
    @Id
    private int id;
    private String name;
    private int priority;
}
