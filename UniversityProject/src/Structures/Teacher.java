package Structures;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class Teacher extends Person{

    public Teacher(String uName, String uPasswd, String fName, String lName, LocalDate dob) {
        super(fName, lName, dob, new UserEditor(uName, uPasswd));
    }

    public void PrintTeacher(){
        System.out.printf("%s\t%s\t\t%-10s\t%s\t%s\n", get_uid(), get_firstName(), get_lastName(), get_dateOfBirth().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)), get_age());
    }
}
