package persistence;

import java.util.List;
import objects.Student;

public interface StudentPersistence {


    List<Student> getStudentSequential();

    Student getStudentById(final String studentInfo);

    Student insertStudent(final Student currentStudent);

    Student updateStudent(final Student currentStudent);

    void deleteStudent(final Student currentStudent);
    /*
    void printUserInfo();

    String getTranscript();

    void printCourseList();

    void printCompletedCourseList();
    */
}
