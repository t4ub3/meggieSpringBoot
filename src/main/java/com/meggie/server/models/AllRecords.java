package com.meggie.server.models;

import java.util.List;

public class AllRecords {
    List<PaymentRecord> paymentRecords;
    List<DrivingRecord> drivingRecords;
    List<FuelRecord> fuelRecords;

    public AllRecords(List<PaymentRecord> paymentRecords, List<DrivingRecord> drivingRecords, List<FuelRecord> fuelRecords) {
        this.paymentRecords = paymentRecords;
        this.drivingRecords = drivingRecords;
        this.fuelRecords = fuelRecords;
    }

    public List<PaymentRecord> getPaymentRecords() {
        return this.paymentRecords;
    }

    public List<DrivingRecord> getDrivingRecords() {
        return this.drivingRecords;
    }

    public List<FuelRecord> getFuelRecords() {
        return this.fuelRecords;
    }
}