package org.makar.randomquotes.api.dto;

import lombok.Data;

@Data
public class QuoteDto {
    private String quote;
    private AuthorDto author;
}
