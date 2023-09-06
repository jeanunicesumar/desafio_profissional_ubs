package com.saude.agenda.api.exception;

public class PatientNotFoundException extends Exception {
    public PatientNotFoundException(){
        super("Paciente não encontrado");
    }
}
