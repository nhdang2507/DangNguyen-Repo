package com.nashtech.finalcucumber.utils.api;

import com.nashtech.finalcucumber.utils.APIConstant;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BookHelper extends RequestHelper{
    private String prefixUrl = APIConstant.DEMOQA_HOST + APIConstant.DEMOQA_BOOK_PREFIX;

    public Response addBookToCollection(String token, String userId, String isbn){
        String url = prefixUrl + APIConstant.ADD_BOOK_ENDPOINT;
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + token);

        Headers headers = createHeaders(map);

        JSONObject body = new JSONObject();
        JSONArray collectionOfIsbns = new JSONArray();
        JSONObject bookId = new JSONObject();

        /*for(Object books : collectionOfIsbns){
            bookId.put("isbn", isbn);
            collectionOfIsbns.add(bookId);
        }*/

        bookId.put("isbn", isbn);
        collectionOfIsbns.add(bookId);
        body.put("userId", userId);
        body.put("collectionOfIsbns", collectionOfIsbns);

        Response response = sendRequest(
                APIConstant.RequestType.POST,
                url,
                headers,
                body.toString());
        return response;
    }

    public Response deleteABook(String userToken, String userId, String isbn){
        String url = prefixUrl + APIConstant.DELETE_A_BOOK_ENDPOINT;
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);

        Headers headers = createHeaders(map);
        JSONObject body = new JSONObject();
        body.put("userId", userId);
        body.put("isbn", isbn);

        Response response = sendRequest(
                APIConstant.RequestType.DELETE,
                url,
                headers,
                body.toString());
        return response;
    }
}
