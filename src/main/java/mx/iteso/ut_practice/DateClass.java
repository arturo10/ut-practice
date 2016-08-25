package main.java.mx.iteso.ut_practice;
import java.time.*;
import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClass {

	public String getAge(String dateOfBirth){
		dateOfBirth=dateOfBirth.replace('/', '-');
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);
		String year="";
		String result="";
		try{
			Date date = formatter.parse(dateOfBirth);

            if(date!=null) {
                Calendar dob = Calendar.getInstance();
                dob.setTime(date);
                Calendar today = Calendar.getInstance();
                int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
                int month = -dob.get(Calendar.MONTH);
                int months = 0;
                int days = 0;

                if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                    age--;
                    months = today.get(Calendar.MONTH);
                    days = today.get(Calendar.DAY_OF_MONTH);
                } else if (today.get(Calendar.DAY_OF_YEAR) == dob.get(Calendar.DAY_OF_YEAR)) {
                    months = 0;
                    days = 0;
                } else {
                    if ((today.get(Calendar.MONTH) == dob.get(Calendar.MONTH))) {
                        months = 0;
                        days = today.get(Calendar.DAY_OF_MONTH) - dob.get(Calendar.DAY_OF_MONTH);
                    } else {
                        if (today.get(Calendar.DAY_OF_MONTH) >= dob.get(Calendar.DAY_OF_MONTH)) {
                            months = (today.get(Calendar.MONTH) - dob.get(Calendar.MONTH));
                            days = (today.get(Calendar.DAY_OF_MONTH) - dob.get(Calendar.DAY_OF_MONTH));
                        } else {
                            Calendar calBirth = new GregorianCalendar(dob.get(Calendar.YEAR), dob.get(Calendar.MONTH), dob.get(Calendar.DAY_OF_MONTH));

                            days = (calBirth.getActualMaximum(Calendar.DAY_OF_MONTH) - dob.get(Calendar.DAY_OF_MONTH)) + today.get(Calendar.DAY_OF_MONTH);
                            months = (today.get(Calendar.MONTH) - dob.get(Calendar.MONTH)) - 1;
                        }
                    }
                }

                int day = today.get(Calendar.DAY_OF_MONTH);
                year = String.valueOf(age);
                result = "Tienes " + year + " años ," + months + " meses, " + days + " dias";
            }

		}catch(java.text.ParseException ex){
		    if(dateOfBirth.matches("[a-zA-Z]+")){
                result="This is not a date";
            }else{

                if(!dateOfBirth.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")){
                    result="Bad format";
                }else{
                    String []groupsOfDate=dateOfBirth.split("-");

                    if(!(Integer.parseInt(groupsOfDate[1])<=12 && Integer.parseInt(groupsOfDate[1])>0))
                        result="Invalid Month";
                    else{
                        Calendar calendar=new GregorianCalendar(Integer.parseInt(groupsOfDate[2]),
                                Integer.parseInt(groupsOfDate[1]),1);

                        if(!(Integer.parseInt(groupsOfDate[0])<=calendar.getActualMaximum(Calendar.DAY_OF_MONTH) &&
                                Integer.parseInt(groupsOfDate[0])>0)){
                            result="Invalid Day";
                        }

                    }


                }
            }


		}catch(Exception ex){

        }
		return result;
	}
	
	
}
