package com.example.homework.dto;

import javax.validation.constraints.Size;

public class PositionDTO {
    @Size(min = 1, max = 50)
    private String positionName;
    @Size(min = 1, max = 50)
    private String location;

    private String applicationKey;


    public PositionDTO(String positionName, String location, String applicationKey) {
        this.positionName = positionName;
        this.location = location;
        this.applicationKey = applicationKey;
    }

    public PositionDTO() {
    }

    public PositionDTO(String positionName, String location) {
        this.positionName = positionName;
        this.location = location;
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

    public String getApplicationKey() {
        return applicationKey;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }
}
