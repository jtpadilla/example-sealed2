package org.example.sealed2.app;

import org.example.sealed2.app.data.ExampleDocuments;
import org.example.sealed2.service.DecoderService;
import org.example.sealed2.service.ResultExtraInfo;
import org.example.sealed2.service.ResultInvalid;
import org.example.sealed2.service.ResultSimple;

public class EjemploSimple {

    public static void main(String[] args) {
        new EjemploSimple().run();
    }

    public void run() {

        final DecoderService decoderService = DecoderService.getInstance();

        for (String rawDocument : ExampleDocuments.RAW_DOCUMENTS) {
            switch (decoderService.decode(rawDocument)) {
                case ResultSimple resultSimple -> System.out.println("OK -> " + resultSimple);
                case ResultExtraInfo resultExtraInfo -> System.out.println("OK -> " + resultExtraInfo);
                case ResultInvalid resultInvalid -> System.out.println("OK(INVALID) -> " + resultInvalid);
            }
        }

    }

}