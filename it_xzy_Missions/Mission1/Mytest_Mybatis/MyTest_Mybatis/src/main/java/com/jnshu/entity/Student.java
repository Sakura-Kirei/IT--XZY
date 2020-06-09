package com.jnshu.entity;


public  class Student {

    private Integer ID;
    private String Name;
    private String School;
    private String Online_un;
    private Integer Number;
    private String City;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getOnline_un() {
        return Online_un;
    }

    public void setOnline_un(String online_un) {
        Online_un = online_un;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", School='" + School + '\'' +
                ", Online_un='" + Online_un + '\'' +
                ", Number=" + Number +
                ", City='" + City + '\'' +
                '}';
    }
}


