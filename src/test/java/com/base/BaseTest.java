package com.base;

import com.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.util.Strings;

import java.io.InputStream;
import java.time.Duration;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;


public class BaseTest {
    protected static AppiumDriver driver;
    protected static Properties props;
    protected static HashMap<String, String> strings;
    InputStream inputStream;
    TestUtils utils = new TestUtils();

    private static AppiumDriverLocalService appiumService;

    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

 /*   @BeforeSuite
    public void startAppiumServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingPort(4723);
        appiumService = AppiumDriverLocalService.buildService(builder);
        appiumService.start();
    }*/

    @AfterSuite
    public void stopAppiumServer() {
        if (appiumService != null) {
            appiumService.stop();
        }
    }

    @Parameters({"platformName", "platformVersion", "deviceName"})
    @BeforeMethod
    public void beforeTest(String platformName, String platformVersion, String deviceName) throws Exception {
        try {
            props = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getResourceAsStream("/" + propFileName);
            if (inputStream == null) {
                throw new RuntimeException("Resource not found: " + propFileName);
            }
            props.load(inputStream);

            inputStream = getClass().getClassLoader().getResourceAsStream("strings/strings.xml");
            if (inputStream == null) {
                throw new RuntimeException("Resource not found: strings/strings.xml");
            }
            strings = TestUtils.parseStringXML(inputStream);

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", platformName);
            desiredCapabilities.setCapability("platformVersion", platformVersion);
            desiredCapabilities.setCapability("deviceName", deviceName);
            desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
            desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
            desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
            URL appURL = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
            desiredCapabilities.setCapability("app", appURL);

            //real device
            /*desiredCapabilities.setCapability("udid", "eb9db481");
            desiredCapabilities.setCapability("noReset", "true");
            desiredCapabilities.setCapability("ignoreHiddenApiPolicyError", "true");*/

            URL url = new URL(props.getProperty("appiumURL"));
            driver = new AndroidDriver(url, desiredCapabilities);
            String sessionId = driver.getSessionId().toString();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public String getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getText(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public HashMap<String, String> getStrings() {
        return strings;
    }



    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

}
