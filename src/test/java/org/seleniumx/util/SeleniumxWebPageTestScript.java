package org.seleniumx.util;

import org.seleniumx.annotations.Page;
import org.testng.Assert;

public class SeleniumxWebPageTestScript extends Script {
    @Page(page = {SeleniumxFrontPage.class})
    public void script() {
        execute("SeleniumxFrontPage","verifyPageLoaded");
        execute("SeleniumxFrontPage","verifyPageUrl");
        log.info(get("SeleniumxFrontPage","getTitle"));
        Assert.assertEquals("SeleniumX | Test Automation Framework",get("SeleniumxFrontPage","getTitle"));

    }
}
