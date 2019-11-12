package org.seleniumx.util;

import org.openqa.selenium.Platform;
import org.seleniumx.annotations.DriverSettings;
import org.seleniumx.annotations.Script;
import org.seleniumx.annotations.ServerSettings;

public class SeleniumxWebPageTest extends TestCase {

    @ServerSettings(
            PLATFORM = Platform.LINUX,
            BROWSER = Set.BROWSER.CHROME,
            VERSION = "1",
            SERVER_PORT = "5555",
            SERVER_URL = "http://localhost",
            BASE_URL = "https://www.seleniumx.com/",
            IMPLICIT_WAIT = 100)
//    @DriverSettings(
//            OS = Set.OS.MAC,
//            WINDOW_SIZE = Set.WINDOW_SIZE.DEFAULT,
//            BROWSER = Set.BROWSER.CHROME,
//            BASE_URL = "https://www.seleniumx.com/",
//            IMPLICIT_WAIT = 100
//    )
    @Script(script = SeleniumxWebPageTestScript.class)
    public void testCase() {
        run();

    }
}
