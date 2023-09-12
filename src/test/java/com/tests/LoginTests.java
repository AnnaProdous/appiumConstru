package com.tests;

import com.pages.LoginPage;
import com.base.BaseTest;

import com.pages.ProjectsDetailsPage;
import com.pages.ProjectsPage;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;


import org.json.JSONTokener;
import org.json.JSONObject;


public class LoginTests extends BaseTest {
    LoginPage loginPage;
    ProjectsDetailsPage projectsDetailsPage;
    ProjectsPage projectsPage;
    JSONObject loginUsers;

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datajs = null;
        try {
            String dataFileName = "data/loginUsers.json"; // Specify the path to the JSON file
            datajs = getClass().getClassLoader().getResourceAsStream(dataFileName); //Open an InputStream to read the JSON file
            JSONTokener tokener = new JSONTokener(datajs); // Create a JSONTokener to parse the JSON data
            loginUsers = new JSONObject(tokener); // Parse the JSON data and create a JSONObject named "loginUsers"
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // If there's an exception while reading the JSON file, print the stack trace and rethrow the exception
        } finally {
            if (datajs != null) {
                datajs.close(); // Close the InputStream to release resources
            }
        }
    }

    @AfterClass
    public void afterClass() {
    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        loginPage = new LoginPage(driver);
        System.out.println("\n" + "***** starting test: " + m.getName() + "*****" + "\n");
    }
    
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Test passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test failed: " + result.getName());
        }
    }


    @Test
    public void invalidUserName() {
        loginPage.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"));
        loginPage.pressLoginBtn();

        String actualErrTxt = loginPage.getErrTxt();
        String expectedErrTxt = getStrings().get("errorMsg");
        System.out.println("Actual error text: " + actualErrTxt + "\n" + "Expected error text: " + expectedErrTxt);
        Assert.assertEquals(actualErrTxt,expectedErrTxt);

        loginPage.pressErrBtn();
    }

    @Test
    public void invalidPassword() {
        loginPage.enterUserName(loginUsers.getJSONObject("invalidPassword").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidPassword").getString("password"));
        loginPage.pressLoginBtn();

        String actualErrTxt = loginPage.getErrTxt();
        String expectedErrTxt = getStrings().get("errorMsg");
        System.out.println("Actual error text: " + actualErrTxt + "\n" + "Expected error text: " + expectedErrTxt);
        Assert.assertEquals(actualErrTxt,expectedErrTxt);

        loginPage.pressErrBtn();
    }

    @Test
    public void successfulLogin() {
        loginPage.enterUserName(loginUsers.getJSONObject("successfulLogin").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("successfulLogin").getString("password"));
        projectsPage = loginPage.pressLoginBtn();

        String actualTitle = projectsPage.getTitle();
        System.out.println("Actual title: " + actualTitle);
        String expectedTitle = getStrings().get("nameOfProject");
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void validateFirstAppPage() {
        String actualTitle1 = loginPage.getAppName();
        String expectedTitle1 = getStrings().get("appName");
        System.out.println("Actual title - " + actualTitle1 + "\n" + "Expected title - " + expectedTitle1);
        Assert.assertEquals(actualTitle1, expectedTitle1);

        String actualTitle2 = loginPage.getUserFld();
        String expectedTitle2 = getStrings().get("UserFld");
        System.out.println("Actual title - " + actualTitle2 + "\n" + "Expected title - " + expectedTitle2);
        Assert.assertEquals(actualTitle2, expectedTitle2);

        String actualTitle3 = loginPage.getPassFld();
        String expectedTitle3 = getStrings().get("PassFld");
        System.out.println("Actual title - " + actualTitle3 + "\n" + "Expected title - " + expectedTitle3);
        Assert.assertEquals(actualTitle3, expectedTitle3);

        String actualTitle4 = loginPage.getLoginBtn();
        String expectedTitle4 = getStrings().get("LoginBtn");
        System.out.println("Actual title - " + actualTitle4 + "\n" + "Expected title - " + expectedTitle4);
        Assert.assertEquals(actualTitle4, expectedTitle4);
    }
}
