package com.tests;

import com.base.BaseTest;
import com.pages.LoginPage;
import com.pages.ProjectsDetailsPage;
import com.pages.ProjectsPage;
import com.pages.Settings;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.nio.file.attribute.UserPrincipal;

public class SettingsTests extends BaseTest {
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
    public void validateLogout() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        projectsPage.pressProjectBtn();
        projectsDetailsPage.btnStn();
        settings.scrollToLogoutButton();
        settings.pressLogoutBtn();
    }

    @Test
    public void validateChangeLanguage() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        projectsPage.pressProjectBtn();
        projectsDetailsPage.btnStn();
        settings.pressLngBtn();
        settings.pressLngBtnHeb();
        String actualTitle1 = settings.getTitleName();
        String expectedTitle1 = getStrings().get("settingsNameH");
        System.out.println("Actual title - " + actualTitle1 + "\n" + "Expected title - " + expectedTitle1);
        Assert.assertEquals(actualTitle1, expectedTitle1);

        settings.pressLngBtn();
        settings.pressLngBtnKor();
        String actualTitle2 = settings.getTitleName();
        String expectedTitle2 = getStrings().get("settingsNameK");
        System.out.println("Actual title - " + actualTitle2 + "\n" + "Expected title - " + expectedTitle2);
        Assert.assertEquals(actualTitle2, expectedTitle2);

        settings.pressLngBtn();
        settings.pressLngBtnJ();
        String actualTitle3 = settings.getTitleName();
        String expectedTitle3 = getStrings().get("settingsNameJ");
        System.out.println("Actual title - " + actualTitle3 + "\n" + "Expected title - " + expectedTitle3);
        Assert.assertEquals(actualTitle3, expectedTitle3);

        settings.pressLngBtn();
        settings.pressLngBtnRu();
        String actualTitle4 = settings.getTitleName();
        String expectedTitle4 = getStrings().get("settingsNameRu");
        System.out.println("Actual title - " + actualTitle4 + "\n" + "Expected title - " + expectedTitle4);
        Assert.assertEquals(actualTitle4, expectedTitle4);

        settings.pressLngBtn();
        settings.pressLngBtnEn();
        String actualTitle5 = settings.getTitleName();
        String expectedTitle5 = getStrings().get("settingsNameEn");
        System.out.println("Actual title - " + actualTitle5 + "\n" + "Expected title - " + expectedTitle5);
        Assert.assertEquals(actualTitle5, expectedTitle5);
    }

    @Test
    // Validate to open upload queue
    public void validateOpenUploadQueue() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        projectsPage.pressProjectBtn();
        projectsDetailsPage.btnStn();
        settings.scrollToLogoutButton();
        settings.pressDebugBtn();
        settings.uploadBtn();
        String actualTitle = settings.getUploadEmptyTitle();
        String expectedTitle = getStrings().get("msgUploadScr");
        System.out.println("Actual title - " + actualTitle + "\n" + "Expected title - " + expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    // Validate username and version
    public void validateUserNameVer() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        projectsPage.pressProjectBtn();
        projectsDetailsPage.btnStn();

        String actualTitle1 = settings.getUserNameFld();
        String expectedTitle1 = getStrings().get("userFld");
        System.out.println("Actual title - " + actualTitle1 + "\n" + "Expected title - " + expectedTitle1);
        Assert.assertEquals(actualTitle1, expectedTitle1);

        String actualTitle2 = settings.getUserName();
        String expectedTitle2 = getStrings().get("userN");
        System.out.println("Actual title - " + actualTitle2 + "\n" + "Expected title - " + expectedTitle2);
        Assert.assertEquals(actualTitle2, expectedTitle2);

        String actualTitle3 = settings.getVerFld();
        String expectedTitle3 = getStrings().get("verFld");
        System.out.println("Actual title - " + actualTitle3 + "\n" + "Expected title - " + expectedTitle3);
        Assert.assertEquals(actualTitle3, expectedTitle3);

        String actualTitle4 = settings.getVer();
        String expectedTitle4 = getStrings().get("ver");
        System.out.println("Actual title - " + actualTitle4 + "\n" + "Expected title - " + expectedTitle4);
        Assert.assertEquals(actualTitle4, expectedTitle4);
    }

    @Test
    // Validate names of fields in the Settings tab
    public void validateNamesSettings() {
        projectsPage = loginPage.login("test_ios", "Constru_2020%");
        projectsPage.getListProject();
        projectsPage.pressProjectBtn();
        projectsDetailsPage.btnStn();

        String actualTitle1 = settings.getCameraStatus();
        String expectedTitle1 = getStrings().get("cameraStatus");
        System.out.println("Actual title - " + actualTitle1 + "\n" + "Expected title - " + expectedTitle1);
        Assert.assertEquals(actualTitle1, expectedTitle1);

        String actualTitle2 = settings.getAppSetName();
        String expectedTitle2 = getStrings().get("appSet");
        System.out.println("Actual title - " + actualTitle2 + "\n" + "Expected title - " + expectedTitle2);
        Assert.assertEquals(actualTitle2, expectedTitle2);

        String actualTitle3 = settings.getSelectLang();
        String expectedTitle3 = getStrings().get("selectLang");
        System.out.println("Actual title - " + actualTitle3 + "\n" + "Expected title - " + expectedTitle3);
        Assert.assertEquals(actualTitle3, expectedTitle3);

        String actualTitle4 = settings.getConfImg();
        String expectedTitle4 = getStrings().get("confImg");
        System.out.println("Actual title - " + actualTitle4 + "\n" + "Expected title - " + expectedTitle4);
        Assert.assertEquals(actualTitle4, expectedTitle4);

        String actualTitle5 = settings.getMobDataFld();
        String expectedTitle5 = getStrings().get("useMobData");
        System.out.println("Actual title - " + actualTitle5 + "\n" + "Expected title - " + expectedTitle5);
        Assert.assertEquals(actualTitle5, expectedTitle5);

        String actualTitle6 = settings.getInvProj();
        String expectedTitle6 = getStrings().get("invProjD");
        System.out.println("Actual title - " + actualTitle6 + "\n" + "Expected title - " + expectedTitle6);
        Assert.assertEquals(actualTitle6, expectedTitle6);

        String actualTitle7 = settings.getUplData();
        String expectedTitle7 = getStrings().get("uplData");
        System.out.println("Actual title - " + actualTitle7 + "\n" + "Expected title - " + expectedTitle7);
        Assert.assertEquals(actualTitle7, expectedTitle7);

        String actualTitle8 = settings.getUplSch();
        String expectedTitle8 = getStrings().get("uplSch");
        System.out.println("Actual title - " + actualTitle8 + "\n" + "Expected title - " + expectedTitle8);
        Assert.assertEquals(actualTitle8, expectedTitle8);

        String actualTitle9 = settings.getCamSet();
        String expectedTitle9 = getStrings().get("camSet");
        System.out.println("Actual title - " + actualTitle9 + "\n" + "Expected title - " + expectedTitle9);
        Assert.assertEquals(actualTitle9, expectedTitle9);

        settings.scrollToLogoutButton();
        String actualTitle10 = settings.getPicRem();
        String expectedTitle10 = getStrings().get("picRem");
        System.out.println("Actual title - " + actualTitle10 + "\n" + "Expected title - " + expectedTitle10);
        Assert.assertEquals(actualTitle10, expectedTitle10);

        String actualTitle11 = settings.getThetaWiz();
        String expectedTitle11 = getStrings().get("tetWiz");
        System.out.println("Actual title - " + actualTitle11 + "\n" + "Expected title - " + expectedTitle11);
        Assert.assertEquals(actualTitle11, expectedTitle11);

        String actualTitle12 = settings.getDebugBtn();
        String expectedTitle12 = getStrings().get("debugBtn");
        System.out.println("Actual title - " + actualTitle12 + "\n" + "Expected title - " + expectedTitle12);
        Assert.assertEquals(actualTitle12, expectedTitle12);
    }
}