package org.seleniumx.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SamplePage extends PageObject {

    @FindBy(xpath = "//*[@id=\"menu-item-399\"]/a")
    private WebElement tab;

    @FindBy(xpath = "//*[@id=\"post-398\"]/div/div/div/div/div[1]/div/div[1]/div/div/p")
    private WebElement result;

    public void clickTab() {
        tab.click();
    }

    public String result() {
        return result.getText();
    }
}
