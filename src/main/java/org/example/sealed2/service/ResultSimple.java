package org.example.sealed2.service;

final public class ResultSimple extends Result {

    final String documenttId;

    public ResultSimple(String documenttId) {
        this.documenttId = documenttId;
    }

    public String getDocumenttId() {
        return documenttId;
    }

    @Override
    public String toString() {
        return "DocumentDecoderResultSimple{" +
                "documenttId='" + documenttId + '\'' +
                '}';
    }

}
