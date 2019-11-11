package org.seleniumx.util;

import org.seleniumx.annotations.Data;
import org.seleniumx.annotations.DriverSettings;
import org.seleniumx.annotations.PreTest;
import org.seleniumx.annotations.ServerSettings;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class Start extends Driver {
    protected Set.OS os;
    protected Set.BROWSER browser;
    protected Set.WINDOW_SIZE window_size;
    protected String BASE_URL;
    protected int implicit_wait;
    protected String VERSION;
    private String filePath;
    private Class[] preTestClassName;
    private TestCase testCase;

    @BeforeTest
    protected void set() throws Exception {
        Method[] methods = this.getClass().asSubclass(this.getClass()).getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(ServerSettings.class) && m.isAnnotationPresent(DriverSettings.class)) {
                log.info("You can not use @DriverSettings @ServerSettings at the same test case");
                System.exit(0);
            }
            if (m.isAnnotationPresent(ServerSettings.class)) {
                new SetupServer().setup(m);
            } else if (m.isAnnotationPresent(DriverSettings.class)) {
                new SetupLocal().setup(m);

            }
            if (m.isAnnotationPresent(Data.class)) {
                Data scriptClass = m.getAnnotation(Data.class);
                filePath = scriptClass.path();
            }
            if (m.isAnnotationPresent(PreTest.class)) {
                PreTest preTestClass = m.getAnnotation(PreTest.class);
                preTestClassName = preTestClass.testCase();
            }
        }

        if (filePath != null) {
            DataReader.reads().setFilePath(filePath);
        }
        if (preTestClassName != null) {
            for (Class x : preTestClassName) {

                try {
                    Class<?> precondition = Class.forName(x.getName());
                    Constructor<?> constructor = precondition.getConstructor();
                    Object object = constructor.newInstance();
                    testCase = (TestCase) object;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                testCase.testCase();
            }
        }
    }

    @AfterTest
    protected void exit() {
        try {
            data.clear();
        } catch (Exception ignored) {
        }
        driver.quit();
    }

    @AfterMethod
    public void onTestFailure(ITestResult testResult) throws Exception {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Snapshot.takeSnapShot(testResult.getMethod().getMethodName());
        }
    }

}
