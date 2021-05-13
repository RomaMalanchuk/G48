package pages.code;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseProjectPage;

import java.util.List;

public class CodePage extends BaseProjectPage {

    private static final String title = "Страница code page";

    public CodePage(WebDriver driver) {
        super(driver, title);
    }

    private final By commitMessageText = By.xpath("//a[@data-test-selector = 'commit-tease-commit-message']");
    private By pomxml = By.xpath("//span//a[text() = 'pom.xml']");
    private final By projectTabs = By.xpath("//nav[@aria-label = 'Repository']");

    @Step("Вывод сообщения")
    public CodePage showCommitMessage() {
        LOG.info(driver.findElements(commitMessageText).get(0).getText());
        return this;

    }
    @Step ("Открытие файла ПОМХМЛ")
    public PomPage openPomXml() {
        driver.findElement(pomxml).click();
        return new PomPage(driver);
    }

    @Step("Вывод названия табов проекта")
    public CodePage logNamesOfProjectTabs() {
        List<WebElement> listOfTabs;
        listOfTabs = driver.findElement(projectTabs).findElements(By.xpath("//nav[@aria-label = 'Repository']//li//a//span"));
        for (WebElement element : listOfTabs) {
            if (element.isDisplayed()) {
                LOG.info(element.getText());

            }

        }
        return this;
    }

}