package org.prims.reflection.wrapper;


import org.prims.reflection.meta.MetaObject;

/**
 * @author Clinton Begin
 */
public interface ObjectWrapperFactory {

    boolean hasWrapperFor(Object object);

    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);

}
