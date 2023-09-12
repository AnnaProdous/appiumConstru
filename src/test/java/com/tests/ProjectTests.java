package com.tests;

import com.base.BaseTest;
import com.pages.LoginPage;
import com.pages.ProjectsDetailsPage;
import com.pages.ProjectsPage;
import com.pages.Settings;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class ProjectTests extends BaseTest {
    private LoginPage loginPage;
    private ProjectsDetailsPage projectsDetailsPage;
    private ProjectsPage projectsPage;
    private Settings settings;


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
    //Validate that user sees the project on the project list and can open it and switch to the next screen, the title of project is the same on both pages
    public void validateOpenProject() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        String actualTitle = projectsPage.getTitle();
        String expectedTitle = getStrings().get("nameOfProject");
        System.out.println("Actual title - " + actualTitle + "\n" + "Expected title - " + expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    //Validate that after open the project, the logo Constru is displayed, detailed apartment info is displayed
    public void validateOpenFloors() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        projectsDetailsPage = projectsPage.pressProjectBtn();
        String titleLogoResult = projectsDetailsPage.titleLogo(true);
        System.out.println("Title logo result: " + titleLogoResult);
        projectsDetailsPage.pressBuildBtn();
        projectsDetailsPage.pressFloorBtn("F01");
        String actualTitle = projectsDetailsPage.getApartTitle();
        String expectedTitle = getStrings().get("descApart");
        System.out.println("Actual title - " + actualTitle + "\n" + "Expected title - " + expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    //Validate that user can open whole floor plan on the screen, toolbar is displayed
    public void validateOpenFloorPlan() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.pressProjectBtn();
        projectsDetailsPage.pressBuildBtn();
        projectsDetailsPage.pressBtnShowPlan();
        String toolBar = projectsDetailsPage.toolBar(true);
        System.out.println("Tool bar result: " + toolBar);
    }

    @Test
    //Validate that user can open an apartment floorplan from the list and floor will be opened with toolbar at the top
    public void validateChooseFloor() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        String actualTitle1 = projectsPage.getTitle();
        String expectedTitle1 = getStrings().get("nameOfProject");
        System.out.println("Actual title - " + actualTitle1 + "\n" + "Expected title - " + expectedTitle1);
        Assert.assertEquals(actualTitle1, expectedTitle1);

        projectsPage.pressProjectBtn();
        projectsDetailsPage.pressBuildBtn();
        projectsDetailsPage.pressFloorBtn("Floor F01");
        String actualTitle2 = projectsDetailsPage.getProjectTitle();
        String expectedTitle2 = getStrings().get("descApart");
        System.out.println("Actual title - " + actualTitle2 + "\n" + "Expected title - " + expectedTitle2);
        Assert.assertEquals(actualTitle2, expectedTitle2);
    }

    @Test
     /* Validate that user can open the list of point, press to the point from the list,
     on the chosen apartment, click back and move back to the opened building and apartments screen.*/
    public void validateListPoints() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        projectsPage.pressProjectBtn();
        projectsDetailsPage.pressBuildBtn();
        projectsDetailsPage.pressFloorBtn("Floor F01");
        projectsDetailsPage.compassToggle(true);
        projectsDetailsPage.pressApartPoints();
        projectsDetailsPage.pressPointNum();
        projectsDetailsPage.permissControl();
        String actualTitle = projectsDetailsPage.getPointTitle();
        String expectedTitle = getStrings().get("pointName");
        System.out.println("Actual title - " + actualTitle + "\n" + "Expected title - " + expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        projectsDetailsPage.closeBtnMsg();
        projectsDetailsPage.btnBack();
    }

    @Test
    public void validateBackBtn() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        projectsPage.pressProjectBtn();
        projectsDetailsPage.pressBuildBtn();
        projectsDetailsPage.pressFloorBtn("Floor F01");
        projectsDetailsPage.btnBack();
    }

    @Test
     /*Validate that user can press to the flag - send report and can open the list of
     available statuses on the screen*/
    public void validateFlagStatuses() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        projectsPage.pressProjectBtn();
        projectsDetailsPage.flagSendReport();
        projectsDetailsPage.btnSendReport(true);
        projectsDetailsPage.reportBack();
        projectsDetailsPage.pressBuildBtn();
        projectsDetailsPage.pressFloorBtn("Floor F01");
        projectsDetailsPage.pressBtnLegend();

        String actualTitle1 = projectsDetailsPage.getNameStatusR();
        String expectedTitle1 = getStrings().get("nameStatusR");
        System.out.println("Actual title - " + actualTitle1 + "\n" + "Expected title - " + expectedTitle1);
        Assert.assertEquals(actualTitle1, expectedTitle1);

        String actualTitle2 = projectsDetailsPage.getNameStatusE();
        String expectedTitle2 = getStrings().get("nameStatusE");
        System.out.println("Actual title - " + actualTitle2 + "\n" + "Expected title - " + expectedTitle2);
        Assert.assertEquals(actualTitle2, expectedTitle2);

        String actualTitle3 = projectsDetailsPage.getNameStatusU();
        String expectedTitle3 = getStrings().get("nameStatusU");
        System.out.println("Actual title - " + actualTitle3 + "\n" + "Expected title - " + expectedTitle3);
        Assert.assertEquals(actualTitle3, expectedTitle3);
        String actualTitle4 = projectsDetailsPage.getNameStatusD();
        String expectedTitle4 = getStrings().get("nameStatusD");
        System.out.println("Actual title - " + actualTitle4 + "\n" + "Expected title - " + expectedTitle4);
        Assert.assertEquals(actualTitle4, expectedTitle4);
    }

    @Test
    /* Validate that user can open the project, then open the project list, then open
     settings page, the logo is displayed on all screens (except after login)*/
    public void validateSwitchBtwPages() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        projectsPage.pressProjectBtn();
        projectsDetailsPage.btnProjects();
        projectsDetailsPage.titleLogo(true);
        projectsDetailsPage.btnStn();
        projectsDetailsPage.titleLogo(true);
        String actualTitle = settings.txtSettings();
        String expectedTitle = getStrings().get("settings");
        System.out.println("Actual title - " + actualTitle + "\n" + "Expected title - " + expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void validateVisibilityOfLegendMenu() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        projectsPage.pressProjectBtn();
        projectsDetailsPage.legendMenu(true);

        String actualTitle1 = projectsDetailsPage.txtSelect();
        String expectedTitle1 = getStrings().get("mainMsgLeg");
        System.out.println("Actual title - " + actualTitle1 + "\n" + "Expected title - " + expectedTitle1);
        Assert.assertEquals(actualTitle1, expectedTitle1);

        String actualTitle2 = projectsDetailsPage.txtLegend();
        String expectedTitle2 = getStrings().get("msgLeg");
        System.out.println("Actual title - " + actualTitle2 + "\n" + "Expected title - " + expectedTitle2);
        Assert.assertEquals(actualTitle2, expectedTitle2);

        projectsDetailsPage.colInPrg(true);
        String actualTitle3 = projectsDetailsPage.inPrgTxt();
        String expectedTitle3 = getStrings().get("msgLegY");
        System.out.println("Actual title - " + actualTitle3 + "\n" + "Expected title - " + expectedTitle3);
        Assert.assertEquals(actualTitle3, expectedTitle3);

        projectsDetailsPage.colDone(true);
        String actualTitle4 = projectsDetailsPage.txtDone();
        String expectedTitle4 = getStrings().get("msgLegG");
        System.out.println("Actual title - " + actualTitle4 + "\n" + "Expected title - " + expectedTitle4);
        Assert.assertEquals(actualTitle4, expectedTitle4);

        projectsDetailsPage.colCantTake(true);
        String actualTitle5 = projectsDetailsPage.txtCantTake();
        String expectedTitle5 = getStrings().get("msgLegR");
        System.out.println("Actual title - " + actualTitle5 + "\n" + "Expected title - " + expectedTitle5);
        Assert.assertEquals(actualTitle5, expectedTitle5);

        projectsDetailsPage.colInPrgSmn(true);
        String actualTitle6 = projectsDetailsPage.txtInPrgSmn();
        String expectedTitle6 = getStrings().get("msgLegSmn");
        System.out.println("Actual title - " + actualTitle6 + "\n" + "Expected title - " + expectedTitle6);
        Assert.assertEquals(actualTitle6, expectedTitle6);

        projectsDetailsPage.colSelYou(true);
        String actualTitle7 = projectsDetailsPage.txtSelYou();
        String expectedTitle7 = getStrings().get("msgLegSelYou");
        System.out.println("Actual title - " + actualTitle7 + "\n" + "Expected title - " + expectedTitle7);
        Assert.assertEquals(actualTitle7, expectedTitle7);

        projectsDetailsPage.colErr(true);
        String actualTitle8 = projectsDetailsPage.txtErr();
        String expectedTitle8 = getStrings().get("msgLegErr");
        System.out.println("Actual title - " + actualTitle8 + "\n" + "Expected title - " + expectedTitle8);
        Assert.assertEquals(actualTitle8, expectedTitle8);
    }
    }
