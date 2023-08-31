package saude.agenda.api.adapter;

import saude.agenda.api.person.Person;
import saude.agenda.api.person.dto.PersonDto;

public interface Adapter<Dto, Entity> {
    Dto fromEntity(Entity entity);

    Entity fromDto(Dto dto);
}
