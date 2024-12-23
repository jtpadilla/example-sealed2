package org.example.sealed2.service.spi;

import org.example.sealed2.service.impl.catalog.DecoderFrom1to2Parameters;
import org.example.sealed2.service.impl.catalog.DecoderFrom3Parameters;
import org.example.sealed2.service.impl.catalog.DecoderWithoutParameters;

public class DecoderProvider {

    static public final DecoderAppender appender;

    static {

        // Se cre el appender
        appender = new DecoderAppender();

        // Y se instslan los decoders
        DecoderFrom1to2Parameters.install(appender);
        DecoderFrom3Parameters.install(appender);
        DecoderWithoutParameters.install(appender);

    }

}
