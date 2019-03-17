package com.boiko.app.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestTemp {

    @SerializedName("temperature")
    @Expose
    private Double temperature;
    @SerializedName("partogramm_id")
    @Expose
    private Integer id;
    @SerializedName("time")
    @Expose
    private String time;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
