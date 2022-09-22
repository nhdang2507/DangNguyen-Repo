package com.nashtech.models;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.nashtech.constants.ConfigConstants;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Users {
    private String userName;
    private String passWord;

    public String getUsername(){
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword(){
        return passWord;
    }

    public void setPassword(String passWord) {
        this.passWord = passWord;
    }

    public static Users getUserData() throws FileNotFoundException {
        Gson gson = new Gson();
        //Reader reader = Files.newBufferedReader(Paths.get(ConfigConstants.TEST_DATA_PATH));
        JsonReader reader = new JsonReader(new FileReader(ConfigConstants.USER_JSON_PATH));
        return gson.fromJson(reader, Users.class);
    }
}

