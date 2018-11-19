package org.seleniumx;

import org.seleniumx.annotations.DriverSettings;
import org.seleniumx.util.Set;
import org.seleniumx.util.TestCase;
import org.testng.Assert;

public class MainClassTest extends TestCase {
    String key = "sampleKey";
    String value = "sampleValue";

    @DriverSettings(OS = Set.OS.LINUX)
    @Override
    public void testCase() {

        data.put(key, value);
        testCase(data);
    }

    public void getData() {
        Assert.assertEquals(data.get("sampleKey"), data.get(key));
    }
}
