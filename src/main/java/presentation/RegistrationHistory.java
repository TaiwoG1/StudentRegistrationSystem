package com.example.registrationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import business.AccessStudent;
import objects.Course;
import objects.Student;

import static business.AccessStudent.sps;

public class RegistrationHistory extends AppCompatActivity {

    public Course[] previous;
    public TextView myDisplay;
    public String show;
    private Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_history);

        //StudentPersistenceStub sps = new StudentPersistenceStub();
        //student = sps.getStudent();
        AccessStudent ass = new AccessStudent();
        student = ass.getStudentSequential().get(0);

        previous = student.getCompletedList();
        myDisplay = (TextView) findViewById(R.id.displayPreviousCourse);
        show = "";
        for (int i = 0; i < student.getNumOfCourses(); i++) {
            if (previous[i] != null) {
                show += previous[i].getCourseInfo() + "\n";
            }
        }
        myDisplay.setText(show);
    }
}
