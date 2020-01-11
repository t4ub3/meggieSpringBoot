package com.meggie.server.repositories;

import com.meggie.server.models.DrivingRecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingRecordRepository extends JpaRepository<DrivingRecord, Long> {
}