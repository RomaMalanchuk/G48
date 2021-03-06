package pages.issues;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseProjectPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class IssueInfoPage extends BaseProjectPage {

    private static final String title = "Страница задачи";

    public IssueInfoPage(WebDriver driver) {
        super(driver, title);
    }

    private final By titleOnPage = By.xpath("//span[@class = 'js-issue-title markdown-title']");
    private final By body = By.xpath("//td[@class = 'd-block comment-body markdown-body  js-comment-body']");

    private final By labels = By.xpath("//a[@class = 'IssueLabel hx_IssueLabel d-inline-block v-align-middle']");

    @Step("Проверка успешности создание Issue")
    public IssueInfoPage validateIssue(String expectedTitle,
                                       String expectedBody,
                                       List<String> expectedLabels){
        LOG.info("Проверяем успешность создания задачи и соответствие её полей");
        assertEquals(expectedTitle, waitFor10.until(visibilityOf(driver.findElement(titleOnPage))).getText());
        assertEquals(expectedBody, driver.findElement(body).getText());

        List<WebElement> labelsOnPage =  driver.findElements(labels);
        List<String> labelsTitles = new ArrayList<>();
        labelsOnPage.forEach(label -> {
            assertTrue(expectedLabels.contains(label.getText()));
            labelsTitles.add(label.getText());
        });
        assertEquals(expectedLabels, labelsTitles);
        LOG.info("Создание успешно. Тест пройден");
        return this;
    }

}