package org.jsamples.microservices.seedwork.controllers;

import org.jsamples.microservices.seedwork.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;

public class Controller<S extends Service> {
    private static final ResponseEntity<Void> NO_CONTENT = ResponseEntity.noContent().build();
    private @Autowired S service;

    protected ResponseEntity<Void> create(Function<S, Serializable> function) {
        return this.create(function, "/{id}");
    }

    protected ResponseEntity<Void> create(Function<S, Serializable> function, String path) {
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path(path).buildAndExpand(function.apply(service)).toUri()).build();
    }

    protected ResponseEntity<Void> perform(Consumer<S> function) {
        function.accept(service);
        return NO_CONTENT;
    }

    protected ResponseEntity<?> get(Function<S, ?> function) {
        return ResponseEntity.ok(function.apply(service));
    }
}
