package org.makar.randomquote.generator.service;

public interface Mapper<ENTITY, DTO> {
    DTO toDto(ENTITY entity);
}
