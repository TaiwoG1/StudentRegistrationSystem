package business;

//import static application.Main.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import application.Services;
import objects.*;
import persistence.StudentPersistence;
import persistence.stub.StudentPersistenceStub;

public class AccessStudent {
    private StudentPersistence studentPersistence;
    //private List<Student> student;
    private Student studentx;
    private int currentStudent;
    private Student student;
    public static StudentPersistenceStub sps;

    public AccessStudent()
    {
        studentPersistence = Services.getStudentPersistence();
        studentx = null;
        currentStudent = 0;
        ///sps = new StudentPersistenceStub();
        student = studentPersistence.getStudentSequential().get(0);
    }

    public AccessStudent(final StudentPersistence studentPersistence) {
        this();
        this.studentPersistence = studentPersistence;
    }

    public List<Student> getStudentSequential() {
        return studentPersistence.getStudentSequential();
    }


    public void printUserInfo()
    {
        System.out.println(student.getName() + ", " + student.getEmail() + ", id - " + student.getId() + ", " + student.getUserType());
    }

    public String getTranscript(){
        String transcript = "";
        for (int j = 0; j < student.getNumOfCourses(); j++){
            //courseList[j].printCourseInfo();
            //System.out.println("Grade - IP, Total Credit Hours - " + courseList[j].getCreditHour());
            transcript += student.getCourseList()[j].getCourseInfo();
            transcript += ", " + "Total Credit Hours - " + student.getCourseList()[j].getCreditHour() + ", Grade - \"IP\"\n";
        }
        for (int j = 0; j < student.getTotalCourseCompleted(); j++){
            //System.out.println(
            //completedList[j].printCourseInfo();
            //System.out.println("Grade - IP, Total Credit Hours - " + completedList[j].getCreditHour());
            transcript += student.getCompletedList()[j].getCourseInfo();
            transcript += ", " + "Total Credit Hours - " + student.getCompletedList()[j].getCreditHour() + ", Grade - \"F\"\n";
        }
        return transcript;
    }

    public void printCourseList() {
        System.out.println(student.getName() + " is currently enrolled in the following courses:");
        for (int i = 0; i < student.getNumOfCourses(); i++){
            student.getCourseList()[i].printCourseInfo();
        }
    }

    public void printCompletedCourseList() {
        System.out.println(student.getName() + " has completed the following courses:");
        for (int i = 0; i < student.getNumOfCourses(); i++){
            student.getCompletedList()[i].printCourseInfo();
        }
    }

    public String calculateGPA()
    {
        double gpa;
        return "IP";
    }

}
