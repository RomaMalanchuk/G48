package pages.code;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseProjectPage;

import static org.junit.Assert.assertEquals;

public class PomPage extends BaseProjectPage {

    private static final String title = "Страница pompage";

    public PomPage(WebDriver driver) {
        super(driver, title);
    }
    private final By pomVersion = By.xpath("//*[@id='LC50']");

    @Step("Получение версии джава в ПОМ ХМЛ")
    public PomPage getVersionSeleniumJava (String expectedSeleniumVersion){
        String version;
        version = driver.findElement(pomVersion).getText().split("</")[0].split(">")[1];
        LOG.info(version);
        assertEquals("version is not propriate", expectedSeleniumVersion, version );
        return this;
    }
    }