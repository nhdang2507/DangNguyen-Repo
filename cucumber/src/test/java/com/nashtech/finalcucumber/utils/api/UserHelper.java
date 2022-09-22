package com.nashtech.finalcucumber.utils.api;

import com.nashtech.finalcucumber.utils.APIConstant;
import com.nashtech.finalcucumber.utils.CookieUtil;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserHelper extends RequestHelper {

    private String prefixUrl = APIConstant.DEMOQA_HOST + APIConstant.DEMOQA_USER_PREFIX;

    public Response generateToken(String userName, String password) {
        String url = prefixUrl + APIConstant.GENERATE_TOKEN_ENDPOINT;
        JSONObject body = new JSONObject();
        body.put("userName", userName);
        body.put("password", password);
        Response response = sendRequest(
                APIConstant.RequestType.POST,
                url,
                null,
                body.toString());
        return response;
    }
}
