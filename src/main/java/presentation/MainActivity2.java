package com.example.registrationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.registrationactivity.addCourse;
import com.example.registrationactivity.dropCourse;
import com.example.registrationactivity.R;

public class MainActivity2 extends AppCompatActivity {
    private Button addCourseButton;
    private Button dropCourseButton;
    private Button lookUpClassButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addCourseButton = (Button) findViewById(R.id.button);
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddCourse();
            }
        });
        dropCourseButton = (Button) findViewById(R.id.button2);
        dropCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDropCourse();
            }
        });
        lookUpClassButton = (Button) findViewById(R.id.button3);
        lookUpClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLookUpClass();
            }
        });
    }

    public void openAddCourse()
    {
        Intent intent = new Intent(this, addCourse.class);
        startActivity(intent);
    }

    public void openDropCourse()
    {
        Intent intent = new Intent(this, dropCourse.class);
        startActivity(intent);
    }

    public void openLookUpClass()
    {
        Intent intent = new Intent(this, lookUpClass.class);
        startActivity(intent);
    }
}

