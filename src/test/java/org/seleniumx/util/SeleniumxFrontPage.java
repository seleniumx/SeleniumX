package org.seleniumx.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumxFrontPage extends PageObject {
    private int timeout = 15;

    @FindBy(css = "a[href='https://travis-ci.org/seleniumx/SeleniumX']")
    @CacheLookup
    private WebElement buildStatus;

    @FindBy(css = "a[href='https://circleci.com/gh/seleniumx/SeleniumX/tree/master']")
    @CacheLookup
    private WebElement circleCi;

    @FindBy(css = "#menu-item-401 a")
    @CacheLookup
    private WebElement contactUs1;

    @FindBy(css = "#primary-menu li:nth-of-type(4) a")
    @CacheLookup
    private WebElement contactUs2;

    @FindBy(css = "#menu-item-399 a")
    @CacheLookup
    private WebElement documentation1;

    @FindBy(css = "#primary-menu li:nth-of-type(2) a")
    @CacheLookup
    private WebElement documentation2;

    @FindBy(css = "#menu-item-397 a")
    @CacheLookup
    private WebElement home1;

    @FindBy(css = "#primary-menu li:nth-of-type(1) a")
    @CacheLookup
    private WebElement home2;

    @FindBy(css = "a[href='https://github.com/aravindaw/address-formatter-demo/tree/master/ui-test-with-seleniumx']")
    @CacheLookup
    private WebElement httpsgithubComaravindawaddressformatterdemotreemasteruitestwithseleniumx;

    @FindBy(css = "a[href='https://maven.apache.org']")
    @CacheLookup
    private WebElement httpsmavenApacheOrg;

    @FindBy(css = "a[href='https://maven.apache.org/ide.html']")
    @CacheLookup
    private WebElement httpsmavenApacheOrgideHtml;

    @FindBy(css = "a[href='https://maven.apache.org/index.html']")
    @CacheLookup
    private WebElement httpsmavenApacheOrgindexHtml;

    @FindBy(css = "a[href='https://maven.apache.org/install.html']")
    @CacheLookup
    private WebElement httpsmavenApacheOrginstallHtml;

    @FindBy(css = "a[href='https://maven-badges.herokuapp.com/maven-central/org.seleniumx/seleniumx']")
    @CacheLookup
    private WebElement mavenCentral;

    private final String pageLoadedText = "You don’t have to worry about what kind of Operating System or what browser you are using because each and every feature is built into SeleniumX";

    private final String pageUrl = "/";

    @FindBy(css = "a[href='https://wordpress.org/']")
    @CacheLookup
    private WebElement proudlyPoweredByWordpress;

    @FindBy(css = "#masthead div.row div.site-branding.col-md-6 p:nth-of-type(1) a")
    @CacheLookup
    private WebElement seleniumx;

    @FindBy(css = "a[href='https://www.seleniumx.com/versions?vr=two']")
    @CacheLookup
    private WebElement seleniumx100;

    @FindBy(css = "a[href='https://www.seleniumx.com/versions?vr=three']")
    @CacheLookup
    private WebElement seleniumx101;

    @FindBy(css = "a[href='https://www.seleniumx.com/versions?vr=four']")
    @CacheLookup
    private WebElement seleniumx102;

    @FindBy(css = "a[href='https://www.seleniumx.com/versions?vr=five']")
    @CacheLookup
    private WebElement seleniumx110;

    @FindBy(css = "a[href='https://www.seleniumx.com/versions?vr=six']")
    @CacheLookup
    private WebElement seleniumx120;

    @FindBy(css = "a[href='https://www.seleniumx.com/versions?vr=seven']")
    @CacheLookup
    private WebElement seleniumx130;

    @FindBy(css = "a[href='https://www.seleniumx.com/versions?vr=one']")
    @CacheLookup
    private WebElement snapshot10;

    @FindBy(css = "#menu-item-590 a")
    @CacheLookup
    private WebElement versions1;

    @FindBy(css = "#primary-menu li:nth-of-type(3) a")
    @CacheLookup
    private WebElement versions2;

    /**
     * Get Page title
     *
     * @return Seleniumx page title
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Click on Build Status Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickBuildStatusLink() {
        buildStatus.click();
        return this;
    }

    /**
     * Click on Circle Ci Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickCircleCiLink() {
        circleCi.click();
        return this;
    }

    /**
     * Click on Contact Us Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickContactUs1Link() {
        contactUs1.click();
        return this;
    }

    /**
     * Click on Contact Us Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickContactUs2Link() {
        contactUs2.click();
        return this;
    }

    /**
     * Click on Documentation Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickDocumentation1Link() {
        documentation1.click();
        return this;
    }

    /**
     * Click on Documentation Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickDocumentation2Link() {
        documentation2.click();
        return this;
    }

    /**
     * Click on Home Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickHome1Link() {
        home1.click();
        return this;
    }

    /**
     * Click on Home Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickHome2Link() {
        home2.click();
        return this;
    }

    /**
     * Click on Httpsgithub.comaravindawaddressformatterdemotreemasteruitestwithseleniumx Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickHttpsgithubComaravindawaddressformatterdemotreemasteruitestwithseleniumxLink() {
        httpsgithubComaravindawaddressformatterdemotreemasteruitestwithseleniumx.click();
        return this;
    }

    /**
     * Click on Httpsmaven.apache.org Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickHttpsmavenApacheOrgLink() {
        httpsmavenApacheOrg.click();
        return this;
    }

    /**
     * Click on Httpsmaven.apache.orgide.html Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickHttpsmavenApacheOrgideHtmlLink() {
        httpsmavenApacheOrgideHtml.click();
        return this;
    }

    /**
     * Click on Httpsmaven.apache.orgindex.html Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickHttpsmavenApacheOrgindexHtmlLink() {
        httpsmavenApacheOrgindexHtml.click();
        return this;
    }

    /**
     * Click on Httpsmaven.apache.orginstall.html Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickHttpsmavenApacheOrginstallHtmlLink() {
        httpsmavenApacheOrginstallHtml.click();
        return this;
    }

    /**
     * Click on Maven Central Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickMavenCentralLink() {
        mavenCentral.click();
        return this;
    }

    /**
     * Click on Proudly Powered By Wordpress Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickProudlyPoweredByWordpressLink() {
        proudlyPoweredByWordpress.click();
        return this;
    }

    /**
     * Click on Seleniumx 1.0.0 Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickSeleniumx100Link() {
        seleniumx100.click();
        return this;
    }

    /**
     * Click on Seleniumx 1.0.1 Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickSeleniumx101Link() {
        seleniumx101.click();
        return this;
    }

    /**
     * Click on Seleniumx 1.0.2 Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickSeleniumx102Link() {
        seleniumx102.click();
        return this;
    }

    /**
     * Click on Seleniumx 1.1.0 Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickSeleniumx110Link() {
        seleniumx110.click();
        return this;
    }

    /**
     * Click on Seleniumx 1.2.0 Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickSeleniumx120Link() {
        seleniumx120.click();
        return this;
    }

    /**
     * Click on Seleniumx 1.3.0 Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickSeleniumx130Link() {
        seleniumx130.click();
        return this;
    }

    /**
     * Click on Seleniumx Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickSeleniumxLink() {
        seleniumx.click();
        return this;
    }

    /**
     * Click on 1.0snapshot Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickSnapshotLink10() {
        snapshot10.click();
        return this;
    }

    /**
     * Click on Versions Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickVersions1Link() {
        versions1.click();
        return this;
    }

    /**
     * Click on Versions Link.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage clickVersions2Link() {
        versions2.click();
        return this;
    }


    /**
     * Verify that the page loaded completely.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the SeleniumxFrontPage class instance.
     */
    public SeleniumxFrontPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
