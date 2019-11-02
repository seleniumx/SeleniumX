package org.seleniumx.util;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class TestCase extends Start {
    protected final HashMap<String, String> data = new HashMap<String, String>();
    protected final HashMap<String, String> preConData = new HashMap<String, String>();
    private Class scriptClassName;
    private Class preconditionClassName;
    private String[] preconditionClassData;
    private Script logicScript;

    @Test
    public abstract void testCase();

    public void run() {
        Map<String, String> values = new HashMap<String, String>();
        values.put("Key", "value");
        testCase(values);
    }

    public void run(Map<String, String> values) {
        testCase(values);

    }

    private void testCase(Map<String, String> values) {
        Driver.data = values;
        Method[] methods = getClass().getMethods();
        for (Method m : methods) {

            if (m.isAnnotationPresent(org.seleniumx.annotations.Precondition.class)) {
                org.seleniumx.annotations.Precondition preconditionClass = m.getAnnotation(org.seleniumx.annotations.Precondition.class);
                preconditionClassName = preconditionClass.precondition();
                preconditionClassData = preconditionClass.data();
            }
            if (m.isAnnotationPresent(org.seleniumx.annotations.Script.class)) {
                org.seleniumx.annotations.Script scriptClass = m.getAnnotation(org.seleniumx.annotations.Script.class);
                scriptClassName = scriptClass.script();
            }
        }

        if (preconditionClassName != null) {
            if (preconditionClassData != null) {
                int i = 1;
                for (String x : preconditionClassData) {
                    preConData.put("data" + i, x);
                    i++;
                }
                Driver.preConData = preConData;
            }
            runScript(preconditionClassName);
            logicScript.script();
        }

        if (scriptClassName != null) {
            runScript(scriptClassName);
            logicScript.script();
        }

    }

    private void runScript(Class preconditionClassName) {
        try {
            Class<?> precondition = Class.forName(preconditionClassName.getName());
            Constructor<?> constructor = precondition.getConstructor();
            Object object = constructor.newInstance();
            logicScript = (Script) object;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
