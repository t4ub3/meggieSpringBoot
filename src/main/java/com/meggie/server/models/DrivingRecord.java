package com.meggie.server.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(	name = "driving_records")
public class DrivingRecord {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer mileage;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull
    private Integer distance;

    @NotNull
    private boolean isPending;

    public DrivingRecord() {
    }

    public DrivingRecord(Integer mileage, Date date, Integer distance, boolean isPending) {
        this.mileage = mileage;
        this.date = date;
        this.distance = distance;
        this.isPending = isPending;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getMileage() {
        return this.mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
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