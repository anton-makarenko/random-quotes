package org.makar.randomquotes.api.service;

public interface Mapper<ENTITY, DTO> {
    DTO toDto(ENTITY entity);
}
