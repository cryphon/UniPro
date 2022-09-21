package Structures;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        PersonDB db = PersonDB.getInstance();
        db.DisplayStudents();
    }
    public void DisplayTeachers(){
        System.out.print("\nLIST OF TEACHERS\n\n");
        System.out.println("ID\tFirstName\tLastname\tBirthdate\tAge\n" +
                "**\t*********\t********\t*********\t***");
        PersonDB db = PersonDB.getInstance();
        db.DisplayTeachers();
    }

    public void DisplayReports(){
        PersonDB db = PersonDB.getInstance();
        System.out.println("\nID\tFirstName\tLastname\tBirthdate\tAge\t\tGroup\t\tJava\tCSharp\tPython\tPHP\n" + "**\t*********\t********\t*********\t***\t\t*****\t\t****\t******\t******\t***");
        db.DisplayReports();
        System.out.print("\nEnter a student id (Report details) | or 0 to go back to the menu:");
        List<Student> studentList = db.GetAllStudents();
        int input = Integer.parseInt(new Scanner(System.in).next());
        if(input > 0){
            if(studentList.stream().anyMatch(s -> Objects.equals(s.get_uid(), input))){
                Optional<Student> s = studentList.stream().filter(st -> Objects.equals(st.get_uid(), input)).findFirst();
                DisplayStudentReport(s.get());
            }
            else{
                System.out.println("Student with this ID does not exist");
            }
        }
    }
    public void DisplayStudentReport(Student student){
        student.PrintReport();
        DisplayStudentReportMenu(student);
    }
    public void DisplayStudentReportMenu(Student student){
        System.out.print("\n A. Add (Update) Report | R. Display Reports | B. Back to Main | X. Exit");
        System.out.print("\nPlease enter an option: ");
        var sc = new Scanner(System.in);
        switch (sc.next().toUpperCase()){
            case "A":
                student.ChangeGrades();
                break;
            case "R":
                DisplayReports();
                break;
            case "B":
                UserMenu();
                break;
            case "X":
                return;
            default:
                System.out.print("option does not exist");
                DisplayStudentReport(student);
                break;
        }
        DisplayStudentReportMenu(student);
    }

    //END Display

    //BEGIN Add - Delete
    public void AddStudent(){
        PersonDB db = PersonDB.getInstance();
        var sc = new Scanner(System.in);
        System.out.print("\nADD STUDENT\n");
        Map<List<String>, LocalDate> entry = GetUserBasicInfo();
        List<String> basicInfo = new ArrayList<>();
        LocalDate dob = LocalDate.now();
        for(Map.Entry<List<String>, LocalDate> entry1 : entry.entrySet()){
            basicInfo = entry1.getKey();
            dob = entry1.getValue();
        }
        System.out.print("Enter group: ");
        String group = String.valueOf(sc.next());
        db.CreateStudent(basicInfo.get(0), basicInfo.get(1), basicInfo.get(2), basicInfo.get(3), dob, group);
        UserMenu();
    }
    public void DeleteStudent(){
        PersonDB db = PersonDB.getInstance();
        DisplayStudents();
        Person s = GetPersonByID();
        db.DeleteUser(s);
        UserMenu();
    }
    public void AddTeacher(){
        PersonDB db = PersonDB.getInstance();
        var sc = new Scanner(System.in);
        System.out.print("\nADD Teacher\n");
        Map<List<String>, LocalDate> entry = GetUserBasicInfo();
        List<String> basicInfo = new ArrayList<>();
        LocalDate dob = LocalDate.now();
        for(Map.Entry<List<String>, LocalDate> entry1 : entry.entrySet()){
            basicInfo = entry1.getKey();
            dob = entry1.getValue();
        }
        db.CreateTeacher(basicInfo.get(0), basicInfo.get(1), basicInfo.get(2), basicInfo.get(3), dob);
        UserMenu();
    }
    public void DeleteTeacher(){
        PersonDB db = PersonDB.getInstance();
        DisplayTeachers();
        Person s = GetPersonByID();
        db.DeleteUser(s);
        UserMenu();
    }

    //END Add = Delete

    private Person GetPersonByID(){
        PersonDB db = PersonDB.getInstance();
        var sc = new Scanner(System.in);
        System.out.print("\nSpecify ID of a person you would like to delete: ");
        int id = Integer.parseInt(sc.next());
        if(db.Get_Users().stream().noneMatch(s -> Objects.equals(s.get_uid(), id))){
            System.out.printf("Person with id %s does not exist", id);
            GetPersonByID();
        }
        return db.Get_Users().stream().filter(s -> Objects.equals(s.get_uid(), id)).findFirst().get();
    }

    private Map<List<String>, LocalDate> GetUserBasicInfo(){
        List<String> info = new ArrayList<>();
        var sc = new Scanner(System.in);
        System.out.print("\nChoose a username: ");
        info.add(String.valueOf(sc.next()));
        System.out.print("Choose a password: ");
        info.add(String.valueOf(sc.next()));
        System.out.print("Enter first name: ");
        info.add(String.valueOf(sc.next()));
        System.out.print("Enter last name: ");
        info.add(String.valueOf(sc.next()));
        System.out.print("Please enter date of birth in DD/MM/YYYY: ");
        //very complicated format query
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dob = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("d/MM/yyyy"));
        Map<List<String>, LocalDate> entry = new HashMap<>();
        entry.put(info, dob);
        return entry;
    }
}
