package org.mirror.reflection.io;


import org.mirror.reflection.io.test.AnnotatedWith;
import org.mirror.reflection.io.test.IsA;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassFindleUtil<T> {

    private Set<Class<? extends T>> matches = new HashSet<>();

    private ClassLoader classloader;

    public Set<Class<? extends T>> getClasses() {
        return matches;
    }

    public ClassLoader getClassLoader() {
        return classloader == null ? Thread.currentThread().getContextClassLoader() : classloader;
    }

    public void setClassLoader(ClassLoader classloader) {
        this.classloader = classloader;
    }

    /**
     * 通过接口搜索
     *
     * @param parent
     * @param packageNames
     * @return
     */
    public ClassFindleUtil<T> findImplementations(Class<?> parent, String... packageNames) {
        if (packageNames == null) {
            return this;
        }
        Test test = new IsA(parent);
        for (String pkg : packageNames) {
            find(test, pkg);
        }
        return this;
    }

    /**
     * 通过注解搜索
     *
     * @param annotation
     * @param packageNames
     * @return
     */
    public ClassFindleUtil<T> findAnnotated(Class<? extends Annotation> annotation, String... packageNames) {
        if (packageNames == null) {
            return this;
        }

        Test test = new AnnotatedWith(annotation);
        for (String pkg : packageNames) {
            find(test, pkg);
        }

        return this;
    }

    /**
     * 通过类搜索
     *
     * @param test
     * @param packageName
     * @return
     */
    public ClassFindleUtil<T> find(Test test, String...packageName) {
        for (String pathItem : packageName) {
            String path = getPackagePath(pathItem);
            try {
                List<String> children = VFS.getInstance().list(path);
                for (String child : children) {
                    if (child.endsWith(".class")) {
                        addIfMatching(test, child);
                    }
                }
            } catch (IOException ioe) {
            }
        }
        return this;
    }

    protected String getPackagePath(String packageName) {
        return packageName == null ? null : packageName.replace('.', '/');
    }

    /**
     * 由提供给已解析类集的完全限定类名指定的类，当且仅当它被所提供的测试批准时。
     */
    @SuppressWarnings("unchecked")
    protected void addIfMatching(Test test, String fqn) {
        try {
            String externalName = fqn.substring(0, fqn.indexOf('.')).replace('/', '.');
            ClassLoader loader = getClassLoader();

            Class<?> type = loader.loadClass(externalName);
            if (test.matches(type)) {
                matches.add((Class<T>) type);
            }
        } catch (Throwable t) {
            return;
        }
    }
}
