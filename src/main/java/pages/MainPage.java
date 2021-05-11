package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.code.CodePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainPage extends BaseAuthorizedPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By repositoryLink = By.xpath("//span[@title = 'G48Automation']");
    private final By searchMyProject = By.xpath("//label[@class = 'form-control input-sm header-search-wrapper p-0 js-chromeless-input-container header-search-wrapper-jump-to position-relative d-flex flex-justify-between flex-items-center']");
    private final By searchMyProject2 = By.xpath("//em");

    @Step ("Открытие проекта G48Automation")
    public CodePage openProjectG48() {
        waitFor25.until(elementToBeClickable(repositoryLink)).click();
        return new CodePage(driver);
    }
        @Step("Поиск моей страницы проекта")
        public MainPage searchMyProjectPage(){
            driver.findElement(searchMyProject).sendKeys("RomaMalanchuk/G48Automation\n");
            driver.findElement(searchMyProject2).click();
            return this;

        }

    }
