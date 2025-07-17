package business;



import java.util.List;

import application.Services;
import objects.Course;
import objects.Student;
import persistence.CoursePersistence;
import persistence.stub.StudentPersistenceStub;

import static business.AccessStudent.sps;

public class AccessCourse {

    private CoursePersistence coursePersistence;
    private List<Course> courses;
    private Course course;
    private int currentCourse;
    private Student student;
    //public static StudentPersistenceStub sps;

    public AccessCourse()
    {
        coursePersistence = Services.getCoursePersistence();
        courses = null;
        course = null;
        currentCourse = 0;
        //sps = new StudentPersistenceStub();
        AccessStudent ass = new AccessStudent();
        student = ass.getStudentSequential().get(0);
    }

    public AccessCourse(final CoursePersistence coursePersistence) {
        this();
        this.coursePersistence = coursePersistence;
    }


    public int addCourse(Course newCourse) {
        int returnValue = 0;
        int i = 0;
        boolean found = false;
        boolean alreadyPresent = false;

        //pre-condition
        //check if student is not already registered in the course
        for (int j = 0; j < student.getNumOfCourses(); j++){
            if (student.getCourseList()[j].getCourseCode() == newCourse.getCourseCode()){
                alreadyPresent = true;
                returnValue = 2;
                System.out.println(student.getName() + " already in course " + newCourse.getCourseCode());
            }
        }
        //check if student has not already taken the course previously
        for (int j = 0; j < student.getTotalCourseCompleted(); j++){
            if (student.getCompletedList()[j].getCourseCode() == newCourse.getCourseCode()){
                alreadyPresent = true;
                returnValue = 3;
                System.out.println(student.getName() + "has already taken course " + newCourse.getCourseCode());
            }
        }

        //if student isn't in the course, check if there is enough room in the class for new student
        if ((!alreadyPresent) && newCourse.getNumOfStudent() < newCourse.getCapacity())   //if there is enough room
        {
            //extra code to check for completed prerequisites for next update
            /*=====
            while (i < student.getTotalCourseCompleted() && !found)
            {
                //if pre-requisite has been completed, add new student to the course
                //here, if the student has previously taken the prerequisite, they
                //will get added to the course
                if (newCourse.getPrereq().getCourseCode() == student.getCompletedList()[i].getCourseCode()){
                    found = true;
                    newCourse.getClassList()[(newCourse.getNumOfStudent())] = student;   //add student to the class
                    student.getCourseList()[student.getNumOfCourses()] = newCourse;   //add the new course to student's course list
                    student.numOfCourses++;

                    returnValue = 1;
                    System.out.println(student.getName() + " successfully added to course " + newCourse.getCourseCode());
                }
                i++;
            }
            =====
            ////==========NOTE TO SELF: THIS SHOWULD BE JOINED TO CODE ABOVE
            //here, if there is no prerequisite, the student gets added to the course
            if (newCourse.getPrereq() == null){
                found = true;
                newCourse.getClassList()[newCourse.getNumOfStudent()] = student;   //add student to the class
                student.getCourseList()[student.getNumOfCourses()] = newCourse;   //add the new course to student's course list
                student.numOfCourses++;
                returnValue = 1;
                System.out.println(student.getName() + " successfully added to course " + newCourse.getCourseCode());
            }

            if (!found) {
                //not successful, student has not completed the prerequisite
                returnValue = 4;
                System.out.println("Cannot add " + student.getName() + " to course " + newCourse.getCourseCode() +", pre-requisite not completed");
            }

            */

            found = true;
            newCourse.getClassList()[newCourse.getNumOfStudent()] = student;   //add student to the class
            student.getCourseList()[student.getNumOfCourses()] = newCourse;   //add the new course to student's course list
            student.numOfCourses++;
            returnValue = 1;
            System.out.println(student.getName() + " successfully added to course " + newCourse.getCourseCode());


        }
        else if (newCourse.getNumOfStudent() == newCourse.getCapacity()){
            returnValue = 5;
            System.out.println("Cannot add " + student.getName() + " to course " + newCourse.getCourseCode() +", Class is at full capacity");
        }
        return returnValue;
    }


    public int dropCourse(Course newCourse) {
        int returnValue = 0;
        int i;
        int position = -1;
        int studentPos = -1;
        boolean present = false;
        boolean found = false;

        //pre-condition
        //check if student is not already registered in the course
        for (int j = 0; j < student.getNumOfCourses(); j++){
            if (student.getCourseList()[j].getCourseCode() == newCourse.getCourseCode()){
                present = true;
                position = j;
            }
        }
        //remove course from the student course List and shift other courses
        if (present){
            i = position;
            student.getCourseList()[i] = null;
            while (i < (student.getNumOfCourses() - 1))
            {
                //shift all other courses one space backwards
                student.getCourseList()[i] = student.getCourseList()[i+1];
                i++;
            }
            //remove last course
            student.getCourseList()[i] = null;
            student.numOfCourses--;

            //remove student from the class
            for (int k = 0; k < newCourse.getNumOfStudent(); k++)
            {
                if (newCourse.getClassList()[k].getId() == student.getId())
                {
                    found = true;
                    studentPos = k;
                }
            }

            //remove student from class List and shift other students
            if (found)
            {
                i = studentPos;
                Student[] allStudents = newCourse.getClassList();
                allStudents[i] = null;
                //shift other students
                while (i < (newCourse.getNumOfStudent() - 1))
                {
                    //shift all other courses one space backwards
                    allStudents[i] = allStudents[i+1];
                    i++;
                }
                //remove last course
                allStudents[i] = null;
                newCourse.setNumOfStudent((newCourse.getNumOfStudent())-1);
            }
            returnValue = 1;
        }

        if (!present) {
            //not successful, student has not completed the prerequisite
            returnValue = 2;
            System.out.println("Cannot drop course, not currently registered for Course " + newCourse.getCourseCode());
        }
        else if (present) {
            System.out.println(student.getName() + " has successfully dropped Course " + newCourse.getCourseCode());
        }
        return returnValue;
    }



    public List<Course> getCourseSequential() {
        return coursePersistence.getCourseSequential();
    }
}
