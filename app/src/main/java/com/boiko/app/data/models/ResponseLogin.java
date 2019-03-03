package com.boiko.app.data.models;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin {

    @SerializedName("access_token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
