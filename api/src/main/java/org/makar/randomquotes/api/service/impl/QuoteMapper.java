package org.makar.randomquotes.api.service.impl;

import lombok.Data;
import org.makar.randomquotes.api.dto.AuthorDto;
import org.makar.randomquotes.api.dto.QuoteDto;
import org.makar.randomquotes.common.entity.Author;
import org.makar.randomquotes.common.entity.Quote;
import org.makar.randomquotes.api.service.Mapper;
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
