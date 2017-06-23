package org.jsamples.microservices.seedwork.map;

import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public final class MapperFactory {
    private static Mapper MAPPER = new Mapper();

    @SuppressWarnings("unchecked")
    public static Mapper getMapper(Class<?> clazz) {
        MAPPER.configure(mapper -> {
            try {
                Object instance = clazz.newInstance();
                Arrays.stream(clazz.getDeclaredClasses()).forEach(innerClass -> {
                    try {
                        Object innerInstance = instantiate(instance, innerClass);
                        if (innerInstance instanceof PropertyMap) {
                            mapper.addMappings((PropertyMap) innerInstance);
                        } else if (innerInstance instanceof Converter) {
                            mapper.addConverter((Converter) innerInstance);
                        }
                    } catch(Exception ex) {
                        throw new IllegalArgumentException("Conveci\u00f3n de mapeo de classes violada", ex);
                    }
                });
            }  catch(Exception ex) {
                throw new IllegalArgumentException("Conveci\u00f3n de mapeo de classes violada", ex);
            }
        });
        return MAPPER;
    }

    private static Object instantiate(Object topLevelInstance, Class<?> innerClass) throws Exception {
        Constructor<?> ctor = innerClass.getDeclaredConstructor(topLevelInstance.getClass());
        return ctor.newInstance(topLevelInstance);
    }

    private MapperFactory() {
        throw new AssertionError("No \"....MapperFactory\" instances for you!");
    }
}
