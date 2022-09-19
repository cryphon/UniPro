package Structures;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Student extends Person{
    private String _group;
    private Grades grades;

    public String get_group() { return _group; }
    public Grades get_Grades() { return grades; }

    public Student(String uName, String uPasswd, String fName, String lName, LocalDate dob, String group) {
        super(fName, lName, dob, new UserBasic(uName, uPasswd));
        this._group = group;
        grades = new Grades();
    }

    public void PrintStudent(){
        System.out.printf("%s\t%s\t\t%-10s\t%s\t%s\t\t%s\n", get_uid(), get_firstName(), get_lastName(), get_dateOfBirth().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)), get_age(), get_group());
    }
}
