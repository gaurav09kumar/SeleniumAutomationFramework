package com.example.pages;

import com.example.driver.DriverManager;
import com.example.enums.WaitStrategy;
import com.example.utils.DecodeUtils;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {
    /**
     * Order of choosing your locators
     * id
     * name
     * classname
     * linktext
     * partiallinktext
     * css or xpath
     */

    private final By textboxUsername = By.id("txtUsername");
    private final By testboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
    private final By buttonLogin = By.id("btnLogin");

    public OrangeHRMLoginPage enterUserName(String userName) {
        sendKeys(textboxUsername, userName, WaitStrategy.PRESENCE, "Username");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        sendKeys(testboxPassword, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE, "Password");
        return this;
    }

    public OrangeHRMHomePage clickLoginButton() {
        click(buttonLogin, WaitStrategy.PRESENCE, "Login Button");
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }
}
