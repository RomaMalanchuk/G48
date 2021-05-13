package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseAuthorizedPage extends BasePage {

    public BaseAuthorizedPage(WebDriver driver, String title) {
        super(driver, title);
    }

    private final By userProfileButton = By.xpath("//summary[@aria-label='View profile and more']");
    private final By logOutButton = By.xpath("//button[contains(text(), 'Sign')]");
    private final By pomxml = By.xpath("//div/div[2]/div[1]/div[3]/div[3]/div[1]/div[8]/div[2]/span/a");

    @Step("Вылогин")
    public HomePage logout(){
        driver.findElement(userProfileButton).click();
        waitFor10.until(ExpectedConditions.visibilityOf(driver.findElement(logOutButton))).click();
        return new HomePage(driver);
    }

}