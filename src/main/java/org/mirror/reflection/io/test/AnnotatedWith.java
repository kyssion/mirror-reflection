package org.mirror.reflection.io.test;

import org.mirror.reflection.io.Test;

import java.lang.annotation.Annotation;

/**
 * is has annotated
 */
public class AnnotatedWith implements Test {
    private Class<? extends Annotation> annotation;

    public AnnotatedWith(Class<? extends Annotation> annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean matches(Class<?> type) {
        return type != null && type.isAnnotationPresent(annotation);
    }

    @Override
    public String toString() {
        return "annotated with @" + annotation.getSimpleName();
    }
}
