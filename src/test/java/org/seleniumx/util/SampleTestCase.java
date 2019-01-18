package org.seleniumx.util;

import org.seleniumx.annotations.DriverSettings;
import org.seleniumx.annotations.Script;

public class SampleTestCase extends TestCase {
    @DriverSettings(
            BASE_URL = "https://www.seleniumx.com",
            WINDOW_SIZE = Set.WINDOW_SIZE.DEFAULT,
            OS = Set.OS.LINUX,
            BROWSER = Set.BROWSER.CHROME)
    @Script(script = SampleScript.class)
    public void testCase() {
        data.put("Result", "Documentation");
        testCase(data);
    }
}
