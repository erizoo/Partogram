package com.boiko.app.data.models;

import com.google.gson.annotations.SerializedName;

public class ResponseStatus {

    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
