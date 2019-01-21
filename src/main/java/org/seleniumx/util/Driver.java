package org.seleniumx.util;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    public Logger log = LoggerFactory.getLogger(getClass());
    public static WebDriver driver;
    public static Map<String, String> data;
    public static HashMap<String, String> preConData;


}
