package org.xcelore.java_technical_assignment.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xcelore.java_technical_assignment.exception.PatientNotExistsException;
import org.xcelore.java_technical_assignment.model.entity.Doctor;
import org.xcelore.java_technical_assignment.model.entity.Patient;
import org.xcelore.java_technical_assignment.service.DoctorService;
import org.xcelore.java_technical_assignment.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {


    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody @Valid Patient patient){
        Patient addedPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(addedPatient, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // API for suggesting doctors
    @GetMapping("/suggest/{id}")
    public ResponseEntity<List<Doctor>> suggestDoctors(@PathVariable Integer id) throws PatientNotExistsException {
        List<Doctor> suggestedDoctors = patientService.suggestDoctors(id);
        return new ResponseEntity<>(suggestedDoctors, HttpStatus.OK);
    }




}
