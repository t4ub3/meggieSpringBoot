package com.meggie.server.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(	name = "payment_records")
public class PaymentRecord {
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

    public PaymentRecord() {
    }

    public PaymentRecord(Integer mileage, Date date, Float amount) {
        this.mileage = mileage;
        this.date = date;
        this.amount = amount;
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
}