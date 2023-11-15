package com.saude.agenda.api.address;

import com.saude.agenda.api.ubs.Ubs;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddressTest {

    @Test
    public void testSetAddress(){
        Long id = 3L;
        Address address = new Address("87050390", "Avenida Guedner", "Casa", "1025", "Zona 8", "Maringá", "PR");
        Ubs ubs = new Ubs(1L, "Jardim Aclimacao", address);
        String zipCode = "87050390";
        String streetAddress = "Avenida Guedner";
        String streetAddressII = "Casa";
        String number = "1000";
        String district = "Jardim Aclimacao";
        String city = "Maringa";
        String uf = "PR";

        Address address1 = new Address (id, ubs, zipCode, streetAddress, streetAddressII, number, district, city, uf);

        assertNotNull(address1);
        assertEquals(id, address1.getId());
        assertEquals(ubs, address1.getUbs());
        assertEquals(zipCode, address1.getZipCode());
        assertEquals(streetAddress, address1.getStreetAddress());
        assertEquals(streetAddressII, address1.getStreetAddressII());
        assertEquals(number, address1.getNumber());
        assertEquals(district, address1.getDistrict());
        assertEquals(city, address1.getCity());
        assertEquals(uf, address1.getUf());
    }
}
