package org.example.sealed2.app.data.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decoder {

    static public DecoderData decode(String rawDocument) {
        final String document = rawDocument.trim();
        final String[] split = document.split(",");
        // La Lista retornada por 'Arrays.asList(split)' no implementa 'removeFirst()' porque es inmutable
        final List<String> list = new ArrayList<>(Arrays.asList(split));
        return new DecoderData(list.removeFirst(), list);
    }

}
