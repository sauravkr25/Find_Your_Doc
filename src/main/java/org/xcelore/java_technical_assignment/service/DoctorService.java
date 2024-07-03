package org.xcelore.java_technical_assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xcelore.java_technical_assignment.model.entity.Doctor;
import org.xcelore.java_technical_assignment.model.enums.City;
import org.xcelore.java_technical_assignment.model.enums.Speciality;
import org.xcelore.java_technical_assignment.repository.DoctorRepo;

import java.util.List;

@Service
public class DoctorService {

    private DoctorRepo doctorRepo;

    @Autowired
    public DoctorService(DoctorRepo doctorRepo){
        this.doctorRepo = doctorRepo;
    }
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public void deleteDoctor(Integer id) {
        doctorRepo.deleteById(id);
    }

    public List<Doctor> findByCityAndSpeciality(City patientCityEnum, Speciality speciality) {
        return doctorRepo.findByCityAndSpeciality(patientCityEnum,speciality);
    }
}
