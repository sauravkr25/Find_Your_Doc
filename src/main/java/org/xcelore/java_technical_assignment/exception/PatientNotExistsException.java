package org.xcelore.java_technical_assignment.exception;

public class PatientNotExistsException extends RuntimeException{

    public PatientNotExistsException(String msg) {
        super(msg);
    }
}
