package org.example.sealed2.service;

import java.util.List;

final public class ResultExtraInfo extends Result {

    final String documenttId;
    final List<String> extraParameters;

    public ResultExtraInfo(String documenttId, List<String> extraParameters) {
        this.documenttId = documenttId;
        this.extraParameters = extraParameters;
    }

    public String getDocumenttId() {
        return documenttId;
    }

    public List<String> getExtraParameters() {
        return extraParameters;
    }

    @Override
    public String toString() {
        return "DocumentDecoderResultExtraInfo{" +
                "documenttId='" + documenttId + '\'' +
                ", extraParameters=" + extraParameters +
                '}';
    }

}
