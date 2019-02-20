package com.example.smartshare;

public class User {

    private String Name, Enroll, Email, Phone;

    public User(String Enroll, String Name, String Email, String Phone) {
        this.Name = Name;
        this.Enroll = Enroll;
        this.Email = Email;
        this.Phone = Phone;
    }

    public String getName() {
        return Name;
    }
    public String getEnroll() {
        return Enroll;
    }
    public String getEmail() {
        return Email;
    }
    public String getPhone() {
        return Phone;
    }
}