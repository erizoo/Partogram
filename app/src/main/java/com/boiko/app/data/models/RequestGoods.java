package com.boiko.app.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestGoods {

    @SerializedName("skus")
    private List<RequestModel> requestModelList;

    public RequestGoods(List<RequestModel> requestModelList) {
        this.requestModelList = requestModelList;
    }

    public List<RequestModel> getRequestModelList() {
        return requestModelList;
    }

    public void setRequestModelList(List<RequestModel> requestModelList) {
        this.requestModelList = requestModelList;
    }
}
