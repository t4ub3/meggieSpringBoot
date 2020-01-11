package com.meggie.server.payload.request;

import javax.validation.constraints.NotNull;

public class RecordRequest {
    @NotNull
    private Integer mileage;

    private Integer distance;

    private boolean isPending;

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

    public boolean isIsPending() {
        return this.isPending;
    }

    public boolean getIsPending() {
        return this.isPending;
    }

    public void setIsPending(boolean isPending) {
        this.isPending = isPending;
    }

}