package org.seleniumx.util;

import org.seleniumx.annotations.Page;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public abstract class Script extends Driver {

    private String page;
    private String parameter;
    private PageObject pageObject;
    private String val;
    private boolean getVal;

    public abstract void script();

    private Class[] pageName;

    public void execute(String page, String element) {
        this.page = page;
        elementFinder(element);
    }

    public String get(String page, String element) {
        this.page = page;
        getVal = true;
        return elementFinder(element);
    }

    public String get(String page, String element, String parameter) {
        this.page = page;
        this.parameter = parameter;
        getVal = true;
        return elementFinder(element);
    }

    public void execute(String page, String element, String parameter) {
        this.page = page;
        this.parameter = parameter;
        elementFinder(element);
    }

    private String elementFinder(String element) {
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
                        pageObject = (PageObject) object;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (parameter == null) {
                        if (getVal) {
                            val = pageObject.getVal(element, className, pageObject);
                        } else {
                            pageObject.element(element, className, pageObject);
                        }
                    } else {
                        if (getVal) {
                            val = pageObject.getVal(element, className, pageObject, parameter);
                        } else {
                            pageObject.element(element, className, pageObject, parameter);
                        }
                    }
                }
            }
        }
        getVal = false;
        parameter = null;
        return val;
    }

}
