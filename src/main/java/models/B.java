package models;

import models.Parent;

import java.util.Collections;
import java.util.List;

public class B extends Parent {
	private int number;
	

    public B(String name, int number) {
    	super(name);
        this.number = number;
    }    
 
    public void my_method(List<String> list) {
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            LOGGER.fine(list.get(i));
        }
    }
}