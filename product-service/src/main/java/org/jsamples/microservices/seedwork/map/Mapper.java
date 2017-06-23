package org.jsamples.microservices.seedwork.map;

import org.modelmapper.ModelMapper;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class Mapper {
    private ModelMapper delegate;

    public Mapper() {
        delegate = new ModelMapper();
    }

    public <T> T map(Object source, Class<T> clazz) {
        return delegate.map(source, clazz);
    }

    public <T> Stream<T> map(Stream<?> source, Class<T> clazz) {
        return source.map(obj -> this.map(obj, clazz));
    }

    void configure(Consumer<ModelMapper> configuration) {
        configuration.accept(delegate);
    }
}
