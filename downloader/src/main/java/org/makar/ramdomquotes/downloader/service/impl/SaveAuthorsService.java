package org.makar.ramdomquotes.downloader.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.makar.ramdomquotes.downloader.service.DownloadService;
import org.makar.ramdomquotes.downloader.service.SaveService;
import org.makar.randomquotes.common.entity.Author;
import org.makar.randomquotes.common.repository.AuthorsRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaveAuthorsService implements SaveService<Author> {
    private final DownloadService<Author> downloadAuthorsService;
    private final AuthorsRepository authorsRepository;

    @Scheduled(fixedRate = 30000)
    @Override
    public void save() {
        List<Author> authors = downloadAuthorsService.download();
        log.info("Saving list of authors...");
        authorsRepository.saveAll(authors);
        log.info("Successfully saved list of {} authors", authors.size());
    }
}
