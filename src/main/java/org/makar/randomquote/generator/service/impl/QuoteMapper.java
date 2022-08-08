package org.makar.randomquote.generator.service.impl;

import lombok.Data;
import org.makar.randomquote.generator.dto.AuthorDto;
import org.makar.randomquote.generator.dto.QuoteDto;
import org.makar.randomquote.generator.entity.Author;
import org.makar.randomquote.generator.entity.Quote;
import org.makar.randomquote.generator.service.Mapper;
import org.springframework.stereotype.Service;

@Service
@Data
public class QuoteMapper implements Mapper<Quote, QuoteDto> {
    private final Mapper<Author, AuthorDto> authorMapper;
    @Override
    public QuoteDto toDto(Quote quote) {
        AuthorDto authorDto = authorMapper.toDto(quote.getAuthor());
        QuoteDto quoteDto = new QuoteDto();
        quoteDto.setQuote(quote.getQuote());
        quoteDto.setAuthor(authorDto);
        return quoteDto;
    }
}
