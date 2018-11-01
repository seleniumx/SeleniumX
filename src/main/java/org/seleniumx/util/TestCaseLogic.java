package org.seleniumx.util;

public abstract class TestCaseLogic {
    public abstract void script();

    void logic(Class script) {
        System.out.println(script.getName());
    }
}
