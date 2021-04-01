package tests;

import helpers.FileHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static helpers.FileHelper.readFile;
import static helpers.FileHelper.writeFileAndGet;
import static org.junit.Assert.assertTrue;

public class SomeTestTest {

        @Test
        public void some(){
          //  System.out.println(readFile("C:\\Users\\romam\\IdeaProjects\\G48\\src\\test\\java\\resources.properties"));
            List<String> data = new ArrayList<>();
            data.add("Я буду хорошим автоматизатором на Selenium");
            data.add("Я буду хорошим автоматизатором на Selenium");
            data.add("Я буду хорошим автоматизатором на Selenium");
            data.add("Я буду хорошим автоматизатором на Selenium");
            data.add("Я буду хорошим автоматизатором на Selenium");


            writeFileAndGet(data, "our_test.txt").exists();
        }
    }

