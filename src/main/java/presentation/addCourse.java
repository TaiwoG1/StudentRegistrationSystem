//package com.example.registrationactivity;
package presentation;
import static objects.Course.*;
import static com.example.registrationactivity.MainActivity.as;
import static com.example.registrationactivity.MainActivity.ac;
//import static application.Main.courseTotal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import objects.*;
import com.example.registrationactivity.MainActivity;
import com.example.registrationactivity.MainActivity2;
import com.example.registrationactivity.R;

import business.*;

import application.Main;

public class addCourse extends AppCompatActivity {
    private Button cancelBut;
    private EditText coursetoAdd;
    private Button okBut;
    private TextView displays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        cancelBut = (Button) findViewById(R.id.cancel);
        cancelBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelCourse();
            }
        });

        coursetoAdd = (EditText) findViewById(R.id.textInput);
        okBut = (Button) findViewById(R.id.ok);
        okBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewCourse();
            }
        });

        displays = (TextView) findViewById(R.id.display);


    }

    public void cancelCourse()
    {
        //Intent intent = new Intent(this, MainActivity2.class);
        //startActivity(intent);
        coursetoAdd.setText("");
        displays.setText("");
    }

    public void addNewCourse()
    {
        //displays.setText("You have successfully added course " + coursetoAdd.getText());
        boolean found = false;
        int i = 0;

        String cta = coursetoAdd.getText().toString();
        if (coursetoAdd != null && !(cta.equals(""))) {
            int courseId = Integer.parseInt(coursetoAdd.getText().toString());
            //go through/check the list of all courses, using a for loop, for each course
            //check if the input id is the same as any of the courses id
            //if found then pass the course with the input id as the addCourse() parameter
            //for (int i = 0; i < courseTotal; i++)
            while ((i < courseTotal) && (!found)) {
                if (courseDatabase[i].getCourseCode() == courseId) {
                    found = true;
                    int insert = ac.addCourse(courseDatabase[i]);
                    if (insert == 1) {
                        displays.setText("You have successfully added course " + coursetoAdd.getText());
                    } else if (insert == 2) {
                        //already in course
                        displays.setText("Cannot add course " + coursetoAdd.getText() + ". Already registered to course");
                    } else if (insert == 3) {
                        //already taken course
                        displays.setText("Cannot add course " + coursetoAdd.getText() + ". Course previously completed");
                    } else if (insert == 4) {
                        //not completed prerequisite
                        displays.setText("Cannot add course " + coursetoAdd.getText() + ". Prerequisite not completed");
                    } else if (insert == 5) {
                        //class at full capacity
                        displays.setText("Cannot add course " + coursetoAdd.getText() + ". Class at full capacity");
                    } else {
                        displays.setText("System Error, please try again");
                    }
                }
                i++;
            }
            if (!found) {
                //couldnt add to course
                displays.setText("Course " + coursetoAdd.getText() + " does not exist. Cannot add course");
            }
        }
        else
        {
            displays.setText("");
        }

    }
}
