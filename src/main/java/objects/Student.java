package objects;

public class Student extends User {

    //class variables
    public String fName;
    public String lName;
    public Course[] courseList = new Course[7];
    public Course[] completedList = new Course[100];
    public int totalCourseCompleted;
    public int numOfCourses;
    private String password;

    //constructor
    public Student(String firstName, String lastName) {
        name = firstName + " " + lastName;
        email = firstName + lastName;
        fName = firstName;
        lName = lastName;
        id = count;
        count++;
        type = this;
        stringType = "Student";
        numOfCourses = 0;
        totalCourseCompleted = 0;
        address = "null";
        phone = 0000000000;
        this.password = "Asdf";
    }

    public Course[] getCourseList()
    {
        return courseList;
    }

    public Course[] getCompletedList() {
        return completedList;
    }

    public int getTotalCourseCompleted() {
        return totalCourseCompleted;
    }

    public int getNumOfCourses() {
        return numOfCourses;
    }

    public String getFirstName()
    {
        return fName;
    }

    public String getLastName()
    {
        return lName;
    }
}


/*



    //business/logic layer
    public String getTranscript(){
        String transcript = "";
        for (int j = 0; j < this.numOfCourses; j++){
            //courseList[j].printCourseInfo();
            //System.out.println("Grade - IP, Total Credit Hours - " + courseList[j].getCreditHour());
            transcript += courseList[j].getCourseInfo();
            transcript += ", " + "Total Credit Hours - " + courseList[j].getCreditHour() + ", Grade - \"IP\"\n";
        }
        for (int j = 0; j < this.totalCourseCompleted; j++){
            //System.out.println(
            //completedList[j].printCourseInfo();
            //System.out.println("Grade - IP, Total Credit Hours - " + completedList[j].getCreditHour());
            transcript += completedList[j].getCourseInfo();
            transcript += ", " + "Total Credit Hours - " + completedList[j].getCreditHour() + ", Grade - \"F\"\n";
        }
        return transcript;
    }

    public void printCourseList() {
        System.out.println(this.name + " is currently enrolled in the following courses:");
        for (int i = 0; i < numOfCourses; i++){
            courseList[i].printCourseInfo();
        }
    }

    public void printCompletedCourseList() {
        System.out.println(this.name + " has completed the following courses:");
        for (int i = 0; i < numOfCourses; i++){
            completedList[i].printCourseInfo();
        }
    }

    public int addCourse(Course newCourse) {
        int returnValue = 0;
        int i = 0;
        boolean found = false;
        boolean alreadyPresent = false;

        //pre-condition
        //check if student is not already registered in the course
        for (int j = 0; j < this.numOfCourses; j++){
            if (courseList[j].getCourseCode() == newCourse.getCourseCode()){
                alreadyPresent = true;
                System.out.println(this.getName() + " already in course " + newCourse.getCourseCode());
            }
        }
        //check if student has not already taken the course previously
        for (int j = 0; j < this.totalCourseCompleted; j++){
            if (completedList[j].getCourseCode() == newCourse.getCourseCode()){
                alreadyPresent = true;
                System.out.println(this.getName() + "has already taken course " + newCourse.getCourseCode());
            }
        }

        //if student isnt in the course, check if there is enough room in the class for new student
        if ((!alreadyPresent) && newCourse.numStudent < newCourse.capacity)   //if there is enough room
        {
            while (i < this.totalCourseCompleted && !found)
            {
                //if pre-requisite has been completed, add new student to the course
                //System.out.println("=="+i+" should less than " + this.totalCourseCompleted);
                //here, if the student has previously taken the prerequisite, they
                //will get added to the course
                if (newCourse.prereq.name.equals(this.completedList[i].name)){
                    found = true;
                    newCourse.classList[newCourse.numStudent++] = this;   //add student to the class
                    courseList[numOfCourses] = newCourse;   //add the new course to student's course list
                    numOfCourses++;
                    returnValue = 1;
                    System.out.println(this.getName() + " successfully added to course " + newCourse.getCourseCode());
                }
                i++;
            }
            //here, if there is no prerequisite, the student gets added to the course
            if (newCourse.prereq == null){
                found = true;
                newCourse.classList[newCourse.numStudent++] = this;   //add student to the class
                courseList[numOfCourses] = newCourse;   //add the new course to student's course list
                numOfCourses++;
                returnValue = 1;
                System.out.println(this.getName() + " successfully added to course " + newCourse.getCourseCode());
            }
            if (!found) {
                //not successful, student has not completed the prerequisite
                System.out.println("Cannot add " + this.getName() + " to course " + newCourse.getCourseCode() +", pre-requisite not completed");
            }
        }
        else if (newCourse.getNumOfStudent() == newCourse.getCapacity()){
            System.out.println("Cannot add " + this.getName() + " to course " + newCourse.getCourseCode() +", Class is at full capacity");
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
        for (int j = 0; j < this.numOfCourses; j++){
            if (courseList[j].getCourseCode() == newCourse.getCourseCode()){
                present = true;
                position = j;
            }
        }
        //remove course from the student course List and shift other courses
        if (present){
            i = position;
            courseList[i] = null;
            while (i < (this.numOfCourses - 1))
            {
                //shift all other courses one space backwards
                courseList[i] = courseList[i+1];
                i++;
            }
            //remove last course
            courseList[i] = null;
            numOfCourses--;

            //remove student from the class
            for (int k = 0; k < newCourse.getNumOfStudent(); k++)
            {
                if (newCourse.getClassList()[k].getId() == this.getId())
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
            System.out.println("Cannot drop course, not currently registered for Course " + newCourse.getCourseCode());
        }
        else if (present) {
            System.out.println(this.getName() + " has successfully dropped Course " + newCourse.getCourseCode());
        }
        return returnValue;
    }*/