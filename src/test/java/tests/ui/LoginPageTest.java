package tests.ui;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;


@Feature("pozitive authorization")
@Story("Github auth")
@Owner("RMalanchuk")
@Severity(SeverityLevel.CRITICAL)
public class LoginPageTest extends BaseTest {


    private LoginPage loginPage;

    @Before
    public void setUp() {
        loginPage = new LoginPage(driver);
    }

    @Description("Проверка ввода неправильных логина и пароля")
    @Issue("")
    @Test
    public void checkNegativeLogin() {
        loginPage.login("roagsg", "sdgsdg");
        loginPage.validateErrorMessage("Incorrect username or password.");
    }

    @Description("Вывод и сравнение версии")
    @Issue("")
    @Test
    public void showCommitMessageTest() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .openProjectG48()
                .showCommitMessage()
                .openSourceCode()        //открытие вкладки Code
                .openPomXml()            //открытие файла пом хмл
                .getVersionSeleniumJava("3.141.59");               //вывод и сравнение версии
    }

    @Description("Вывод названия всех вкладок проекта")
    @Issue("")
    @Test
    public void logTabsOfProject() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .openProjectG48()
                .showCommitMessage()
                .logNamesOfProjectTabs();  //вывод название всех вкладок проекта
    }

    @Description("Поиск нашего проэкта")
    @Test
    public void searchProjectMyne() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .searchMyProjectPage();  //поиск проекта в строке поиска и открытие его
    }
}