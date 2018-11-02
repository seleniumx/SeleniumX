package org.seleniumx.util;

import org.seleniumx.annotations.Script;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class TestCase extends Start {
    private Class className;

    public abstract void testCase();

    public void testCase(Map<String, String> values) {
        this.getValue = values;
        Method[] methods = getClass().getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Script.class)) {
                Script scriptClass = m.getAnnotation(Script.class);
                className = scriptClass.script();
            }
        }
        try {
            Class<?> scriptClass = Class.forName(className.getName());
            Constructor<?> constructor = scriptClass.getConstructor();
            Object object = constructor.newInstance();
            Logic logicScript = (Logic) object;
            logicScript.script();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
