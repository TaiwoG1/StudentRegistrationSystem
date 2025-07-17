package objects;


public class Instructor extends User {
    //class variables
    protected int courseCap = 5;
    protected Course[] courseList = new Course[courseCap];
    protected int numCourse = 0;
    private String password;

    //constructor
    public Instructor(String firstName, String lastName) {
        name = firstName + " " + lastName;
        email = firstName + lastName;
        id = staffIdCount++;
        type = this;
        stringType = "Instructor";
        address = "null";
        phone = 0000000000;
        //this.password = "Asdf";
    }

    public int getCourseCap() {
        return courseCap;
    }

    public Course[] getCourseList() {
        return courseList;
    }

    public int getNumCourse() {
        return numCourse;
    }

}

/*
    //business/logic layer
    public void printCourseList() {
        System.out.println(this.name + " is currently teaching the following courses:");
        for (int i = 0; i < numCourse; i++){
            courseList[i].printCourseInfo();
        }
    }
    public int addCourse(Course newCourse) {
        int returnValue = 1;
        //pre-condition
        newCourse.setInstructor(this);
        return returnValue;
    }
*/
