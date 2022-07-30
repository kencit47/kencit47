package com.wtf.springbootone.repository;

import reactor.core.publisher.Flux;

public interface FluxRepository {

    Flux<String> getFlux();
}
