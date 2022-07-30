package com.wtf.springbootone.domain;


import com.github.javafaker.Faker;
import com.wtf.springbootone.entity.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;

import static reactor.core.publisher.Flux.generate;

@Service
@RequiredArgsConstructor
public class FluxService {

    public Flux<News> stringFlux() {
        final Faker faker = new Faker();
        return generate((SynchronousSink<News> sink) -> sink.next(new News(faker.food().ingredient(), faker.food().ingredient())))
                .log()
                .delayElements(Duration.ofSeconds(1L));
    }

    public Integer plusThings(final int a, final int b) {
        return a + b;
    }
}
