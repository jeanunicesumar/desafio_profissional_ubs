package saude.agenda.api.doctor;


//DTO para retorno dos dados do médico pesquisado - somente vai retornar nome, crm e especialidade
public record DoctorGet(Long id, String fullName, String crm, Specialty specialty) {

    public DoctorGet(Doctor doctor){
        this(doctor.getId(), doctor.getFullName(), doctor.getCrm(), doctor.getSpecialty());
    }

}
