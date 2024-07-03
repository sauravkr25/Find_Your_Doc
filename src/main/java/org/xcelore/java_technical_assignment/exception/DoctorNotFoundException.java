package org.xcelore.java_technical_assignment.exception;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(String msg) {
        super(msg);
    }
}
