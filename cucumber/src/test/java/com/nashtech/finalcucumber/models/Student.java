package com.nashtech.finalcucumber.models;

public class Student {
    public String firstName;
    public String lastName;
    public String email;
    public String gender;
    public String mobile;
    public String dateOfBirth;
    public String subjects;
    public String hobbies;
    public String picture;
    public String address;
    public String state;
    public String city;

    public Student (String firstName, String lastName, String email, String gender, String mobile, String dateOfBirth, String subjects, String hobbies, String picture, String address, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.subjects = subjects;
        this.hobbies = hobbies;
        this.picture = picture;
        this.address = address;
        this.state = state;
        this.city = city;
    }
}
