package Structures;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class UserEditor extends User{

    //ctor
    public UserEditor(String uName, String uPasswd) {
        super(uName, uPasswd);
    }

    public void UserMenu(){
        var sc = new Scanner(System.in);
        System.out.print("\n| S. Display Students | T. Display Teachers | A. Add Students | R. Display Reports | X. Exit |\n Please enter a command: ");
        TreatMenuInput(String.valueOf(sc.next()));
    }

    @Override
    public void TreatMenuInput(String i) {
        switch (i.toUpperCase(Locale.ROOT)) {
            case "A":
                AddStudent();
                break;
            case "R":
                DisplayReports();
                break;
            default:
                super.TreatMenuInput(i);
        }
    }

    public void AddStudent(){
        UserDB db = UserDB.getInstance();
        var sc = new Scanner(System.in);
        System.out.print("\nADD STUDENT\n");
        System.out.print("\nChoose a username: ");
        String uName = String.valueOf(sc.next());
        System.out.print("Choose a password: ");
        String uPasswd = String.valueOf(sc.next());
        System.out.print("Enter first name: ");
        String fName = String.valueOf(sc.next());
        System.out.print("Enter last name: ");
        String lName = String.valueOf(sc.next());
        System.out.print("Please enter date of birth in DD/MM/YYYY: ");
        //very complicated format query
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dob = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
        System.out.print("Enter group: ");
        String group = String.valueOf(sc.next());

        db.CreateStudent(uName, uPasswd, fName, lName, dob, group);
    }
    public void DisplayReports(){}
}
