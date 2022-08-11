package org.makar.ramdomquotes.downloader.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.makar.ramdomquotes.downloader.service.DownloadService;
import org.makar.ramdomquotes.downloader.service.SaveService;
import org.makar.randomquotes.common.entity.Author;
import org.makar.randomquotes.common.entity.Quote;
import org.makar.randomquotes.common.repository.AuthorsRepository;
import org.makar.randomquotes.common.repository.QuotesRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaveQuotesService implements SaveService<Quote> {
    private final DownloadService<Quote> downloadQuotesService;
    private final QuotesRepository quotesRepository;
    private final AuthorsRepository authorsRepository;

    @Scheduled(fixedRate = 45000)
    @Override
    public void save() {
        List<Quote> quotes = downloadQuotesService.download();
        log.info("Saving list of quotes...");
        for (Quote quote : quotes) {
            Optional<Author> optionalAuthor = authorsRepository.findRandom();
            if (optionalAuthor.isEmpty()) {
                log.warn("No authors are present in the database, can't save the quotes");
                return;
            }
            quote.setAuthor(optionalAuthor.get());
        }
        quotesRepository.saveAll(quotes);
        log.info("Successfully saved list of {} quotes", quotes.size());
    }
}
