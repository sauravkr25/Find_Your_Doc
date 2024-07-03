package org.xcelore.java_technical_assignment.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xcelore.java_technical_assignment.model.entity.Doctor;
import org.xcelore.java_technical_assignment.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody @Valid Doctor doctor){
        Doctor addedDoctor = doctorService.addDoctor(doctor);
        return new ResponseEntity<>(addedDoctor, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List<Doctor> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Integer id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
