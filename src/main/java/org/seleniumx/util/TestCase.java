package org.seleniumx.util;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class TestCase extends Start {
    protected final HashMap<String, String> data = new HashMap<String, String>();
    private Class scriptClassName;
    private Class preconditionClassName;
    private TestCase testCase;
    private Script logicScript;

    @Test
    public abstract void testCase();

    public void testCase(Map<String, String> values) {
        Driver.data = values;
        Method[] methods = getClass().getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(org.seleniumx.annotations.Precondition.class)) {
                org.seleniumx.annotations.Precondition preconditionClass = m.getAnnotation(org.seleniumx.annotations.Precondition.class);
                preconditionClassName = preconditionClass.precondition();
            }
            if (m.isAnnotationPresent(org.seleniumx.annotations.Script.class)) {
                org.seleniumx.annotations.Script scriptClass = m.getAnnotation(org.seleniumx.annotations.Script.class);
                scriptClassName = scriptClass.script();
            }
        }

        if (preconditionClassName != null) {
            try {
                Class<?> precondition = Class.forName(preconditionClassName.getName());
                Constructor<?> constructor = precondition.getConstructor();
                Object object = constructor.newInstance();
                testCase = (TestCase) object;
            } catch (Exception e) {
                e.printStackTrace();
            }
            testCase.testCase();
        }
        if (scriptClassName != null) {
            try {
                Class<?> scriptClass = Class.forName(scriptClassName.getName());
                Constructor<?> constructor = scriptClass.getConstructor();
                Object object = constructor.newInstance();
                logicScript = (Script) object;
            } catch (Exception e) {
                e.printStackTrace();
            }
            logicScript.script();
        }

    }
}
