package com.pages;

import com.base.BaseTest;
import com.google.common.collect.ImmutableMap;
import com.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class ProjectsDetailsPage extends BaseTest {
    private final WebDriver driver;
    private LoginPage loginPage;
    private ProjectsPage projectsPage;

    @AndroidFindBy(id = "com.construdata.android:id/logo")
    private WebElement logoTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='0' and @text='Test Apple']")
    private WebElement projectName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.construdata.android:id/textTitle']")
    private WebElement btnBuild;

    @AndroidFindBy(id = "com.construdata.android:id/btnShowPlan")
    private WebElement btnShowPlan;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[3]")
    private WebElement partFloor;

    @AndroidFindBy(id = "com.construdata.android:id/toolbar")
    private WebElement toolBar;

    @AndroidFindBy(accessibility = "Apartment points")
    private WebElement apartPoints;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]")
    private WebElement floorName;

    @AndroidFindBy(xpath = "//android.widget.TextView[2]")
    private WebElement descApart;

    @AndroidFindBy(id = "com.construdata.android:id/swRotate")
    private WebElement compassToggle;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView[2]")
    private WebElement pointNum;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]")
    private WebElement permissionController;

    @AndroidFindBy(accessibility = "Close")
    private WebElement closeBtnMsg;

    @AndroidFindBy(id = "com.construdata.android:id/textApartmentPointTitle")
    private WebElement apartPointTitle;

    @AndroidFindBy(id = "com.construdata.android:id/fabSendReport")
    private WebElement flagSendReport;

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement btnSendReport;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private WebElement reportBack;

    @AndroidFindBy(id = "com.construdata.android:id/fabLegend")
    private WebElement btnLegend;
    @AndroidFindBy(xpath = "(//android.widget.FrameLayout)[1]//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    private WebElement legendMenu;
    @AndroidFindBy(id = "com.construdata.android:id/textSelect")
    private WebElement txtSelect;
    @AndroidFindBy(id = "com.construdata.android:id/textLegend")
    private WebElement txtLegend;
    @AndroidFindBy(id = "com.construdata.android:id/viewInProgressByYou")
    private WebElement colInPrg;
    @AndroidFindBy(id = "com.construdata.android:id/textInProgressByYou")
    private WebElement inPrgTxt;
    @AndroidFindBy(id = "com.construdata.android:id/viewInDone")
    private WebElement colDone;
    @AndroidFindBy(id = "com.construdata.android:id/textDone")
    private WebElement txtDone;
    @AndroidFindBy(id = "com.construdata.android:id/viewCantTake")
    private WebElement colCantTake;
    @AndroidFindBy(id = "com.construdata.android:id/textCantTake")
    private WebElement txtCantTake;
    @AndroidFindBy(id = "com.construdata.android:id/viewInProgressBySomeone")
    private WebElement colInPrgSmn;
    @AndroidFindBy(id = "com.construdata.android:id/textTakeBySomeoneElse")
    private WebElement txtInPrgSmn;
    @AndroidFindBy(id = "com.construdata.android:id/viewSelected")
    private WebElement colSelYou;
    @AndroidFindBy(id = "com.construdata.android:id/textSelected")
    private WebElement txtSelYou;
    @AndroidFindBy(id = "com.construdata.android:id/viewPlanDownloadError")
    private WebElement colErr;
    @AndroidFindBy(id = "com.construdata.android:id/textPlanDownloadError")
    private WebElement txtErr;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView")
    private WebElement nameStatusR;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.TextView[2]")
    private WebElement nameStatusE;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.TextView[2]")
    private WebElement nameStatusU;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[3]/android.widget.TextView[2]")
    private WebElement nameStatusD;

    @AndroidFindBy(accessibility = "Projects") private WebElement btnProjects;
    @AndroidFindBy(accessibility = "Settings") private WebElement btnSettings;

    @AndroidFindBy(id = "com.construdata.android:id/buttonQrScan")
    private WebElement scanEl;

    public ProjectsDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String titleLogo(boolean isDisplayed) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        WebElement titleLogo = wait.until(ExpectedConditions.visibilityOf(logoTitle));
        if (titleLogo != null && titleLogo.isDisplayed()) {
            System.out.println("The logo is displayed.");
            return "The logo is displayed.";
        } else {
            System.out.println("The logo is not displayed.");
            return "Element not found or not displayed.";
        }
    }

    public String compassToggle(boolean isDisplayed) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        WebElement titleLogo = wait.until(ExpectedConditions.visibilityOf(compassToggle));
        if (compassToggle != null && compassToggle.isDisplayed()) {
            return "The compass is displayed.";
        } else {
            System.out.println("The compass is not displayed.");
            return "Element not found or not displayed.";
        }
    }

    public String getProjectTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOf(descApart));

        if (titleElement != null && titleElement.isDisplayed()) {
            return titleElement.getText();
        } else {
            return "Element not found or not displayed.";
        }
    }

    public ProjectsDetailsPage pressBuildBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(btnBuild));
        waitForVisibility(btnBuild);
        btnBuild.click();
        System.out.println("You are inside the building.");
        return this;
    }

    public ProjectsDetailsPage pressPointNum() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(pointNum));
        waitForVisibility(pointNum);
        pointNum.click();
        System.out.println("The chosen point is clicked from the list of points.");
        return this;
    }

    public String getPointTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(apartPointTitle));
        if (apartPointTitle != null && apartPointTitle.isDisplayed()) {
            return apartPointTitle.getText();
        } else {
            return "Element not found or not displayed.";
        }
    }

    public ProjectsDetailsPage permissControl() {
        click(permissionController);
        System.out.println("The option from permission controller is chosen.");
        return this;
    }

    public ProjectsDetailsPage reportBack() {
        click(reportBack);
        System.out.println("Back button is clicked on the report location screen.");
        return this;
    }

    public ProjectsDetailsPage btnBack() {
        WebElement element = driver.findElement(AppiumBy.id("com.construdata.android:id/toolbar")); //on opened floor plan
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "x", 94,
                "y", 164
        ));
        System.out.println("Back button is clicked.");
        return this;
    }

    public ProjectsDetailsPage flagSendReport() {
        click(flagSendReport);
        System.out.println("The flag is pressed, and new window is opened.");
        return this;
    }

    public ProjectsDetailsPage closeBtnMsg() {
        click(closeBtnMsg);
        System.out.println("The message is closed.");
        return this;
    }

    public String btnSendReport(boolean isDisplayed) {
        btnSendReport.isDisplayed();
        return "The button is displayed.";
    }

    public ProjectsDetailsPage pressBtnShowPlan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(btnShowPlan));
        waitForVisibility(btnShowPlan);
        btnShowPlan.click();
        System.out.println("The whole floor plan is displayed.");
        return this;
    }

    public ProjectsDetailsPage pressFloorBtn(String floorName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(partFloor));
        waitForVisibility(partFloor);
        partFloor.click();
        System.out.println("The floor is displayed.");
        return this;
    }

    public String toolBar(boolean isDisplayed) {
        if (toolBar != null && toolBar.isDisplayed()) {
            System.out.println("Tool bar is displayed.");
            return "Tool bar is displayed";
        } else {
            System.out.println("Toll bar is not displayed.");
            return "Element not found or not displayed.";
        }
    }

    public String getApartTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOf(descApart));

        if (titleElement != null && titleElement.isDisplayed()) {
            return titleElement.getText();
        } else {
            return "Element not found or not displayed.";
        }
    }


    public ProjectsDetailsPage pressApartPoints() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(apartPoints));
        waitForVisibility(apartPoints);
        apartPoints.click();
        System.out.println("List of points are displayed.");
        return this;
    }

    public ProjectsDetailsPage pressBtnLegend() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(btnLegend));
        waitForVisibility(btnLegend);
        btnLegend.click();
        System.out.println("Button legend is clicked, legend menu is opened.");
        return this;
    }

    public String getFloorName() {
        if (floorName != null && floorName.isDisplayed()) {
            return floorName.getText();
        } else {
            return "Element not found or not displayed.";
        }
    }

    public String getNameStatusR() {
        try {
            return nameStatusR.getText();
        } catch (Exception e) {
            System.out.println("An error occurred while getting element text: " + e.getMessage());
            return "Element not found or error occurred.";
        }
    }

    public String getNameStatusE() {
        try {
            return nameStatusE.getText();
        } catch (Exception e) {
            System.out.println("An error occurred while getting element text: " + e.getMessage());
            return "Element not found or error occurred.";
        }
    }

    public String getNameStatusU() {
        try {
            return nameStatusU.getText();
        } catch (Exception e) {
            System.out.println("An error occurred while getting element text: " + e.getMessage());
            return "Element not found or error occurred.";
        }
    }

    public String getNameStatusD() {
        try {
            return nameStatusD.getText();
        } catch (Exception e) {
            System.out.println("An error occurred while getting element text: " + e.getMessage());
            return "Element not found or error occurred.";
        }
    }

    public ProjectsDetailsPage btnProjects() {
        click(btnProjects);
        System.out.println("The list of projects is opened.");
        return this;
    }

    public ProjectsDetailsPage btnStn() {
        click(btnSettings);
        System.out.println("Settings screen is opened.");
        return this;
    }

    public String legendMenu(boolean isDisplayed) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        WebElement titleLogo = wait.until(ExpectedConditions.visibilityOf(legendMenu));
        legendMenu.isDisplayed();
        System.out.println("The legend menu is displayed.");
        return "The legend menu is displayed.";
    }
    public String txtLegend() {
        return txtLegend.getText();
    }

    public String txtSelect() {
        return txtSelect.getText();
    }
    public String colInPrg(boolean isDisplayed) {
        colInPrg.isDisplayed();
        return "Beige colour - in progress by you is displayed.";
    }
    public String inPrgTxt() {
        return inPrgTxt.getText();
    }
    public String colDone(boolean isDisplayed) {
        colDone.isDisplayed();
        return ("Green colour - done, is displayed.");
    }
    public String txtDone() {
        return  txtDone.getText();
    }
    public String colCantTake(boolean isDisplayed) {
        colCantTake.isDisplayed();
        return ("Red colour - can't take, is displayed");
    }
    public String txtCantTake() {
        return txtCantTake.getText();
    }
    public String colInPrgSmn(boolean isDisplayed) {
        colInPrgSmn.isDisplayed();
        return ("Beige&white colour - taken by smn, is displayed.");
    }
    public String txtInPrgSmn() {
        return txtInPrgSmn.getText();
    }
    public String colSelYou(boolean isDisplayed) {
        colSelYou.isDisplayed();
        return "White colour - selected by you, is displayed.";
    }
    public String txtSelYou() {
        return txtSelYou.getText();
    }
    public String colErr(boolean isDisplayed) {
        colErr.isDisplayed();
        return "Yellow triangle - error down plan, is displayed.";
    }
    public String txtErr() {
        return txtErr.getText();
    }

}




