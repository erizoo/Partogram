package com.boiko.app.data.models;

import java.util.List;

public class ResponseTransit {

    private List<ResponseSuppliers> suppliers;
    private List<ResponseGoods> transit;

    public List<ResponseSuppliers> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<ResponseSuppliers> suppliers) {
        this.suppliers = suppliers;
    }

    public List<ResponseGoods> getTransit() {
        return transit;
    }

    public void setTransit(List<ResponseGoods> transit) {
        this.transit = transit;
    }
}
