package Structures;

import java.util.Locale;
import java.util.Scanner;

public class UserAdmin extends User {
    public UserAdmin(String uName, String uPasswd) {
        super(uName, uPasswd);
    }

    public void UserMenu(){
        var sc = new Scanner(System.in);
        System.out.print("\n| S. Display Students | T. Display Teachers | A. Add Students | D. Delete Students | AT. Add Teacher | DT. Delete Teacher | R. Display Reports | X. Exit |\n Please enter a command: ");
        TreatMenuInput(String.valueOf(sc.next()));
    }

    @Override
    public void TreatMenuInput(String i) {
        switch (i.toUpperCase(Locale.ROOT)) {
            case "A":
                super.AddStudent();
                break;
            case "D":
                super.DeleteStudent();
                break;
            case "AT":
                super.AddTeacher();
                break;
            case "DT":
                super.DeleteTeacher();
                break;
            case "R":
                super.DisplayReports();
                break;
            default:
                super.TreatMenuInput(i);
        }
    }

}
