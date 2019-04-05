package org.prims.reflection.wrapper;


import org.prims.reflection.mirror.MirrorObject;

/**
 * @author Clinton Begin
 */
public interface ObjectWrapperFactory {

    boolean hasWrapperFor(Object object);

    ObjectWrapper getWrapperFor(MirrorObject mirrorObject, Object object);

}
