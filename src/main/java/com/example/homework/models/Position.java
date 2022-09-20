package com.example.homework.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 1, max = 50)
    @Column(unique = true)
    private String positionName;

    @Size(min = 1, max = 50)
    private String location;

    public Position() {
    }

    public Position(String positionName, String location) {
        this.positionName = positionName;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
