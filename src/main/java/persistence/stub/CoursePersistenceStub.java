package persistence.stub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.*;
import persistence.*;

public class CoursePersistenceStub implements CoursePersistence {
    private final Map<String, Course> courseMap;

    public CoursePersistenceStub(Course... courses) {
        courseMap = new HashMap<>();
        for (Course course : courses) {
            courseMap.put(course.getCourseInfo(), course);
        }
    }

    public CoursePersistenceStub() {
        this(
                new Course("Software", 1000, 5, 3, 3) { },
                new Course("Programming", 2000, 100, 3, 3) { },
                new Course("Java", 3000, 100, 3, 3) { },
                new Course("Python", 4000, 100, 3, 3) { },
                new Course("Computer", 5000, 100, 3, 3) { }
        );
    }

    public List<Course> getCourseSequential() {
        return Collections.unmodifiableList(new ArrayList<>(courseMap.values()));
    }

    public Course getCourseById(String courseInfo) {
        assert courseInfo != null;
        return courseMap.get(courseInfo);
    }

    public Course insertCourse(final Course course) {
        courseMap.put(course.getCourseInfo(), course);
        return course;
    }

    public Course updateCourse(final Course course) {
        if (!courseMap.containsKey(course.getCourseInfo())) {
            courseMap.put(course.getCourseInfo(), course);
        }
        return course;
    }

    public void deleteCourse(Course course) {
        courseMap.remove(course.getCourseCode());
    }
}
