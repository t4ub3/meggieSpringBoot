package com.meggie.server.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(	name = "fuel_records")
public class FuelRecord {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer mileage;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull
    private Float amount;

    @NotNull
    private boolean isPending;

    public FuelRecord() {
    }

    public FuelRecord(Integer mileage, Date date, Float amount, boolean isPending) {
        this.mileage = mileage;
        this.date = date;
        this.amount = amount;
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

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
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