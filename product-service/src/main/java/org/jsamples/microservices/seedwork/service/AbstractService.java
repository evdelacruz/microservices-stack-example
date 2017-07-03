package org.jsamples.microservices.seedwork.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractService implements Service {
    private final Logger logger = LoggerFactory.getLogger(getClass());
}
