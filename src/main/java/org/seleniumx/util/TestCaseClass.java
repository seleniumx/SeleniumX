package org.seleniumx.util;

import org.seleniumx.annotations.Script;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class TestCaseClass extends Start {
    public final HashMap<String, String> value = new HashMap<String, String>();
    public Map<String, String> keyValue;
    private Class className;

    public abstract void testCase();

    public void testCase(Map<String, String> values) {
        this.keyValue = values;
        Method[] methods = getClass().getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Script.class)) {
                Script scriptClass = m.getAnnotation(Script.class);
                className = scriptClass.script();
            }
        }
        TestCaseLogic logic = new TestCaseLogic() {
            @Override
            public void script() {
            }
        };
        logic.logic(className);
    }
}
