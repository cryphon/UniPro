package Structures;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public abstract class User implements IUser{
    protected String _uName;
    protected String _uPasswd;

    protected User() { }

    public String get_uName() { return _uName; }
    public String get_uPasswd() {return _uPasswd; }

    //ctor
    public User(String uName, String uPasswd){
        this._uName = uName;
        this._uPasswd = uPasswd;
    }

    //BEGIN Display
    public void UserMenu(){
        var sc = new Scanner(System.in);
        System.out.print("\n| S. Display Students | T. Display Teachers | X. Exit |\n Please enter a command: ");
        TreatMenuInput(String.valueOf(sc.next()));
    }

     public void TreatMenuInput(String i){
        switch(i.toUpperCase()){
            case "S":
                DisplayStudents();
                break;
            case "T":
                DisplayTeachers();
                break;
            case "X":
                return;
            default:
                System.out.print("Command does not exist");
        }
        UserMenu();
    }

    public void DisplayStudents() {
        System.out.print("\nLIST OF STUDENTS\n\n");
        System.out.println("ID\tFirstName\tLastname\tBirthdate\tAge\t\tGroup\n" + "**\t*********\t********\t*********\t***\t\t*****");
        UserDB db = UserDB.getInstance();
        db.DisplayStudents();
    }

    public void DisplayTeachers(){
        System.out.print("\nLIST OF TEACHERS\n\n");
        System.out.println("ID\tFirstName\tLastname\tBirthdate\tAge\n" +
                "**\t*********\t********\t*********\t***");
        UserDB db = UserDB.getInstance();
        db.DisplayTeachers();
    }

    //END Display
}
