package com.m3.Classes.LibraryDTO;

public class Studio {

    private java.lang.String name;
    private java.lang.String address;

    public Studio(java.lang.String name) {
        this.name = name;
        this.address = null;
    }

    public Studio(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
