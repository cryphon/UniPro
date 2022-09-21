package Structures;

import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

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
        System.out.printf("\n%s\t%s\t\t%-10s\t%s\t%s\t\t%s", get_uid(), get_firstName(), get_lastName(), get_dateOfBirth().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)), get_age(), get_group());
    }

    public void PrintStudentAndGrades(){
        PrintStudent();
        PrintGrades();
    }
    public void PrintReport(){
        PrintReportName();
        PrintReportCourses();
        PrintReportResults();
    }

    private void PrintGrades(){
        System.out.printf("\t\t%s\t\t%s\t\t%s\t\t%s", grades.javaGrade, grades.cSharpGrade, grades.pythonGrade, grades.phpGrade);
    }
    private void PrintReportName(){
        System.out.printf("\nReport of student %s %s\n", get_firstName(), get_lastName());
        System.out.printf("\nStudent Id\t\t----------\t\t%s", get_uid());
        System.out.printf("\nFirst Name\t\t----------\t\t%s", get_firstName());
        System.out.printf("\nLast Name\t\t----------\t\t%s", get_lastName());
        System.out.printf("\nAge\t\t\t\t----------\t\t%s", get_age());
    }
    private void PrintReportCourses(){
        System.out.print("\nCOURSES\n");
        System.out.printf("\nJava\t\t----------\t\t%s", get_Grades().javaGrade);
        System.out.printf("\nCSharp\t\t----------\t\t%s", get_Grades().cSharpGrade);
        System.out.printf("\nPython\t\t----------\t\t%s", get_Grades().pythonGrade);
        System.out.printf("\nPHP\t\t\t----------\t\t%s", get_Grades().phpGrade);
    }
    private void PrintReportResults(){
        System.out.print("\nRESULTS\n");
        //passed - not passed
        String pass = ((get_Grades().phpGrade + get_Grades().pythonGrade + get_Grades().cSharpGrade + get_Grades().javaGrade) / 4) > 55 ? "Passed" : "Not Passed";
        System.out.printf("\nResult\t\t----------\t\t%s", pass);
        //retakes
        int retakes = 0;
        if(get_Grades().javaGrade < 55)
            retakes++;
        if(get_Grades().cSharpGrade < 55)
            retakes++;
        if(get_Grades().pythonGrade < 55)
            retakes++;
        if(get_Grades().phpGrade < 55)
            retakes++;
        System.out.printf("\nRetakes\t\t----------\t\t%s", retakes);
    }

    public void ChangeGrades(){
        var sc = new Scanner(System.in);
        System.out.printf("Current grade for Java is: %s | Enter (new) grade: ", get_Grades().javaGrade);
        get_Grades().javaGrade = Integer.parseInt(sc.next());
        System.out.printf("Current grade for CSharp is: %s | Enter (new) grade: ", get_Grades().cSharpGrade);
        get_Grades().cSharpGrade = Integer.parseInt(sc.next());
        System.out.printf("Current grade for Python is: %s | Enter (new) grade: ", get_Grades().pythonGrade);
        get_Grades().pythonGrade = Integer.parseInt(sc.next());
        System.out.printf("Current grade for PHP is: %s | Enter (new) grade: ", get_Grades().phpGrade);
        get_Grades().phpGrade = Integer.parseInt(sc.next());
    }
}
