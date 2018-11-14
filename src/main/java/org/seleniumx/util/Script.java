package org.seleniumx.util;

import org.seleniumx.annotations.Page;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public abstract class Script {

    private String page;
    private String parameter;

    public abstract void script();

    private Class[] pageName;

    public void execute(String page, String element) {
        this.page = page;
        elementFinder(element);

    }

    public void execute(String page, String element, String parameter) {
        this.page = page;
        this.parameter = parameter;
        elementFinder(element);
    }

    private void elementFinder(String element) {
        Method[] methods = getClass().getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Page.class)) {
                Page page = m.getAnnotation(Page.class);
                pageName = page.page();
            }
        }
        if (pageName != null) {
            for (Class className : pageName) {
                String[] p = className.getName().split("\\.");
                if (p[p.length - 1].equals(page)) {
                    try {
                        Class<?> pageClass = Class.forName(className.getName());
                        Constructor<?> constructor = pageClass.getConstructor();
                        Object object = constructor.newInstance();
                        PageObject page = (PageObject) object;
                        if (parameter == null) {
                            page.element(element, className, page);
                        } else {
                            page.element(element, className, page, parameter);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
