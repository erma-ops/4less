package com.example.m3_lesson4_2;

public class Country {
    private String name;
    private String capitalName;
    private String flag;

    public Country(String name, String capitalName, String flag) {
        this.name = name;
        this.capitalName = capitalName;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
