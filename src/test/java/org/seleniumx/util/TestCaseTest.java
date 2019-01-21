package org.seleniumx.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTest {
    public String key = "sampleKey";
    public String value = "sampleValue";

    @Test
    public void testCaseTest() {
        new DummyData().testCase();
        Assert.assertEquals(Driver.data.get(key),value);
    }
}

class DummyData extends TestCase {

    @Override
    public void testCase() {
        data.put("sampleKey", "sampleValue");
        testCase(data);
    }
}
