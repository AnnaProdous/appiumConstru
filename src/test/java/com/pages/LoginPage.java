package com.pages;

import com.base.BaseTest;
import com.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseTest {
    private final WebDriver driver;
    private ProjectsPage projectsPage;

    @AndroidFindBy(id = "com.construdata.android:id/inputUsername")
    private WebElement usernameTxFld;
    @AndroidFindBy(id = "com.construdata.android:id/inputPassword")
    private WebElement passwordFld;
    @AndroidFindBy(className = "android.widget.Button")
    private WebElement loginBtn;
    @AndroidFindBy(id = "android:id/message")
    private WebElement errTxt;
    @AndroidFindBy(className = "android.widget.Button")
    private WebElement errBtn;
    @AndroidFindBy(id = "com.construdata.android:id/textLoginTitle") private WebElement appName;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage enterUserName(String username) {
        sendKeys(usernameTxFld, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(passwordFld, password);
        return this;
    }

    public LoginPage pressErrBtn() {
        click(errBtn);
        return this;
    }

    public ProjectsPage pressLoginBtn() {
        System.out.println("Waiting for login button to be clickable");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));

        System.out.println("Clicking on login button.");
        click(loginBtn);

        System.out.println("Login button clicked successfully.");
        return new ProjectsPage(driver);
    }

    public String getErrTxt() {
        try {
            System.out.println("Waiting for error text");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
            wait.until(ExpectedConditions.visibilityOf(errTxt));

            System.out.println("Error message is displayed");
            return getAttribute(errTxt, "text");
        } catch (Exception e) {
            System.out.println("Error while getting error text: " + e.getMessage());
            throw e;
        }
    }

    public ProjectsPage login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        return pressLoginBtn();
    }

    public String getAppName() {
        return appName.getText();
    }
    public String getUserFld() {
        return usernameTxFld.getText();
    }
    public String getPassFld() {
        return passwordFld.getText();
    }
    public String getLoginBtn() {
        return loginBtn.getText();
    }
}