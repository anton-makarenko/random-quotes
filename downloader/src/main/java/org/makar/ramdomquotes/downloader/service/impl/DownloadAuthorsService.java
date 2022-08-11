package org.makar.ramdomquotes.downloader.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.makar.ramdomquotes.downloader.service.DownloadService;
import org.makar.randomquotes.common.entity.Author;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
public class DownloadAuthorsService implements DownloadService<Author> {
    @Value("${uri.authors}")
    private String authorsUri;

    @Override
    public List<Author> download() {
        log.info("Downloading list of authors...");
        WebClient webClient = WebClient.create();
        Author[] authors = webClient
                .get()
                .uri(authorsUri)
                .retrieve()
                .bodyToMono(Author[].class)
                .blockOptional()
                .orElse(new Author[0]);
        log.info("Successfully downloaded list of {} authors", authors.length);
        return List.of(authors);
    }
}
