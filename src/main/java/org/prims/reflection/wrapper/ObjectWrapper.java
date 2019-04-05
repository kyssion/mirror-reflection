package org.prims.reflection.wrapper;

import org.prims.reflection.meta.MirrorObject;
import org.prims.reflection.object.ObjectFactory;
import org.prims.reflection.property.PropertyTokenizer;

import java.util.List;

/**
 * @author Clinton Begin
 */
public interface ObjectWrapper {

    Class<?> getType();

    Object get(PropertyTokenizer prop);

    void set(PropertyTokenizer prop, Object value);

    String findProperty(String name, boolean useCamelCaseMapping);

    String[] getGetterNames();

    String[] getSetterNames();

    Class<?> getSetterType(String name);

    Class<?> getGetterType(String name);

    boolean hasSetter(String name);

    boolean hasGetter(String name);

    MirrorObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory);

    boolean isCollection();

    void add(Object element);

    <E> void addAll(List<E> element);

    Object invoke(String name, Object[] params);
}
