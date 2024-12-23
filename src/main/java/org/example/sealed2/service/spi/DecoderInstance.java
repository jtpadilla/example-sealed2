package org.example.sealed2.service.spi;

import org.example.sealed2.service.Result;

import java.util.Optional;

@FunctionalInterface
public interface DecoderInstance {
    Optional<Result> parse(String rawDocument);
}
