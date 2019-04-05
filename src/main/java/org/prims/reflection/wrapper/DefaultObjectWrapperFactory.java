package org.prims.reflection.wrapper;

import org.prims.reflection.exception.ReflectionException;
import org.prims.reflection.meta.MirrorObject;

public class DefaultObjectWrapperFactory implements ObjectWrapperFactory {

    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MirrorObject mirrorObject, Object object) {
        throw new ReflectionException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}