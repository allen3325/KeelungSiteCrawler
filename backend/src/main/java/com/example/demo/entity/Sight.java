package com.example.demo.entity;

public class Sight {
    // data field
    private String sightName;
    private String zone;
    private String category;
    private String photoURL;
    private String address;
    private String description;

    // constructor
    public Sight() {
    }

    // getter and setter (function)
    public String getSightName() {
        return sightName;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "SightName: " + getSightName() + "\nZone: " + getZone() + "\nCategory: " + getCategory()
                + "\nPhotoURL: " + getPhotoURL() + "\nDescription: " + getDescription() + "\nAddress: " + getAddress() + "\n";
    }
}
