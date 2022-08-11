package org.makar.randomquotes.api.controller;

import lombok.RequiredArgsConstructor;
import org.makar.randomquotes.api.dto.QuoteDto;
import org.makar.randomquotes.common.entity.Quote;
import org.makar.randomquotes.api.service.Mapper;
import org.makar.randomquotes.api.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/quotes")
@RequiredArgsConstructor
public class QuotesController {
    private final QuoteService quoteService;
    private final Mapper<Quote, QuoteDto> quoteMapper;

    @GetMapping("/random")
    public Mono<QuoteDto> randomQuote() {
        return Mono.just(quoteMapper.toDto(quoteService.getRandomQuote()));
    }
}
