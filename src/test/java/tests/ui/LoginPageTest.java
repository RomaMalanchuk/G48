package tests.ui;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {


    private LoginPage loginPage;

    @Before
    public void setUp() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void checkNegativeLogin() {
        loginPage.login("roagsg", "sdgsdg");
        loginPage.validateErrorMessage("Incorrect username or password.");
    }

    @Test
    public void showCommitMessageTest() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .openProjectG48()
                .showCommitMessage()
                .openSourceCode()        //открытие вкладки Code
                .openPomXml()            //открытие файла пом хмл
                .getVersionSeleniumJava("3.141.59");               //вывод и сравнение версии
    }

    @Test
    public void logTabsOfProject() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .openProjectG48()
                .showCommitMessage()
                .logNamesOfProjectTabs();  //вывод название всех вкладок проекта
    }

    @Test
    public void searchProjectMyne() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .searchMyProjectPage();  //поиск проекта в строке поиска и открытие его
    }
}