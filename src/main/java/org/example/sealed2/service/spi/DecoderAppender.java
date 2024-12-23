package org.example.sealed2.service.spi;

import java.util.ArrayList;
import java.util.List;

public class DecoderAppender {

    final ArrayList<DecoderInstance> instances = new ArrayList<>();

    public void append(DecoderInstance instance) {
        instances.add(instance);
    }

    public List<DecoderInstance> getInstances() {
        return instances;
    }

}
