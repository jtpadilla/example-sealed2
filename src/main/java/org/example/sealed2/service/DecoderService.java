package org.example.sealed2.service;

import org.example.sealed2.service.spi.catalog.DecoderFrom1to2Parameters;
import org.example.sealed2.service.spi.catalog.DecoderFrom3Parameters;
import org.example.sealed2.service.spi.catalog.DecoderWithoutParameters;
import org.example.sealed2.service.spi.DecoderAppender;
import org.example.sealed2.service.spi.DecoderInstance;

import java.util.List;
import java.util.Optional;

public class DecoderService {

    static public DecoderService getInstance() {
        return INSTANCE;
    }

    static private DecoderService INSTANCE;

    static {
        final DecoderAppender appender = new DecoderAppender();
        DecoderFrom1to2Parameters.install(appender);
        DecoderFrom3Parameters.install(appender);
        DecoderWithoutParameters.install(appender);
        INSTANCE = new DecoderService(appender.getInstances());
    }

    private List<DecoderInstance> docoders;

    private DecoderService(List<DecoderInstance> docoders) {
        this.docoders = docoders;
    }

    public Result decode(String rawDocument) throws DecoderException {
        for (DecoderInstance instance : docoders) {
            final Optional<Result> document = instance.parse(rawDocument);
            if (document.isPresent()) {
                return document.get();
            }
        }
        return new ResultInvalid(rawDocument);
    }

}
