package org.prims.reflection.wrapper;


import org.prims.reflection.meta.MirrorObject;

/**
 * @author Clinton Begin
 */
public interface ObjectWrapperFactory {

    boolean hasWrapperFor(Object object);

    ObjectWrapper getWrapperFor(MirrorObject mirrorObject, Object object);

}
