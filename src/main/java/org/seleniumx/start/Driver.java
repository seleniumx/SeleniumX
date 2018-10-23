package org.seleniumx.start;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumx.annotations.DriverSettings;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver;
    private final static Logger logger = Logger.getLogger(Driver.class);
    private DriverSet.OS os;
    private DriverSet.WINDOW_SIZE window_size;
    private String BASE_URL;
    private int implicit_wait;

    @BeforeTest
    protected void set() throws ConfigurationException {
        Method[] methods = this.getClass().asSubclass(this.getClass()).getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(DriverSettings.class)) {
                DriverSettings driverSettings = m.getAnnotation(DriverSettings.class);
                os = driverSettings.OS();
                BASE_URL = driverSettings.BASE_URL();
                window_size = driverSettings.WINDOW_SIZE();
                implicit_wait = driverSettings.IMPLICIT_WAIT();
                logger.info("[OS=" + os + ",BASE_URL=" + BASE_URL + ",WINDOW_SIZE=" + window_size + ",IMPLICIT_WAIT=" + implicit_wait);
            }
        }
        CompositeConfiguration config = new CompositeConfiguration();
        config.addConfiguration(new PropertiesConfiguration("src/main/resources/config.properties"));

        if (os.equals(DriverSet.OS.LINUX)) {
            System.setProperty("webdriver.chrome.start", config.getProperty("DRIVER_LINUX").toString());
        } else if (os.equals(DriverSet.OS.WINDOWS)) {
            System.setProperty("webdriver.chrome.start", config.getProperty("DRIVER_WINDOWS").toString());
        } else if (os.equals(DriverSet.OS.MAC)) {
            System.setProperty("webdriver.chrome.start", config.getProperty("DRIVER_MAC").toString());
        }
        driver = new ChromeDriver();
        if (window_size.equals(DriverSet.WINDOW_SIZE.FULLSCREEN)) {
            driver.manage().window().fullscreen();
        } else if (window_size.equals(DriverSet.WINDOW_SIZE.MAXIMIZE)) {
            driver.manage().window().maximize();
        } else if (window_size.equals(DriverSet.WINDOW_SIZE.DEFAULT)) {
            driver.manage().window();
        }
        driver.manage().timeouts().implicitlyWait(implicit_wait, TimeUnit.MILLISECONDS);
        driver.get(BASE_URL);

    }

    @AfterTest
    protected void exit() {
        driver.quit();
    }

}
