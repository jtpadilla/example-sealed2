package org.example.sealed2.app;

import org.example.sealed2.app.data.ExampleDocuments;
import org.example.sealed2.service.*;

import java.util.List;

public class EjemploServlet {

    public static void main(String[] args) {
        new EjemploServlet().run();
    }

    public void run() {

        final EjemploServlet ejemploServlet = new EjemploServlet();

        for (String rawDocument : ExampleDocuments.RAW_DOCUMENTS) {
            try {
                final ServletResponse response = ejemploServlet.mapDocumentoToResonse(rawDocument);
                System.out.println("OK -> " + response);
            } catch (DecoderException e) {
                System.out.println("Error -> " + e.getMessage());
            }
        }


    }

    //////////////////////////////////////////
    /// Instancia
    //////////////////////////////////////////

    final DecoderService decoderService = DecoderService.getInstance();

    public EjemploServlet() {
    }

    public ServletResponse mapDocumentoToResonse(String rawDocument) throws DecoderException {
        return switch (decoderService.decode(rawDocument)) {
            case ResultSimple resultSimple -> new ServletResponse(resultSimple.getDocumenttId(), List.of());
            case ResultExtraInfo resultExtraInfo -> new ServletResponse(resultExtraInfo.getDocumenttId(), resultExtraInfo.getExtraParameters());
            case ResultInvalid resultInvalid -> new ServletResponse("codigoespecial", List.of());
        };
    }

    //////////////////////////////////////////
    /// Simula la respuesta REST
    //////////////////////////////////////////

    static class ServletResponse {

        final String documentType;
        final List<String> parameters;

        public ServletResponse(String documentType, List<String> parameters) {
            this.documentType = documentType;
            this.parameters = parameters;
        }

        @Override
        public String toString() {
            return "ServletResponse{" +
                    "documentType='" + documentType + '\'' +
                    ", parameters=" + parameters +
                    '}';
        }

    }

}
