package org.makar.randomquote.generator.service.impl;

import lombok.RequiredArgsConstructor;
import org.makar.randomquote.generator.entity.Author;
import org.makar.randomquote.generator.entity.Quote;
import org.makar.randomquote.generator.repository.QuotesRepository;
import org.makar.randomquote.generator.service.QuoteService;
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
