package org.makar.randomquote.generator.service.impl;

import org.makar.randomquote.generator.dto.QuoteDto;
import org.makar.randomquote.generator.entity.Quote;
import org.makar.randomquote.generator.service.Mapper;
import org.springframework.stereotype.Service;

@Service
public class QuoteMapper implements Mapper<Quote, QuoteDto> {
    @Override
    public QuoteDto toDto(Quote quote) {
        QuoteDto quoteDto = new QuoteDto();
        quoteDto.setQuote(quote.getQuote());
        quoteDto.setAuthorName(quote.getAuthor().getName());
        quoteDto.setAuthorSurname(quote.getAuthor().getSurname());
        return quoteDto;
    }
}
