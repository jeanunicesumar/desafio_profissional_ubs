package com.saude.agenda.api.adapter;

public interface Adapter<Dto, Entity> {

    Dto fromEntity(Entity entity);

    Entity fromDto(Dto dto);

}
