package org.makar.ramdomquotes.downloader.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.makar.ramdomquotes.downloader.service.DownloadService;
import org.makar.randomquotes.common.entity.Quote;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
public class DownloadQuotesService implements DownloadService<Quote> {
    @Value("${uri.quotes}")
    private String quotesUri;

    @Override
    public List<Quote> download() {
        log.info("Downloading list of quotes...");
        WebClient webClient = WebClient.create();
        Quote[] quotes = webClient
                .get()
                .uri(quotesUri)
                .retrieve()
                .bodyToMono(Quote[].class)
                .blockOptional()
                .orElse(new Quote[0]);
        log.info("Successfully downloaded list of {} quotes", quotes.length);
        return List.of(quotes);
    }
}
