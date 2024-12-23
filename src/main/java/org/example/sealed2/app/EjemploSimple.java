package org.example.sealed2.app;

import org.example.sealed2.app.data.ExampleDocuments;
import org.example.sealed2.service.*;

public class EjemploSimple {

    public static void main(String[] args) {
        new EjemploSimple().run();
    }

    public void run() {

        final DecoderService decoderService = DecoderService.getInstance();

        for (String rawDocument : ExampleDocuments.RAW_DOCUMENTS) {
            try {
                final Result documentTypeInfo = decoderService.decode(rawDocument);
                switch (decoderService.decode(rawDocument)) {
                    case ResultSimple resultSimple -> System.out.println("OK -> " + resultSimple);
                    case ResultExtraInfo resultExtraInfo -> System.out.println("OK -> " + resultExtraInfo);
                    case ResultInvalid resultInvalid -> System.out.println("OK(INVALID) -> " + resultInvalid);
                }
            } catch (DecoderException e) {
                System.out.println("Error -> " + e.getMessage());
            }
        }

    }

}