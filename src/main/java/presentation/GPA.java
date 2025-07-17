package com.example.registrationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import business.AccessStudent;
import objects.Course;
import objects.Student;

import static business.AccessStudent.sps;
public class GPA extends AppCompatActivity {

    public Course[] current;
    public Course[] previous;
    public TextView myDisplay;
    public String show;
    private Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

        //student = sps.getStudent();
        AccessStudent ass = new AccessStudent();
        student = ass.getStudentSequential().get(0);


        current = student.getCourseList();
        myDisplay = (TextView) findViewById(R.id.displayCoursesView);
        show = "";
        for (int i = 0; i < student.getNumOfCourses(); i++) {
            if (current[i] != null) {
                show += current[i].getCourseInfo() + " Grade - \"IP\"\n";
            }
        }
        myDisplay.setText(show);


        previous = student.getCompletedList();
        myDisplay = (TextView) findViewById(R.id.displayCoursesView);
        for (int i = 0; i < student.getNumOfCourses(); i++) {
            if (previous[i] != null) {
                show += previous[i].getCourseInfo() + " Grade - \"IP\"\n";
            }
        }

        show += "GPA - " + ass.calculateGPA();
        myDisplay.setText(show);
    }
}