package com.example.tests;

import static org.assertj.core.api.Assertions.*;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

//Mentioning class as final so that other classes cannot extend it
public final class HomePageTests extends BaseTest {

    //Restrict from Creating Objects
    private HomePageTests() {

    }

    /*
    Validate whether the title is containing google search or Google Search
    Validate whether the title is not null and the length of the title is greater than 15 and less than 100
    Check for the links in the page -->
    number of the links is exactly 10 or 15
     */

    @Test
    public void test3() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("ABCD -  Youtube", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();

        //AssertJ

        assertThat(title)
                .as("Object is actually null").isNotNull()
                .as("It does not contains expected text").containsIgnoringCase("google search")
                .matches("\\w.*" + "Google Search")
                .hasSizeBetween(15, 100);


        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h2"));

        assertThat(elements)
                .hasSize(10)
                .extracting(WebElement::getText)
                .contains("ABCD- Youtube");
    }
}
