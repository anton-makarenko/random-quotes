package org.makar.randomquote.generator.service.impl;

import org.makar.randomquote.generator.dto.AuthorDto;
import org.makar.randomquote.generator.entity.Author;
import org.makar.randomquote.generator.service.Mapper;
import org.springframework.stereotype.Service;

@Service
public class AuthorMapper implements Mapper<Author, AuthorDto> {
    @Override
    public AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());
        return authorDto;
    }
}
