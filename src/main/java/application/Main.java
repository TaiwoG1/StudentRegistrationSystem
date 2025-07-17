package application;

import com.example.registrationactivity.*;

import business.AccessCourse;
import objects.Course;
import objects.Instructor;
import objects.Student;

//import com.example.registrationactivity.CLI;

public class Main
{
    private static String dbName="sc";

    public static void main(String[] args)
    {
        //CLI.run();
        System.out.println("All done");
    }


    public static void setDBPathName(final String name) {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dbName = name;
    }

    public static String getDBPathName() {
        return dbName;
    }

}


