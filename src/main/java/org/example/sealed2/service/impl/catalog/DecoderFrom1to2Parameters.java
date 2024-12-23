package org.example.sealed2.service.impl.catalog;

import org.example.sealed2.service.DecoderException;
import org.example.sealed2.service.Result;
import org.example.sealed2.service.ResultExtraInfo;
import org.example.sealed2.service.impl.util.Decoder;
import org.example.sealed2.service.impl.util.DecoderData;
import org.example.sealed2.service.spi.DecoderAppender;

import java.util.Optional;

public class DecoderFrom1to2Parameters {

    static public void install(DecoderAppender appender) {
        appender.append(DecoderFrom1to2Parameters::decodeForOneParameter);
        appender.append(DecoderFrom1to2Parameters::decodeForTwoParameters);
    }

    static public Optional<Result> decodeForOneParameter(String rawDocument) throws DecoderException {
        final DecoderData decoderData = Decoder.decode(rawDocument);
        if (decoderData.parameters().size() == 1) {
            return Optional.of(new ResultExtraInfo(decoderData.type(), decoderData.parameters()));
        } else {
            return Optional.empty();
        }
    }

    static public Optional<Result> decodeForTwoParameters(String rawDocument) throws DecoderException {
        final DecoderData decoderData = Decoder.decode(rawDocument);
        if (decoderData.parameters().size() == 2) {
            return Optional.of(new ResultExtraInfo(decoderData.type(), decoderData.parameters()));
        } else {
            return Optional.empty();
        }
    }

}
