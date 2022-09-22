package com.nashtech.finalcucumber.utils;

public class APIConstant {
    public enum RequestType{
        GET,
        POST,
        PUT,
        DELETE,
        PATCH
    }

    /**------------Host-----------**/
    public static String DEMOQA_HOST = "https://demoqa.com";
    public static String DEMOQA_USER_PREFIX = "/Account/v1";
    public static String DEMOQA_BOOK_PREFIX = "/BookStore/v1";
    public static String SCHEMA = "Schema.json";

    /**------------Users-----------**/
    public static String GENERATE_TOKEN_ENDPOINT = "/GenerateToken";
    public static String CREATE_USERS_ENDPOINT = "/User";
    public static String GET_USERS_ENDPOINT = "/User/%s";



    /**------------Book-----------**/
    public static String GET_ALL_BOOKS_ENDPOINT = "/Books";
    public static String GET_A_BOOK_ENDPOINT = "/Book?ISBN=%s";
    public static String ADD_BOOK_ENDPOINT = "/Books";
    public static String DELETE_ALL_BOOKS_ENDPOINT = "/Books?ISBN=%s";
    public static String DELETE_A_BOOK_ENDPOINT = "/Book";
    public static String REPLACE_A_BOOK_ENDPOINT = "/Books/%s";
}
