package com.boiko.app.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseFetalHeartbeat {

    @SerializedName("beats_per_second")
    @Expose
    private Integer beatsPerSecond;
    @SerializedName("partogramm_id")
    @Expose
    private Integer id;
    @SerializedName("time")
    @Expose
    private String time;

    public Integer getBeatsPerSecond() {
        return beatsPerSecond;
    }

    public void setBeatsPerSecond(Integer beatsPerSecond) {
        this.beatsPerSecond = beatsPerSecond;
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
