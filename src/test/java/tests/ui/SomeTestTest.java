package tests.ui;

import helpers.FileHelper;
import io.qameta.allure.Description;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static helpers.ExcelHelper.readDataFromExcelFile;
import static helpers.ExcelHelper.writeToExcelFileAndGet;
import static helpers.FileHelper.readFile;
import static helpers.FileHelper.writeFileAndGet;
import static org.junit.Assert.assertTrue;

public class SomeTestTest {

    @Description("Проверка вычитки из файла")
    @Test
    public void some() {
        //  System.out.println(readFile("C:\\Users\\romam\\IdeaProjects\\G48\\src\\test\\java\\resources.properties"));
        List<String> data = new ArrayList<>();
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");
        data.add("Я буду хорошим автоматизатором на Selenium");


        writeFileAndGet(data, "our_test.txt").exists();
    }

    @Description("Проверка записи данных в эксель")
    @Test
    public void someExcel() {
        readDataFromExcelFile(
                writeToExcelFileAndGet(
                        "C:\\Users\\romam\\IdeaProjects\\G48\\target\\test-classes",
                        readDataFromExcelFile(
                                "/C:\\Users\\romam\\IdeaProjects\\G48\\src\\test\\resources\\testData\\Sheet1.xls",
                                "Sheet1")).getPath(), "Automated Sheet")
                .forEach(System.out::println);
    }

    @Description("Проверка вычитки данных из эксель")
    @Test
    public void checkExcelProvider(){
        readDataFromExcelFile("C:\\Users\\romam\\IdeaProjects\\G48\\src\\test\\resources\\testData\\Sheet1.xls",
                "Sheet1")
                .forEach(objectArray -> System.out.println(Arrays.asList(objectArray)));
    }
    @Test
    public void checkSystemProperty(){
        System.setProperty("login", "romamalanciuk@gmail.com");
        String username = System.getProperty("username", "");

    }
}

