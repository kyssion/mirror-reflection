package com.kyssion.mirror.reflection.mirror;

import com.kyssion.mirror.reflection.object.ObjectFactory;
import com.kyssion.mirror.reflection.DefaultReflectorFactory;
import com.kyssion.mirror.reflection.object.DefaultObjectFactory;
import com.kyssion.mirror.reflection.wrapper.DefaultObjectWrapperFactory;
import com.kyssion.mirror.reflection.wrapper.ObjectWrapperFactory;

public final class SystemMirrorObject {

    public static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    public static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    public static final MirrorObject NULL_META_OBJECT = MirrorObject.forObject(NullObject.class, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());

    private SystemMirrorObject() {
        // Prevent Instantiation of Static Class
    }

    private static class NullObject {
    }

    public static MirrorObject forObject(Object object) {
        return MirrorObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
    }

}