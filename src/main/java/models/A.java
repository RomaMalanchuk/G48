package models;

import models.Parent;

import java.util.ArrayList;
import java.util.List;

public class A extends Parent {
    String[] my_array;

    public A() {
    	super("models.A");
    	
        this.my_array = new String[]{ "100", "20", "30", "40"};
        LOGGER.info(String.format("Новый пустой экземпляр класса %s%n", getClass().getName()));
    }

    public List<String> my_method() {
        int i =0;
        ArrayList<String> my_list = new ArrayList<String>();
        while(i <4){
            my_list.add(my_array[i]);
            i++;
        }
        return my_list;
    }
}