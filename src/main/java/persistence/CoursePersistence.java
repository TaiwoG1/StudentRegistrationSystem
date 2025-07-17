package persistence;

import java.util.List;
import objects.Course;

public interface CoursePersistence {

    List<Course> getCourseSequential();

    //List<Course> getCourseRandom(Course currentCourse);
    Course getCourseById(String courseInfo);

    Course insertCourse(Course currentCourse);

    Course updateCourse(Course currentCourse);

    void deleteCourse(Course currentCourse);

    //int addCourse(Course newCourse);

    //int dropCourse(Course newCourse);

    //void printCourseInfo();

    //String getCourseInfo();

    //void printClassList();

}
