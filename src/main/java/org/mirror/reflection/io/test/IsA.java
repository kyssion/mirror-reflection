package org.mirror.reflection.io.test;

import org.mirror.reflection.io.Test;

/**
 * is child?
 */
public class IsA implements Test {
    private Class<?> parent;

    public IsA(Class<?> parentType) {
        this.parent = parentType;
    }

    @Override
    public boolean matches(Class<?> type) {
        return type != null && parent.isAssignableFrom(type);
    }

    @Override
    public String toString() {
        return "is assignable to " + parent.getSimpleName();
    }
}
