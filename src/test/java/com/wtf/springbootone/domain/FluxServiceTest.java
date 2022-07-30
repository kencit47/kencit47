package com.wtf.springbootone.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FluxServiceTest {

    @InjectMocks
    private FluxService fluxService;

    @Test
    void testThis() {
        final var actual = fluxService.plusThings(1, 1);

        assertEquals(1, actual);

    }
}
