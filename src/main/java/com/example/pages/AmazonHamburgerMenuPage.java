package com.example.pages;

import com.example.enums.WaitStrategy;
import com.example.utils.DynamicXPathUtils;
import org.openqa.selenium.By;

public class AmazonHamburgerMenuPage extends BasePage {

    private String linkComputers = "//div[text()='Mobiles, Computers']/parent::a";
    private String linkSubMenu = "//a[text()='%s']";

    public AmazonHamburgerMenuPage clickComputers() {
        click(By.xpath(linkComputers), WaitStrategy.CLICKABLE, "Mobiles and Computers");
        return this;
    }

    public AmazonLaptopPage clickOnSubMenuItem(String menutext) {
        String newxpath = DynamicXPathUtils.getXpath(linkSubMenu, menutext);
        click(By.xpath(newxpath), WaitStrategy.CLICKABLE, menutext);
        if(menutext.contains("Laptops")) {
            return new AmazonLaptopPage();
        }
        return null;
    }
}
