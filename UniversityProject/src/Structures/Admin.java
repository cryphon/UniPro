package Structures;

import java.time.LocalDate;

public class Admin extends Person{
    public Admin(String fName, String lName, LocalDate dob, IUser user) {
        super(fName, lName, dob, user);
    }
}
