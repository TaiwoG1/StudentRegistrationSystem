package com.example.registrationactivity;

//import static application.Main.courseDatabase;
//import static application.Main.courseTotal;
//import static application.Main.student;
import static objects.Course.*;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.List;

import business.AccessCourse;
import objects.Course;


public class lookUpClass extends AppCompatActivity {

    public Course[] courseDB;
    public TextView myDisplay;
    public String show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_up_class);

        SearchView searchView= (SearchView) findViewById(R.id.searchView1);
        int id = searchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);
        TextView textView = (TextView) searchView.findViewById(id);
        textView.setTextColor(Color.BLACK);


        //AccessCourse accessCourse = new AccessCourse();
        //List<Course> cdb = accessCourse.getCourseSequential();

        courseDB = courseDatabase;
        myDisplay = (TextView) findViewById(R.id.allCourses);
        show = "";
        for (int i = 0; i < courseTotal; i++)
        {
            show += courseDB[i].getCourseInfo() + "\n";
        }
        myDisplay.setText(show);

    }

}