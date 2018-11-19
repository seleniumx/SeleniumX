package org.seleniumx;

import org.seleniumx.annotations.DriverSettings;
import org.seleniumx.util.TestCase;
import org.testng.Assert;

public class MainClassTest extends TestCase {
    private String key = "sampleKey";
    private String value = "sampleValue";


    @DriverSettings
    @Override
    public void testCase() {

        data.put(key, value);
        testCase(data);
    }

    public void getData() {
        Assert.assertEquals(data.get("sampleKey"), data.get(key));
    }
}
