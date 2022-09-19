package Structures;
import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    private final IUser _user;
    private int _uid;
    private final String _firstName;
    private final String _lastName;
    private final LocalDate _dateOfBirth;
    private final int _age;

    public IUser get_user(){ return _user;}
    public  int get_uid(){ return _uid; }
    public  String get_firstName(){ return _firstName; }
    public  String get_lastName() { return this._lastName; }
    public LocalDate get_dateOfBirth() { return _dateOfBirth; }
    public int get_age(){ return _age; }
    public void set_uid(int value){ set: _uid = value;
    }

    //ctor
    public Person(String fName, String lName, LocalDate dob, IUser user){
        _user = user;
        this._firstName = fName;
        this._lastName = lName;
        this._dateOfBirth = dob;
        this._age = Period.between(_dateOfBirth, LocalDate.now()).getYears();
    }
    public void PrintPerson(){
        System.out.printf("uid: %s\t fname:%s", get_uid(), get_firstName());
    }
}
