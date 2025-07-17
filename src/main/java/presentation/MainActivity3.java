package com.example.registrationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
    private Button activeButton;
    private Button historyButton;
    private Button gpaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        activeButton = (Button) findViewById(R.id.activeReg);
        activeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActiveReg();
            }
        });
        historyButton = (Button) findViewById(R.id.regHistory);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegHistory();
            }
        });
        gpaButton = (Button) findViewById(R.id.gpa);
        gpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGPA();
            }
        });
    }

    public void openActiveReg()
    {
        Intent intent = new Intent(this, com.example.registrationactivity.ActiveRegistration.class);
        startActivity(intent);
    }

    public void openRegHistory()
    {
        Intent intent = new Intent(this, com.example.registrationactivity.RegistrationHistory.class);
        startActivity(intent);
    }

    public void openGPA()
    {
        Intent intent = new Intent(this, com.example.registrationactivity.GPA.class);
        startActivity(intent);
    }
}