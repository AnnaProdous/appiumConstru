package com.pages;

import com.base.BaseTest;

import com.utils.TestUtils;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TakePictures extends BaseTest {
    private WebDriver driver = null;
    private LoginPage loginPage;
    private ProjectsPage projectsPage;
    private ProjectsDetailsPage projectsDetailsPage;
    private Settings settings;

    public TakePictures(WebDriver driver) {
        this.driver = driver;
    }

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Expand\"])[1]")
    private WebElement btnWiFi;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.TextView")
    private WebElement camera;

    @AndroidFindBy(accessibility = "Navigate up") private WebElement btnClose;

        public void mainScreenSwipe() {
            TouchAction ts = new TouchAction((PerformsTouchActions) driver);

            int startX = 661;
            int startY = 21;
            int endX = 657;
            int endY = 1585;

            ts.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
            System.out.println("The home screen is opened.");
        }

    public TakePictures pressWiFiBtn() {
        click(btnWiFi);
        System.out.println("WiFi menu is opened.");
        return this;
    }

    public TakePictures choseCameraBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(camera));
        click(camera);
        System.out.println("Camera is chosen.");
        return this;
    }

    public TakePictures pressCloseBtn() {
        click(btnClose);
        System.out.println("Menu is closed.");
        return this;
    }



}
