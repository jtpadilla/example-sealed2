package org.example.sealed2.service;

import org.example.sealed2.service.spi.DecoderInstance;
import org.example.sealed2.service.spi.DecoderProvider;

import java.util.List;
import java.util.Optional;

public class DecoderService {

    static public DecoderService getInstance() {
        return INSTANCE;
    }

    static private DecoderService INSTANCE;

    static {
        INSTANCE = new DecoderService(DecoderProvider.appender.getInstances());
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
