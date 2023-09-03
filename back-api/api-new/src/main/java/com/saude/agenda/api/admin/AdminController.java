package com.saude.agenda.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping
    public List<Admin> getAll(@PageableDefault Pageable pageable) {
            return service.getAll(pageable);
        }

}
