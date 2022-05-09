package com.example.tests;

import com.example.listeners.RetryFailedTests;
import com.example.pages.OrangeHRMLoginPage;
import com.example.reports.ExtentReport;
import com.example.utils.DataProviderUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHRMTests extends BaseTest {
    private OrangeHRMTests() {
    }

    @Test
    public void loginLogoutTest(Map<String, String> data) {
        //Method Chaining
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
                .clickWelcome().clickLogout().getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @Test
    public void newTest(Map<String, String> data) {
        //Method Chaining
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
                .clickWelcome().clickLogout().getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @DataProvider(name = "LoginTestDataProvider", parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"Admin", "admin123"}
                //, {"Admin", "admin1234"}
        };
    }
}
