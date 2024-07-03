package org.xcelore.java_technical_assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xcelore.java_technical_assignment.exception.DoctorNotFoundException;
import org.xcelore.java_technical_assignment.exception.InvalidCityException;
import org.xcelore.java_technical_assignment.exception.PatientNotExistsException;
import org.xcelore.java_technical_assignment.model.entity.Doctor;
import org.xcelore.java_technical_assignment.model.entity.Patient;
import org.xcelore.java_technical_assignment.model.enums.City;
import org.xcelore.java_technical_assignment.model.enums.Speciality;
import org.xcelore.java_technical_assignment.model.enums.Symptom;
import org.xcelore.java_technical_assignment.repository.PatientRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepo patientRepo;
    private DoctorService doctorService;

    @Autowired
    public PatientService(PatientRepo patientRepo, DoctorService doctorService){
        this.patientRepo = patientRepo;
        this.doctorService = doctorService;
    }

    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    public void deletePatient(Integer id) {
        patientRepo.deleteById(id);
    }

    public List<Doctor> suggestDoctors(Integer id) throws PatientNotExistsException {
        Optional<Patient> optionalPatient = patientRepo.findById(id);

        if(optionalPatient.isEmpty()){
            throw new PatientNotExistsException("Patient does not exist");
        }

        Patient patientFromDB = optionalPatient.get();

        String patientCity = patientFromDB.getCity();
        City patientCityEnum;
        try {
            patientCityEnum = City.valueOf(patientCity);
        } catch (IllegalArgumentException e) {
            throw new InvalidCityException("We are still waiting to expand to your location");
        }

        List<Doctor> suggestedDoctors = null;
        Symptom patientSymptom = patientFromDB.getSymptom();

        switch (patientSymptom) {
            case ARTHRITIS:
            case BACK_PAIN:
            case TISSUE_INJURIES:
                suggestedDoctors = doctorService.findByCityAndSpeciality(patientCityEnum, Speciality.ORTHOPAEDIC);
                break;
            case DYSMENORRHEA:
                suggestedDoctors = doctorService.findByCityAndSpeciality(patientCityEnum, Speciality.GYNECOLOGY);
                break;
            case SKIN_INFECTION:
            case SKIN_BURN:
                suggestedDoctors = doctorService.findByCityAndSpeciality(patientCityEnum, Speciality.DERMATOLOGY);
                break;
            case EAR_PAIN:
                suggestedDoctors = doctorService.findByCityAndSpeciality(patientCityEnum, Speciality.ENT_SPECIALIST);
                break;
        }

        if(suggestedDoctors == null || suggestedDoctors.isEmpty()){
            throw new DoctorNotFoundException("There isn’t any doctor present at your location for your symptom");
        }
        return suggestedDoctors;
    }
}
