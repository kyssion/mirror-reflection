package org.mirror.reflection.mirror;

import org.mirror.reflection.object.ObjectFactory;
import org.mirror.reflection.DefaultReflectorFactory;
import org.mirror.reflection.object.DefaultObjectFactory;
import org.mirror.reflection.wrapper.DefaultObjectWrapperFactory;
import org.mirror.reflection.wrapper.ObjectWrapperFactory;

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