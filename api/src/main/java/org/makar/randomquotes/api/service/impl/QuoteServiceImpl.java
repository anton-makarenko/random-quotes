package org.makar.randomquotes.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.makar.randomquotes.common.entity.Author;
import org.makar.randomquotes.common.entity.Quote;
import org.makar.randomquotes.api.service.QuoteService;
import org.makar.randomquotes.common.repository.QuotesRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuotesRepository quotesRepository;

    @Override
    public Quote getRandomQuote() {
        Quote emptyQuote = new Quote();
        emptyQuote.setQuote("The database is empty.");
        Author emptyAuthor = new Author();
        emptyAuthor.setName("The");
        emptyAuthor.setSurname("Developer");
        emptyAuthor.setQuotes(Set.of(emptyQuote));
        emptyQuote.setAuthor(emptyAuthor);
        return quotesRepository.findRandom().orElse(emptyQuote);
    }
}
