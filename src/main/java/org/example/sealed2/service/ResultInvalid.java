package org.example.sealed2.service;

final public class ResultInvalid extends Result {

    final String rawDocument;

    public ResultInvalid(String rawDocument) {
        this.rawDocument = rawDocument;
    }

    public String getRawDocument() {
        return rawDocument;
    }

    @Override
    public String toString() {
        return "DocumentDecoderResultInvalid{" +
                "rawDocument='" + rawDocument + '\'' +
                '}';
    }

}
