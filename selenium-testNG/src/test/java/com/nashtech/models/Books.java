package com.nashtech.models;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.nashtech.constants.ConfigConstants;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Books {
    private String bookTitle;
    private String keysSearchBook;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getKeysSearchBook() {
        return keysSearchBook;
    }

    public void setKeysSearchBook(String keysSearchBook) {
        this.keysSearchBook = keysSearchBook;
    }

    public static Books getBookData() throws FileNotFoundException {
        Gson gson = new Gson();
        //Reader reader = Files.newBufferedReader(Paths.get(ConfigConstants.TEST_DATA_PATH));
        JsonReader reader = new JsonReader(new FileReader(ConfigConstants.BOOK_JSON_PATH));
        return gson.fromJson(reader, Books.class);
    }
}
