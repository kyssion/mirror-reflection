package com.kyssion.mirror.reflection.wrapper;


import com.kyssion.mirror.reflection.mirror.MirrorObject;

/**
 * @author Clinton Begin
 */
public interface ObjectWrapperFactory {

    boolean hasWrapperFor(Object object);

    ObjectWrapper getWrapperFor(MirrorObject mirrorObject, Object object);

}
