package com.example.registrationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import application.Main;
import business.AccessCourse;
import business.AccessStudent;
import objects.Course;

public class MainActivity extends AppCompatActivity {
    private LinearLayout but;
    private LinearLayout but2;
    public static AccessCourse ac;
    public static AccessStudent as;
    //public static StudentPersistenceStub sps; // = new StudentPersistenceStub();
    //public static AccessCourse ack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copyDatabaseToDevice();


        as = new AccessStudent();
        //ack = new AccessCourse();
        ac = new AccessCourse();
        //AccessCourse accessCourse = new AccessCourse();
        List<Course> cdb = ac.getCourseSequential();

        //sps = new StudentPersistenceStub();


        but = (LinearLayout) findViewById(R.id.registration);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                butOpen();
            }
        });

        but2 = (LinearLayout) findViewById(R.id.academic);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                but2Open();
            }
        });
    }

    public void butOpen()
    {
        Intent intent = new Intent(this, com.example.registrationactivity.MainActivity2.class);
        startActivity(intent);
    }

    public void but2Open()
    {
        Intent intent = new Intent(this, com.example.registrationactivity.MainActivity3.class);
        startActivity(intent);
    }

    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();
        try {
            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }
            copyAssetsToDirectory(assetNames, dataDirectory);
            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());
        } catch (final IOException ioe) {
            System.out.println("Unable to access application data: " + ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);
            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);
                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }
                out.close();
                in.close();
            }
        }
    }

}