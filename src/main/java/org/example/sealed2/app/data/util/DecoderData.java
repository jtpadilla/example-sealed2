package org.example.sealed2.app.data.util;

import org.example.sealed2.service.DecoderException;

import java.util.List;

public record DecoderData(String type, List<String> parameters) {

    public String getParameter1(int index) throws DecoderException {
        if (index < 0 || index >= parameters.size()) {
            throw new DecoderException("No hay ningun parametro en la posicion " + index);
        }
        return parameters.get(index);
    }

}
