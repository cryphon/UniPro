package Structures;

public class Grades {

    int javaGrade;
    int cSharpGrade;
    int pythonGrade;
    int phpGrade;
    //ctor no args
    public Grades() { javaGrade = cSharpGrade = pythonGrade = phpGrade = 0; }
    //ctor args
    public Grades(int javaGrade, int cSharpGrade, int pythonGrade, int phpGrade) {
        this.javaGrade = javaGrade;
        this.cSharpGrade = cSharpGrade;
        this.pythonGrade = pythonGrade;
        this.phpGrade = phpGrade;
    }
}
