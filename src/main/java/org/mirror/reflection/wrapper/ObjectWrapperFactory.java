package org.mirror.reflection.wrapper;


import org.mirror.reflection.mirror.MirrorObject;

/**
 * @author Clinton Begin
 */
public interface ObjectWrapperFactory {

    boolean hasWrapperFor(Object object);

    ObjectWrapper getWrapperFor(MirrorObject mirrorObject, Object object);

}
