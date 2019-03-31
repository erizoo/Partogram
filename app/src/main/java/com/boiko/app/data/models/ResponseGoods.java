package com.boiko.app.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseGoods {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("isSended")
    @Expose
    private Integer isSended;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("name_supplier")
    @Expose
    private String nameSupplier;
    @SerializedName("id_transit")
    @Expose
    private String idTransit;
    @Expose
    private Boolean checked;
    @SerializedName("cash_to")
    @Expose
    private Boolean cashTo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getSended() {
        return isSended;
    }

    public void setSended(Integer sended) {
        isSended = sended;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getIsSended() {
        return isSended;
    }

    public void setIsSended(Integer isSended) {
        this.isSended = isSended;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getIdTransit() {
        return idTransit;
    }

    public void setIdTransit(String idTransit) {
        this.idTransit = idTransit;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
