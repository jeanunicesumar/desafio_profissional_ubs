package com.saude.agenda.api.ubs.dto;

import com.saude.agenda.api.address.dto.AddressDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UbsDto {

    private Long id;

    @NotBlank(message = "Insira uma descrição")
    private String name;

    @NotNull
    private AddressDto address;

}
