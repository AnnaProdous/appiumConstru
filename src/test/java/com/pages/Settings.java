package com.pages;

import com.base.BaseTest;
import com.google.common.collect.ImmutableMap;
import com.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Settings extends BaseTest {
    private final WebDriver driver;
    private LoginPage loginPage;
    private ProjectsPage projectsPage;
    private ProjectsDetailsPage projectsDetailsPage;

    @AndroidFindBy(id = "com.construdata.android:id/textAppSettings")
    private WebElement txtSettings;

    @AndroidFindBy(id = "com.construdata.android:id/buttonLogout")
    private WebElement logoutBtn;

    @AndroidFindBy(id = "com.construdata.android:id/spinnerLocale")
    private WebElement lngBtn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")
    private WebElement lngBtnHeb;
    @AndroidFindBy(id = "com.construdata.android:id/textAppSettings")
    private WebElement titleName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]")
    private WebElement lngBtnKr;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]")
    private WebElement lngBtnJ;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]")
    private WebElement lngBtnRu;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
    private WebElement getLngBtnEn;

    @AndroidFindBy(id = "com.construdata.android:id/debugMenu")
    private WebElement debugBtn;
    @AndroidFindBy(xpath = "//*[contains(@text, 'Upload Queue')]")
    private WebElement uploadQBtn;
    @AndroidFindBy(id = "com.construdata.android:id/emptyQueueText")
    private WebElement msgUplScreen;

    @AndroidFindBy(id = "com.construdata.android:id/textVersionName") private WebElement verNum;
    @AndroidFindBy(id = "com.construdata.android:id/textVersion") private WebElement verNumFld;
    @AndroidFindBy(id ="com.construdata.android:id/textSignInAs") private WebElement userNameFld;
    @AndroidFindBy(id = "com.construdata.android:id/textLoggedInAs") private WebElement userName;

    @AndroidFindBy(id = "com.construdata.android:id/textConnectionStatus") private WebElement cameraStatus;
    @AndroidFindBy(id = "com.construdata.android:id/textAppSettings") private WebElement appSet;
    @AndroidFindBy(id = "com.construdata.android:id/textChooseLocale") private WebElement selectLang;
    @AndroidFindBy(id = "com.construdata.android:id/switchPostView") private WebElement confImg;
    @AndroidFindBy(id = "com.construdata.android:id/switchMobileUpload") private WebElement useMobData;
    @AndroidFindBy(id = "com.construdata.android:id/textRefresh") private WebElement invProjD;
    @AndroidFindBy(id = "com.construdata.android:id/textUpload") private WebElement uplData;
    @AndroidFindBy(id = "com.construdata.android:id/tvUploadSchedule") private WebElement uplSchedule;
    @AndroidFindBy(id = "com.construdata.android:id/textCameraSettings") private WebElement camSet;
    @AndroidFindBy(id = "com.construdata.android:id/textPictures") private WebElement picRem;
    @AndroidFindBy(id = "com.construdata.android:id/tvThetaWizardTitle") private WebElement thetaWiz;

    public Settings(WebDriver driver) {
        this.driver = driver;
    }

    public String txtSettings() {
        try {
            return txtSettings.getText();
        } catch (Exception e) {
            System.out.println("An error occurred while getting element text: " + e.getMessage());
            return "Element not found or error occurred.";
        }
    }

    public void scrollToLogoutButton() {
        WebElement element = driver.findElement(AppiumBy.id("com.construdata.android:id/container"));
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 600, "width", 700, "height", 800,
                "direction", "down",
                "percent", 1.0
        ));
        System.out.println("The scroll gesture is made, logout button is visible.");
    }

    public Settings pressLogoutBtn() {
        click(logoutBtn);
        System.out.println("User successfully logged out.");
        return this;
    }

    public Settings pressLngBtn() {
        click(lngBtn);
        System.out.println("Language button is clicked.");
        return this;
    }

    public Settings pressLngBtnHeb() {
        click(lngBtnHeb);
        System.out.println("Hebrew language is chosen.");
        return this;
    }

    public Settings pressLngBtnKor() {
        click(lngBtnKr);
        System.out.println("Korean language is chosen.");
        return this;
    }

    public Settings pressLngBtnJ() {
        click(lngBtnJ);
        System.out.println("Japan language is chosen.");
        return this;
    }

    public Settings pressLngBtnRu() {
        click(lngBtnRu);
        System.out.println("Russian language is chosen.");
        return this;
    }

    public Settings pressLngBtnEn() {
        click(getLngBtnEn);
        System.out.println("English language is chosen.");
        return this;
    }

    public String getTitleName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(titleName));
        if (titleName != null && titleName.isDisplayed()) {
            return titleName.getText();
        } else {
            return "Element not found or not displayed.";
        }
    }

    public Settings pressDebugBtn() {
        click(debugBtn);
        System.out.println("Debug button is clicked.");
        return this;
    }

    public Settings uploadBtn() {
        click(uploadQBtn);
        System.out.println("Upload queue button is clicked.");
        return this;
    }

    public String getUploadEmptyTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(msgUplScreen));
        if (msgUplScreen != null && msgUplScreen.isDisplayed()) {
            return msgUplScreen.getText();
        } else {
            return "Element not found or not displayed.";
        }
    }

    public String getUserNameFld() {
        return userNameFld.getText();
    }
        public String getUserName() {
            return userName.getText();
        }
    public String getVerFld() {
        return verNumFld.getText();
    }
    public String getVer() {
        return verNum.getText();
    }
    public String getStatusCamera() {
        return cameraStatus.getText();
    }
    public String getDebugBtn() {
        return debugBtn.getText();
    }
    public String getCameraStatus() {
        return cameraStatus.getText();
    }
    public String getAppSetName() {
        return appSet.getText();
    }
    public String getSelectLang() {
        return selectLang.getText();
    }
    public String getMobDataFld() {
        return useMobData.getText();
    }
    public String getInvProj() {
        return invProjD.getText();
    }
    public String getUplData() {
        return uplData.getText();
    }
    public String getUplSch() {
        return uplSchedule.getText();
    }
    public String getCamSet() {
        return camSet.getText();
    }
    public String getPicRem() {
        return picRem.getText();
    }
    public String getThetaWiz() {
        return thetaWiz.getText();
    }
    public String getConfImg() {
        return confImg.getText();
    }
}
