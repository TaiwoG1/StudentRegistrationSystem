package com.example.registrationactivity;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import business.AccessStudent;
import objects.Course;
import objects.Student;

import static business.AccessStudent.sps;

public class ActiveRegistration extends AppCompatActivity {

    public Course[] current;
    public TextView myDisplay;
    public String show;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_registration);

        //StudentPersistenceStub sps = new StudentPersistenceStub();
        //student = sps.getStudent();
        AccessStudent ass = new AccessStudent();
        student = ass.getStudentSequential().get(0);


        current = student.getCourseList();
        myDisplay = (TextView) findViewById(R.id.displayCurrentCourse);
        show = "";
        for (int i = 0; i < student.getNumOfCourses(); i++) {
            if (current[i] != null) {
                show += current[i].getCourseInfo() + "\n";
            }
        }
        myDisplay.setText(show);
    }
}
