package com.example.z_erian.myapplication;

public class Vehicle {

    String name;
    String number;
    String address;
    String ph;
    String email;

    public Vehicle(String name, String number, String address, String ph,String email) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.ph = ph;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getPh() {
        return ph;
    }

    public String getEmail() {
        return email;
    }
    public Boolean search(String key)
    {
        if(key.compareToIgnoreCase(number)==0)
        {
            return true;
        }
        else
            return false;

    }


}
