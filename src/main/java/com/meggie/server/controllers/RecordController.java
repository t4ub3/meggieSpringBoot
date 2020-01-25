package com.meggie.server.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.meggie.server.models.AllRecords;
import com.meggie.server.models.DrivingRecord;
import com.meggie.server.models.FuelRecord;
import com.meggie.server.models.PaymentRecord;
import com.meggie.server.payload.request.RecordRequest;
import com.meggie.server.payload.request.UpdatePendingRequest;
import com.meggie.server.repositories.DrivingRecordRepository;
import com.meggie.server.repositories.FuelRecordRepository;
import com.meggie.server.repositories.PaymentRecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/record")
public class RecordController {

    @Autowired
	DrivingRecordRepository drivingRecordRepository;

	@Autowired
	FuelRecordRepository fuelRecordRepository;

	@Autowired
	PaymentRecordRepository paymentRecordRepository;

	// DRIVING RECORDS

	@GetMapping("/driving")
	@PreAuthorize("hasRole('USER')") 
	public List<DrivingRecord> getDrivingRecords() {
		return drivingRecordRepository.findAll();
	}

	@PostMapping("/driving")
	@PreAuthorize("hasRole('USER')")
	public String addDrivingRecord(@Valid @RequestBody RecordRequest recordRequest) {
		DrivingRecord drivingRecord = new DrivingRecord(
			recordRequest.getMileage(),
			new Date(),
			recordRequest.getDistance(),
			true
		);

		drivingRecordRepository.save(drivingRecord);

		return "added Driving Record successfully";
	}

	@PatchMapping("/driving")
	@PreAuthorize("hasRole('USER')")
	public String updatePendingDrivingRecord(@Valid @RequestBody UpdatePendingRequest updatePendingRequest) {
		Optional<DrivingRecord> drivingRecordOptional = drivingRecordRepository.findById(updatePendingRequest.getId());
		if (!drivingRecordOptional.isPresent()) {
			return "No Driving Record for ID!";
		}

		DrivingRecord drivingRecord = drivingRecordOptional.get();
		drivingRecord.setIsPending(updatePendingRequest.getIsPending());

		drivingRecordRepository.save(drivingRecord);

		return "updated Driving Record successfully";
	}

	// FUEL RECORDS

	@GetMapping("/fuel")
	@PreAuthorize("hasRole('USER')")
	public List<FuelRecord> getFuelRecords() {
		return fuelRecordRepository.findAll();
	}

	@PostMapping("/fuel")
	@PreAuthorize("hasRole('USER')")
	public String addFuelRecord(@Valid @RequestBody RecordRequest recordRequest) {
		FuelRecord fuelRecord = new FuelRecord(
			recordRequest.getMileage(),
			new Date(),
			recordRequest.getAmount(),
			true
		);

		fuelRecordRepository.save(fuelRecord);

		return "added Fuel Record successfully";
	}

	@PatchMapping("/fuel")
	@PreAuthorize("hasRole('USER')")
	public String updatePendingFuelRecord(@Valid @RequestBody UpdatePendingRequest updatePendingRequest) {
		Optional<FuelRecord> fuelRecordOptional = fuelRecordRepository.findById(updatePendingRequest.getId());
		if (!fuelRecordOptional.isPresent()) {
			return "No Fuel Record for ID!";
		}

		FuelRecord fuelRecord = fuelRecordOptional.get();
		fuelRecord.setIsPending(updatePendingRequest.getIsPending());

		fuelRecordRepository.save(fuelRecord);

		return "updated Fuel Record successfully";
	}

	// PAYMENT RECORDS

	@GetMapping("/payment")
	@PreAuthorize("hasRole('USER')")
	public List<PaymentRecord> getPaymentRecords() {
		return paymentRecordRepository.findAll();
	}

	@PostMapping("/payment")
	@PreAuthorize("hasRole('USER')")
	public String addPaymentRecord(@Valid @RequestBody RecordRequest recordRequest) {
		PaymentRecord paymentRecord = new PaymentRecord(
			recordRequest.getMileage(),
			new Date(),
			recordRequest.getAmount()
		);

		paymentRecordRepository.save(paymentRecord);

		return "added Payment Record successfully";
	}

	// ALL RECORDS

	@GetMapping("/all")
	@PreAuthorize("hasRole('USER')")
	public AllRecords getAllRecords() {
		return new AllRecords(paymentRecordRepository.findAll(), drivingRecordRepository.findAll(), fuelRecordRepository.findAll());
	}
}
