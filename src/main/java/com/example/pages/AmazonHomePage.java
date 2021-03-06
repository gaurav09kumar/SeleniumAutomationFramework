package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends BasePage {
    @FindBy(id = "nav-hamburger-menu")
    private WebElement linkHamburger;

    public AmazonHomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public AmazonHamburgerMenuPage clickHamburger() {
        linkHamburger.click();
        return new AmazonHamburgerMenuPage();
    }
}
