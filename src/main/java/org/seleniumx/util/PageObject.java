package org.seleniumx.util;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.lang.reflect.Method;

public abstract class PageObject extends Start {
    private String val;

    void element(String m, Class pageClass, Object object, String parameter) {
        Method[] methods = pageClass.getMethods();
        for (Method a : methods) {
            if (m.equals(a.getName())) {
                try {
                    PageFactory.initElements(driver, this);
                    a.invoke(object, parameter);
                } catch (Exception e) {
                    e.printStackTrace();
                    Assert.fail(String.valueOf(e));
                }
            }
        }
    }

    void element(String m, Class pageClass, Object object) {
        Method[] methods = pageClass.getMethods();
        for (Method a : methods) {
            if (m.equals(a.getName())) {
                try {
                    PageFactory.initElements(driver, this);
                    a.invoke(object);
                } catch (Exception e) {
                    e.printStackTrace();
                    Assert.fail(String.valueOf(e));
                }
            }
        }
    }

    String getVal(String m, Class pageClass, Object object) {
        Method[] methods = pageClass.getMethods();
        for (Method a : methods) {

            if (m.equals(a.getName())) {
                try {
                    PageFactory.initElements(driver, this);
                    val = (String) a.invoke(object);
                } catch (Exception e) {
                    e.printStackTrace();
                    Assert.fail(String.valueOf(e));
                }
            }
        }
        return val;
    }
}
