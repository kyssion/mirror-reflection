package org.mirror.reflection.wrapper;

import org.mirror.reflection.mirror.MirrorObject;
import org.mirror.reflection.exception.ReflectionException;

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