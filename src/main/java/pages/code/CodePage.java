package pages.code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseProjectPage;

import java.util.List;

public class CodePage extends BaseProjectPage {

    public CodePage(WebDriver driver) {
        super(driver);
    }

    private final By commitMessageText = By.xpath("//a[@data-test-selector = 'commit-tease-commit-message']");
    private By pomxml = By.xpath("//span//a[text() = 'pom.xml']");
    private final By projectTabs = By.xpath("//nav[@aria-label = 'Repository']");

    public CodePage showCommitMessage() {
        LOG.info(driver.findElements(commitMessageText).get(0).getText());
        return this;
    }

    public PomPage openPomXml() {
        driver.findElement(pomxml).click();
        return new PomPage(driver);
    }
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