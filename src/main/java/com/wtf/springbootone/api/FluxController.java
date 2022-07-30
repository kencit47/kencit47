package com.wtf.springbootone.api;

import com.wtf.springbootone.domain.FluxService;
import com.wtf.springbootone.entity.News;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flux")
public class FluxController {

    private final FluxService fluxService;

    @GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Flux<News> getAll() {
        return fluxService.stringFlux();
    }
}
