package org.makar.spring3training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class HelloWorldController {
    @GetMapping("/")
    public Mono<String> helloWorld() {
        return Mono.just("Hello World!");
    }
}
