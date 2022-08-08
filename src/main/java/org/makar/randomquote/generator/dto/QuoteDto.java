package org.makar.randomquote.generator.dto;

import lombok.Data;

@Data
public class QuoteDto {
    private String quote;
    private AuthorDto author;
}
