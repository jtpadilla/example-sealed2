package org.example.sealed2.service.impl.catalog;

import org.example.sealed2.service.DecoderException;
import org.example.sealed2.service.Result;
import org.example.sealed2.service.ResultExtraInfo;
import org.example.sealed2.service.impl.util.Decoder;
import org.example.sealed2.service.impl.util.DecoderData;
import org.example.sealed2.service.spi.DecoderAppender;

import java.util.Optional;

public class DecoderFrom3Parameters {

    static public void install(DecoderAppender appender) {
        appender.append(DecoderFrom3Parameters::decodeForThreeParameters);
    }

    static public Optional<Result> decodeForThreeParameters(String rawDocument) throws DecoderException {
        final DecoderData decoderData = Decoder.decode(rawDocument);
        if (decoderData.parameters().size() == 3) {
            return Optional.of(new ResultExtraInfo(decoderData.type(), decoderData.parameters()));
        } else {
            return Optional.empty();
        }
    }

}