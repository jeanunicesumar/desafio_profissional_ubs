package saude.agenda.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    private String zipCode;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String uf;
}
