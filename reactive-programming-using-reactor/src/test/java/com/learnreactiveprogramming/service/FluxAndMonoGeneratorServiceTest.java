package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoGeneratorServiceTest {
    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void nameFlux() {

        //when
        Flux<String> namesFlux = fluxAndMonoGeneratorService.namesFlux();

        //then
        StepVerifier.create(namesFlux)
                .expectNext("alex")
                .expectNextCount(2)
                .verifyComplete();

    }

    @Test
    void namesFluxMap() {

        //when
        Flux<String> names = fluxAndMonoGeneratorService.namesFluxMap();

        //then
        StepVerifier.create(names)
                .expectNext("ALEX", "BEN", "CHLOE")
                .verifyComplete();
    }

    @Test
    void namesFluxImmutability() {
        //when
        Flux<String> names = fluxAndMonoGeneratorService.namesFluxImmutability();

        //then
        StepVerifier.create(names)
                .expectNext("alex", "ben", "chloe")
                .verifyComplete();
    }
}