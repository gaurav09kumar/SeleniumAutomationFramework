package com.example.tests;

import com.example.annotations.FrameworkAnnotation;
import com.example.enums.CategoryType;
import com.example.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class AmazonDemoTest extends BaseTest {
    private AmazonDemoTest() {
    }

    @FrameworkAnnotation(author = {"Mathew", "John"}, category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION})
    @Test
    public void amazonTest(Map<String, String> data) {
        String title = new AmazonHomePage().clickHamburger()
                .clickComputers()
                .clickOnSubMenuItem(data.get("menutext")).getTitle();
        Assertions.assertThat(title).isNotNull();
    }

}
