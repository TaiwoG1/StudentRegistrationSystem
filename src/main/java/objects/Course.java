package objects;
import application.Main;
import static application.Main.*;

public class Course {
    //class variables
    protected String name;
    protected int courseCode;
    protected Instructor instructor;
    protected int capacity;
    protected Course prereq;
    protected int time;
    protected int creditHour;
    protected Student[] classList;
    protected int numStudent = 0;
    public static int courseTotal = 0;
    public static Course[] courseDatabase = new Course[10];

    //protected String code;


    //constructor
    public Course(String courseName, int cc)
    {
        name = courseName;
        courseCode = cc;
    }

    public Course(String courseName, int cc, int cap, int time, int cHr) {
        name = courseName;
        courseCode = cc;
        //instructor = inst;
        capacity = cap;
        //prereq = pr;
        this.time = time;
        creditHour = cHr;
        classList = new Student[capacity];
        //courseTotal++;
        courseDatabase[courseTotal++] = this;
    }

    /*
    public Course(String courseName, String cc, String inst, String cap, String pr, String time, String cHr) {
        name = courseName;
        courseCode = cc;
        instructor = inst;
        capacity = cap;
        prereq = pr;
        this.time = time;
        creditHour = cHr;
        classList = new Student[capacity];
        //courseTotal++;
        courseDatabase[courseTotal++] = this;
    }*/


    //accessor
    public String getCourseName() {
        return name;
    }

    public int getCourseCode() {
        return courseCode;
    }

    //public Instructor getInstructor() {
    //    return instructor;
    //}

    public int getCapacity() {
        return capacity;
    }

    //public Course getPrereq() {
    //   return prereq;
    //}

    public int getTime() {
        return time;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public Student[] getClassList() {
        return classList;
    }

    public int getNumOfStudent() {
        return numStudent;
    }

    //mutator
    public void setNumOfStudent(int number) {
        numStudent = number;
    }

    public void setInstructor(Instructor inst) {
        instructor = inst;
    }


    public void printCourseInfo()
    {
        System.out.println(this.getCourseName() + ", " + this.getCourseCode());// + ", Instructor - " + this.getInstructor().getName());
    }
    public String getCourseInfo()
    {
        String ret  ="" + this.getCourseName() + ", " + this.getCourseCode(); // + ", Instructor - " + this.getInstructor().getName();
        return ret;
    }


    /*
    public void printClassList() {
        System.out.println("Class list for course " + this.getCourseCode() + ":");
        for (int i = 0; i < numStudent; i++) {
            classList[i].printUserInfo();
        }
    }
    */
}

/*
    //business/logic layer
    protected void printCourseInfo()
    {
        System.out.println(this.getName() + ", " + this.getCourseCode() + ", Instructor - " + this.getInstructor().getName());
    }
    protected String getCourseInfo()
    {
        String ret  ="" + this.getName() + ", " + this.getCourseCode() + ", Instructor - " + this.getInstructor().getName();
        return ret;
    }
    public void printClassList() {
        System.out.println("Class list for course " + this.getCourseCode() + ":");
        for (int i = 0; i < numStudent; i++) {
            classList[i].printUserInfo();
        }
    }
*/