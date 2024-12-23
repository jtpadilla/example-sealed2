package org.example.sealed2.app.data.util;

import org.example.sealed2.service.DecoderException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decoder {

    static public DecoderData decode(String rawDocument) throws DecoderException {
        final String document = rawDocument.trim();
        final String[] split = document.split(",");
        // La Lista retornada por 'Arrays.asList(split)' no implementa 'removeFirst()' porque es inmutable
        final List<String> list = new ArrayList<>(Arrays.asList(split));
        if (list.size() > 200) {
            throw new DecoderException("Demasiados parametros");
        }
        return new DecoderData(list.removeFirst(), list);
    }

}
