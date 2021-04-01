package models;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        MyLogger.log("This is a message1");
        MyLogger.info("This is a message2");
        MyLogger.error("This is a message3");
        MyLogger.debug("This is a message4");
        
        A a_class = new A();
        B b_class = new B("MyName", 13);
        a_class.print_name();
        b_class.print_name();

        a_class.print_list(null);
        b_class.print_list(a_class.my_method());
        b_class.print_list(Arrays.asList("b_test_1", null, "b_test_3"));
        
        
        b_class.my_method(a_class.my_method());
    }

}