package Structures;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
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
                super.AddStudent();
                break;
            case "R":
                super.DisplayReports();
                break;
            default:
                super.TreatMenuInput(i);
        }
    }

}
