package org.seleniumx.util;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.seleniumx.annotations.DriverSettings;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class Start extends Driver {
    private Set.OS os;
    private Set.BROWSER browser;
    private Set.WINDOW_SIZE window_size;
    private String BASE_URL;
    private int implicit_wait;
    private String driverName;

    @BeforeTest
    protected void set() throws Exception {
        Method[] methods = this.getClass().asSubclass(this.getClass()).getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(DriverSettings.class)) {
                DriverSettings driver = m.getAnnotation(DriverSettings.class);
                os = driver.OS();
                browser = driver.BROWSER();
                BASE_URL = driver.BASE_URL();
                window_size = driver.WINDOW_SIZE();
                implicit_wait = driver.IMPLICIT_WAIT();
                log.info("[{}]", "OS=" + os + ",BROWSER=" + browser + ",WINDOW_SIZE=" + window_size + ",IMPLICIT_WAIT=" + implicit_wait + ",BASE_URL=" + BASE_URL);
            }
        }
        CompositeConfiguration config = new CompositeConfiguration();
        config.addConfiguration(new PropertiesConfiguration("config.properties"));

        if (browser.equals(Set.BROWSER.CHROME)) {
            if (os.equals(Set.OS.LINUX)) {
                driverName = String.valueOf(config.getProperty("CHR_DRIVER_LINUX"));
            } else if (os.equals(Set.OS.WINDOWS)) {
                driverName = String.valueOf(config.getProperty("CHR_DRIVER_WINDOWS"));
            } else if (os.equals(Set.OS.MAC)) {
                driverName = String.valueOf(config.getProperty("CHR_DRIVER_MAC"));
            }
        } else if (browser.equals(Set.BROWSER.FIREFOX)) {
            if (os.equals(Set.OS.MAC)) {
                driverName = String.valueOf(config.getProperty("FF_DRIVER_MAC"));
            } else if (os.equals(Set.OS.WINDOWS)) {
                driverName = String.valueOf(config.getProperty("FF_DRIVER_WIN"));
            } else if (os.equals(Set.OS.LINUX)) {
                driverName = String.valueOf(config.getProperty("FF_DRIVER_LINUX"));
            }
        } else if (browser.equals(Set.BROWSER.IE)) {
            driverName = String.valueOf(config.getProperty("IE_DRIVER"));
        }

        URL url = getClass().getClassLoader().getResource(driverName);
        File file = new File("Driver");
        if (!file.exists()) {
            file.mkdirs();
        }
        File webDriver = new File("Driver" + File.separator + driverName);
        if (!webDriver.exists()) {
            webDriver.createNewFile();
            assert url != null;
            org.apache.commons.io.FileUtils.copyURLToFile(url, webDriver);
        }

        webDriver.setExecutable(true, true);
        if (browser.equals(Set.BROWSER.CHROME)) {
            System.setProperty("webdriver.chrome.driver", webDriver.getAbsolutePath());
            driver = new ChromeDriver();
        } else if (browser.equals(Set.BROWSER.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", webDriver.getAbsolutePath());
            driver = new FirefoxDriver();
        } else if (browser.equals(Set.BROWSER.IE)) {
            System.setProperty("webdriver.ie.driver", webDriver.getAbsolutePath());
            driver = new InternetExplorerDriver();
        }

        if (window_size.equals(Set.WINDOW_SIZE.FULLSCREEN)) {
            driver.manage().window().fullscreen();
        } else if (window_size.equals(Set.WINDOW_SIZE.MAXIMIZE)) {
            driver.manage().window().maximize();
        } else if (window_size.equals(Set.WINDOW_SIZE.DEFAULT)) {
            driver.manage().window();
        }
        driver.manage().timeouts().implicitlyWait(implicit_wait, TimeUnit.MILLISECONDS);
        driver.get(BASE_URL);

    }

    @AfterTest
    protected void exit() {
        driver.quit();
    }

    @AfterMethod
    public void onTestFailure(ITestResult testResult) throws Exception {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Snapshot.takeSnapShot(testResult.getMethod().getMethodName());
        }
    }

}
