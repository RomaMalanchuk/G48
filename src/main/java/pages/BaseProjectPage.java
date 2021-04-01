package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.code.CodePage;
import pages.issues.IssuesPage;

public abstract class BaseProjectPage extends BaseAuthorizedPage {
    public BaseProjectPage(WebDriver driver) {
        super(driver);
    }

    private final By codeTab = By.xpath("//span[@data-content = 'Code']");
    private final By IssuesTab = By.xpath("//span[@data-content = 'Issues']");
    private final By Pullrequests = By.xpath("//span[@data-content = 'Pull requests']");
    private final By Actions = By.xpath("//span[@data-content = 'Actions']");
    private final By Projects = By.xpath("//span[@data-content = 'Projects']");
    private final By Wiki = By.xpath("//span[@data-content = 'Wiki']");
    private final By Security = By.xpath("//span[@data-content = 'Security']");
    private final By Insights = By.xpath("//span[@data-content = 'Insights']");
    private final By settingsTab = By.xpath("//span[@data-content = 'Settings']");

    public CodePage openSourceCode() {
        driver.findElement(codeTab).click();
        return new CodePage(driver);

    }

    public IssuesPage openIssues() {
        driver.findElement(IssuesTab).click();
        return new IssuesPage(driver);
    }
}