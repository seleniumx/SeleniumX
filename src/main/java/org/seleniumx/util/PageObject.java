package org.seleniumx.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class PageObject {
    public abstract void get();

    void element(String m, Class pageClass, Object object, String parameter) {
        Method[] methods = pageClass.getMethods();
        for (Method a : methods) {
            if (m.equals(a.getName())) {
                try {
                    a.invoke(object, parameter);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    void element(String m, Class pageClass, Object object) {
        Method[] methods = pageClass.getMethods();
        for (Method a : methods) {
            if (m.equals(a.getName())) {
                try {
                    a.invoke(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
