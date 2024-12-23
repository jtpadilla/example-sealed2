package org.example.sealed2.service.spi.catalog;

import org.example.sealed2.app.data.util.Decoder;
import org.example.sealed2.app.data.util.DecoderData;
import org.example.sealed2.service.Result;
import org.example.sealed2.service.ResultSimple;
import org.example.sealed2.service.spi.DecoderAppender;

import java.util.Optional;

public class DecoderWithoutParameters {

    static public void install(DecoderAppender appender) {
        appender.append(DecoderWithoutParameters::decodeForOneParameter);
    }

    static public Optional<Result> decodeForOneParameter(String rawDocument) {
        final DecoderData decoderData = Decoder.decode(rawDocument);
        if (decoderData.parameters().isEmpty()) {
            return Optional.of(new ResultSimple(decoderData.type()));
        } else {
            return Optional.empty();
        }
    }

}
