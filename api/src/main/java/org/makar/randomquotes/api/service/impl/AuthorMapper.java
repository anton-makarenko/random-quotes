package org.makar.randomquotes.api.service.impl;

import org.makar.randomquotes.api.dto.AuthorDto;
import org.makar.randomquotes.common.entity.Author;
import org.makar.randomquotes.api.service.Mapper;
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
