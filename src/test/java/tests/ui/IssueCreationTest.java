package tests.ui;

import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

import static helpers.ExcelHelper.readDataProviderFromExcel;
import static java.lang.System.getProperty;

@RunWith(Parameterized.class)
public class IssueCreationTest extends BaseTest{

    private final String title;
    private final String body;
    private final List<String> labels;

    private  LoginPage page;

    public IssueCreationTest(String title,
                             String body,
                             List<String> labels) {
        this.title = title;
        this.body = body;
        this.labels = labels;
    }

    @Parameterized.Parameters
    public static List<Object[]> data(){
        return readDataProviderFromExcel(
                "C:\\Users\\romam\\IdeaProjects\\G48\\src\\test\\resources\\testData\\Sheet1.xls",
                "Sheet1");
    }

    @Before
    public void prepareData(){
        this.page = new LoginPage(this.driver);
    }

    @Description("Проверка создание новой Issue")
    @Test
    public void checkIssueCreation(){
        this.page.login(getProperty("username"), getProperty("password"))
                .openProjectG48()
                .openIssues()
                .openCreationPage()
                .createNewIssue(
                        this.title,
                        this.body,
                        this.labels)
                .validateIssue(
                        this.title,
                        this.body,
                        this.labels)
                .logout();

    }


}