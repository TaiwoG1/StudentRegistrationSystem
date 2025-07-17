package persistence.stub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.Course;
import persistence.CoursePersistence;

import objects.*;
import persistence.*;

public class StudentPersistenceStub implements StudentPersistence{
    //Student st;
    private final Map<String, Student> studentMap;

    public StudentPersistenceStub(Student... students) {
        studentMap = new HashMap<>();
        for (Student student : students) {
            studentMap.put(student.getFirstName(), student);
        }
        Student student1;
    }

    public StudentPersistenceStub() {
        //st = new Student("Joe", "Burrow");
        this(
                new Student("Joe", "Burrow") { }
        );
    }

    //public Student getStudent()
    //{
    //    return st;
   // }

    public List<Student> getStudentSequential() {
        return Collections.unmodifiableList(new ArrayList<>(studentMap.values()));
    }

    public Student getStudentById(String studentInfo) {
        assert studentInfo != null;
        return studentMap.get(studentInfo);
    }

    public Student insertStudent(final Student student) {
        studentMap.put(student.getFirstName(), student);
        return student;
    }

    public Student updateStudent(final Student student) {
        if (!studentMap.containsKey(student.getFirstName())) {
            studentMap.put(student.getFirstName(), student);
        }
        return student;
    }

        public void deleteStudent(Student student) {
        studentMap.remove(student.getFirstName());
    }
}
