package com.wtf.springbootone.domain;

import com.wtf.springbootone.repository.FluxRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FluxServiceTest {

    @InjectMocks
    private FluxService fluxService;

    @Mock
    private FluxRepository fluxRepository;
}
