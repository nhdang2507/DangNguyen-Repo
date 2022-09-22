package com.nashtech.models;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.nashtech.constants.ConfigConstants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Students {
    private String firstName;
    private String lastName;
    private String userEmail;
    private String gender;
    private String mobile;
    private String dateOfBirth;
    private List<String> subjects;
    private List<String> hobbies;
    private String picturePath;
    private String address;
    private String state;
    private String city;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static Students getStudentData() throws FileNotFoundException {
        Gson gson = new Gson();
        //Reader reader = Files.newBufferedReader(Paths.get(ConfigConstants.TEST_DATA_PATH));
        JsonReader reader = new JsonReader(new FileReader(ConfigConstants.STUDENT_JSON_PATH));
        return gson.fromJson(reader, Students.class);
    }

}
