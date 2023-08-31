package saude.agenda.api.doctor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import saude.agenda.api.doctor.dto.DoctorDto;
import saude.agenda.api.person.Gender;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {

    @InjectMocks
    DoctorService service;

    @Mock
    DoctorRepository repository;

    Doctor doctor;

    Pageable pageable;

    @BeforeEach
    public void setUp() {
        doctor = new Doctor(23712831,1L, "Cassia", "Marcia", "Carlos", new Date(1999, 11, 23),
                        "cassia@gmail.com", Gender.FEMININO, "44", "99999-9999", "321321312"
        );

        pageable = PageRequest.of(0, 5);

    }


    @Test
    void should_service_get_all_return_page_person() {
        when(repository.findAll()).thenReturn(Collections.singletonList(doctor));

        List<DoctorDto> doctors = service.getAll();

        assertEquals(repository.findAll(), doctors);
        verifyNoMoreInteractions(repository);

    }
}