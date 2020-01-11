package com.meggie.server.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.meggie.server.models.DrivingRecord;
import com.meggie.server.payload.request.RecordRequest;
import com.meggie.server.repositories.DrivingRecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/driving")
	public List<DrivingRecord> getDrivingRecords() {
		return drivingRecordRepository.findAll();
	}

	@PostMapping("/driving")
	public String addDrivingRecord(@Valid @RequestBody RecordRequest recordRequest) {
		DrivingRecord drivingRecord = new DrivingRecord(
			recordRequest.getMileage(),
			new Date(),
			recordRequest.getDistance(),
			true
		);

		drivingRecordRepository.save(drivingRecord);

		return "ok";
	}
}
