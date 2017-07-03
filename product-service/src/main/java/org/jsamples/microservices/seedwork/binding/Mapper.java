package org.jsamples.microservices.seedwork.binding;

import org.modelmapper.ModelMapper;
import java.util.function.Consumer;

public final class Mapper {
    private ModelMapper delegate;

    public Mapper() {
        delegate = new ModelMapper();
    }

    public <T> T map(Object source, Class<T> clazz) {
        return delegate.map(source, clazz);
    }

    public <T> T map(Object source, T obj) {
        delegate.map(source, obj);
        return obj;
    }

    void configure(Consumer<ModelMapper> configuration) {
        configuration.accept(delegate);
    }
}
