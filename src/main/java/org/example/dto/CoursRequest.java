package org.example.dto;

public class CoursRequest {
    public String name;
    public int code;
    public int creditHours;

    public CoursRequest() {}

    public CoursRequest(String name, int code, int creditHours) {
        this.name = name;
        this.code = code;
        this.creditHours = creditHours;
    }
}
