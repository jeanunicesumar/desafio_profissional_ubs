package com.saude.agenda.api.ubs;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UbsService {

    @Autowired
    private UbsRepository ubsRepository;

    public Ubs findById(Long id) {
        return ubsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("UBS não encontrada"));
    }

}
