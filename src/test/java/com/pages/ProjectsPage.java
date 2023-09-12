package com.pages;

import com.base.BaseTest;
import com.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProjectsPage extends BaseTest {
    private final WebDriver driver;
    private LoginPage loginPage;
    private ProjectsDetailsPage projectsDetailsPage;

    @AndroidFindBy(id = "com.construdata.android:id/listProjects")
    private WebElement listProject;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    private WebElement projectTitle;

    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProjectsDetailsPage pressProjectBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(projectTitle));
        projectTitle.click();
        System.out.println("You are inside the project.");
        return new ProjectsDetailsPage(driver);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOf(projectTitle));

        if (titleElement != null && titleElement.isDisplayed()) {
            return titleElement.getText();
        } else {
            return "Element not found or not displayed.";
        }
    }

    public ProjectsPage getListProject() {
        System.out.println("Project list is displayed.");
        return this;
    }
}
