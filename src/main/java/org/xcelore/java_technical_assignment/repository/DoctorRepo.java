package org.xcelore.java_technical_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.xcelore.java_technical_assignment.model.entity.Doctor;
import org.xcelore.java_technical_assignment.model.enums.City;
import org.xcelore.java_technical_assignment.model.enums.Speciality;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    List<Doctor> findByCityAndSpeciality(City patientCityEnum, Speciality speciality);
}
