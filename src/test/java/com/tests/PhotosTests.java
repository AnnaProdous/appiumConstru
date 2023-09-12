package com.tests;

import com.base.BaseTest;
import com.pages.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class PhotosTests extends BaseTest {
    private LoginPage loginPage;
    private ProjectsDetailsPage projectsDetailsPage;
    private ProjectsPage projectsPage;
    private Settings settings;
    private TakePictures takePictures;


    @BeforeClass
    public void beforeClass() {
    }

    @AfterClass
    public void afterClass() {
    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        projectsDetailsPage = new ProjectsDetailsPage(driver);
        settings = new Settings(driver);
        takePictures = new TakePictures(driver);
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
    //Validate connect to the camera
    public void cameraConnected() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.pressProjectBtn();
        projectsDetailsPage.pressBuildBtn();
        projectsDetailsPage.pressFloorBtn("F01");
        takePictures.mainScreenSwipe();
        takePictures.pressWiFiBtn();
        takePictures.choseCameraBtn();
        takePictures.pressCloseBtn();
    }
}