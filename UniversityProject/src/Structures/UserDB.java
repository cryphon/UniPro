package Structures;

import java.time.LocalDate;
import java.util.*;

public class UserDB {
    protected static List<Person> users;

    //avoid init from other classes
    private UserDB(){
        InitDB();
    }

    //init singleton
    private static class singletonHolder {
        private static final UserDB INSTANCE = new UserDB();
    }

    //get instance
    public static UserDB getInstance(){
        return singletonHolder.INSTANCE;
    }


    //init db
    public void InitDB(){
        users = new ArrayList<>();
        AddUser(new Student("emma", "emma12", "Emma", "Smith", LocalDate.of(1997, 12, 4), "IT_02_A"));
        AddUser(new Student("jack", "jack12", "Jack", "Brown", LocalDate.of(1993, 8, 7), "IT_02_A"));
        AddUser(new Student("michael", "michael12", "Michael", "Garcia", LocalDate.of(1999, 11, 1), "IT_02_A"));
        AddUser(new Student("lisa", "lisa12", "Lisa", "Jones", LocalDate.of(2000, 4, 29), "IT_02_A"));
        AddUser(new Student("john", "john12", "John", "Miller", LocalDate.of(2001, 10, 27), "IT_02_A"));
        AddUser(new Student("linda", "linda12", "Linda", "Martin", LocalDate.of(2002, 1, 17), "IT_02_A"));
        AddUser(new Student("richard", "richard12", "Richard", "Davis", LocalDate.of(1997, 9, 22), "IT_02_A"));
        AddUser(new Student("mark", "mark12", "Mark", "Lopez", LocalDate.of(1996, 12, 9), "IT_02_A"));
        AddUser(new Student("debora", "debora12", "Debora", "Herman", LocalDate.of(1995, 2, 25), "IT_02_A"));
        AddUser(new Student("rick", "rick12", "Rick", "Moore", LocalDate.of(2000, 3, 16), "IT_02_A"));
        AddUser(new Teacher("david", "david12", "David", "Taylor", LocalDate.of(1965, 6, 15)));
        AddUser(new Teacher("sophy", "sophy12", "Sophy", "Anderson", LocalDate.of(1987, 1, 6)));
        AddUser(new Teacher("james", "james12", "James", "Jordan", LocalDate.of(1956, 3, 19)));
        AddUser(new Teacher("susan", "susan12", "Susan", "Jackson", LocalDate.of(1978, 12, 25)));
        AddUser(new Teacher("mary", "mary12", "Mary", "Lee", LocalDate.of(1971, 9, 4)));
    }

    //add uid to user
    public void AddUser(Person p){
        int uid = 0;
        for(Person u : users)
            if(u.get_uid() > uid)
                uid = u.get_uid();
        p.set_uid(uid + 1);
        users.add(p);
    }

    //verify login credentials
     public static User GetUserCredentialsVerification(String uName, String uPasswd) {
        Person u;
        try{
            u = GetUserByName(uName);
            assert u != null; //
            if (!u.get_user().get_uPasswd().equals(uPasswd)) //check pwd
                return null;
            return (User) u.get_user();
        }
        catch (Exception e) { return null;}
    }

    //BEGIN Data handling
     static Person GetUserByName(String uName) {
         Optional<Person> u = users.stream().filter((user -> user.get_user().get_uName().equals(uName))).findFirst();
         if(u.isEmpty())
            return null;
         return (Person) u.get();
     }

     public List<Student> GetAllStudents(){
        List<Student> students = new ArrayList<>();
        for(Person p : users)
            if(p instanceof Student)
                students.add((Student) p);
        return students;
     }

     public List<Teacher> GetALlTeachers(){
        List<Teacher> teachers = new ArrayList<>();
        for(Person p : users)
            if(p instanceof Teacher)
                teachers.add((Teacher) p);
        return teachers;
     }

     public static void SetStudentGrades(){

     }

     public void CreateStudent(String uName, String uPasswd, String fName, String lName, LocalDate dob, String group){
       AddUser(new Student(uName, uPasswd, fName, lName, dob, group));
     }
     //END Data handling

    //BEGIN Display info
    public void DisplayStudents(){
        List<Student> students = GetAllStudents();
        students.forEach(Student::PrintStudent);
    }

    public void DisplayTeachers(){
        List<Teacher> teachers = GetALlTeachers();
        teachers.forEach(Teacher::PrintTeacher);
    }
    //END Display info
}
