package main.test.java;

import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;
import main.java.mx.iteso.ut_practice.DateClass;

public class Test_DateClass {
public DateClass testdate;

    @Before
    public void setUp(){
        testdate=new DateClass();
    }

	@Test
	public void Date_Invalid() {
        assertEquals("This is not a date", testdate.getAge("hola"));
	}
	
	@Test
	public void Date_Bad_Format() {
        assertEquals("Bad format", testdate.getAge("1209/12/12"));
	}
	@Test
	public void Invalid_Day() {
        assertEquals("Invalid Day", testdate.getAge("32/10/1995"));
	}
	@Test
	public void Invalid_Month() {
        assertEquals("Invalid Month", testdate.getAge("12/13/1995"));
	}
	@Test
	public void Invalid_Year() {
        assertEquals("Bad format", testdate.getAge("12/13/ABCD"));
	}
	@Test
	public void Future_Date() {
        assertEquals("This is not a date", testdate.getAge("12/12/2025"));
	}

}

