package com.saude.agenda.api.admin;

import com.saude.agenda.api.admin.dto.AdminDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping
    public List<Admin> getAll(@PageableDefault Pageable pageable) {
            return service.getAll(pageable);
        }

    @GetMapping("/{id}")
    public AdminDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<AdminDto> register(@RequestBody @Valid AdminDto data, UriComponentsBuilder uriBuilder) {
        AdminDto admin = service.register(data);
        URI location = uriBuilder.path("/admin/{id}").buildAndExpand(admin.getId()).toUri();
        return ResponseEntity.created(location).body(admin);
    }

}
