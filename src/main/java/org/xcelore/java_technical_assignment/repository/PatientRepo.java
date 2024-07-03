package org.xcelore.java_technical_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xcelore.java_technical_assignment.model.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
}
