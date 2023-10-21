package com.saude.agenda.api.person.dto;

import com.saude.agenda.api.ubs.Ubs;
import lombok.Data;

@Data
public class ResponseDto {

    private Long id;

    private String name;

    private String cpf;

    private Long ubs;

    private String nameUbs;

    private Boolean isDoctor;

    public ResponseDto(Long id, String name, String cpf, Long ubs, String nameUbs, Boolean isDoctor) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.isDoctor = isDoctor;
        this.nameUbs = nameUbs;
        this.ubs = ubs;
    }

}
