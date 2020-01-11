package com.meggie.server.payload.request;

import javax.validation.constraints.NotNull;

public class RecordRequest {
    @NotNull
    private Integer mileage;

    private Integer distance;

    private Float amount;

    public Integer getMileage() {
        return this.mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

}