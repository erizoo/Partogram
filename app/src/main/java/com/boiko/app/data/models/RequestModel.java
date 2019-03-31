package com.boiko.app.data.models;

import com.google.gson.annotations.SerializedName;

public class RequestModel {

    @SerializedName("sn")
    private String serialNumber;
    @SerializedName("sku")
    private String sku;
    @SerializedName("date")
    private String date;
    @SerializedName("price")
    private String price;
    @SerializedName("cash_to")
    private String cash_to;
    @SerializedName("supplier")
    private String supplier;
    @SerializedName("supplier2")
    private String supplierTwo;
    @SerializedName("id_transit")
    private String idTtransit;

    public RequestModel(String serialNumber, String sku, String date, String price, String cash_to, String supplier, String supplierTwo, String idTtransit) {
        this.serialNumber = serialNumber;
        this.sku = sku;
        this.date = date;
        this.price = price;
        this.cash_to = cash_to;
        this.supplier = supplier;
        this.supplierTwo = supplierTwo;
        this.idTtransit = idTtransit;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCash_to() {
        return cash_to;
    }

    public void setCash_to(String cash_to) {
        this.cash_to = cash_to;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierTwo() {
        return supplierTwo;
    }

    public void setSupplierTwo(String supplierTwo) {
        this.supplierTwo = supplierTwo;
    }

    public String getIdTtransit() {
        return idTtransit;
    }

    public void setIdTransit(String idTtransit) {
        this.idTtransit = idTtransit;
    }
}
