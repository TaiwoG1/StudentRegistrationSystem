package com.example.registrationactivity;

//import static application.Main.accessCourse;
//import static application.Main.courseDatabase;
//import static application.Main.courseTotal;
import static com.example.registrationactivity.MainActivity.as;
import static com.example.registrationactivity.MainActivity.ac;
import static objects.Course.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.registrationactivity.MainActivity2;
import com.example.registrationactivity.R;

import objects.Course;

public class dropCourse extends AppCompatActivity {
    private Button cancelBut;
    private EditText coursetoDrop;
    private Button okBut;
    private TextView displays;
    private Course[] coursedb = courseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_course);
        //coursedb = courseDatabase;

        cancelBut = (Button) findViewById(R.id.cancel);
        cancelBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelCourse();
            }
        });

        coursetoDrop = (EditText) findViewById(R.id.textInput);
        okBut = (Button) findViewById(R.id.ok);
        okBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropACourse();
            }
        });

        displays = (TextView) findViewById(R.id.display);

    }

    public void cancelCourse()
    {
        //Intent intent = new Intent(this, MainActivity2.class);
        //startActivity(intent);
        coursetoDrop.setText("");
        //coursetoDrop.setText(null);
        displays.setText("");

    }

    public void dropACourse()
    {
        displays.setText("You have successfully dropped course " + coursetoDrop.getText());

        boolean found = false;
        int i = 0;

        String cta = coursetoDrop.getText().toString();
        if (coursetoDrop != null && !(cta.equals(""))) {
            int courseId = Integer.parseInt(coursetoDrop.getText().toString());
            //go through/check the list of all courses, using a for loop, for each course
            //check if the input id is the same as any of the courses id
            //if found then pass the course with the input id as the dropCourse() parameter
            while ((i < courseTotal) && (!found)) {
                if (courseDatabase[i].getCourseCode() == courseId) {
                    found = true;
                    int remove = ac.dropCourse(courseDatabase[i]);
                    if (remove == 1) {
                        //course removed
                        displays.setText("You have successfully dropped course " + coursetoDrop.getText());
                    } else if (remove == 2) {
                        //not registered
                        displays.setText("Cannot drop Course " + coursetoDrop.getText() + ". Not current registered to course");
                    } else {
                        displays.setText("System Error, please try again");
                    }
                }
                i++;
            }
            if (!found) {
                //could not add to course
                displays.setText("Course " + coursetoDrop.getText() + " does not exist. Cannot drop course");

            }
        }
        else
        {
            displays.setText("");
        }
    }
}