package saude.agenda.api.address;

public record AddressRecord(String zipCode,
                            String street,
                            String number,
                            String neighborhood,
                            String city,
                            String uf) {

}
