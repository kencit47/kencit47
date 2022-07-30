package com.wtf.springbootone.domain;

import com.wtf.springbootone.repository.FluxRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FluxServiceTest {

    @InjectMocks
    private FluxService fluxService;

    @Mock
    private FluxRepository fluxRepository;

    @Test
    void testFux() {

        when(fluxRepository.getFlux()).thenReturn(Flux.just("blue", "white", "red"));

        fluxService.stringFlux();

        verify(fluxRepository).getFlux();
    }
}
