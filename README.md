<h1>Student Registration System (Android Application)</h1>


<h2>Description</h2>
Developed a comprehensive mobile application for student academic management. This Android-based system provides students with a user-friendly interface to manage their academic journey, from course selection to financial oversight.
<br />
<br />
<h2>Key Features:</h2>

- <b2> Course Management: View available courses, register for new classes, and add/drop courses. </b2>
- <b2> Academic Progress: Access GPA and review complete course history. </b2>
- <b2> Financial Overview: View financial aid details and scholarship information. </b2>
<br />


<h2>Project Directory Structure:</h2>
The project follows a modular, layered architecture to adhere to standard software engineering principles, promoting maintainability and separation of concerns.
<br/>
<br/>

- <b2> src/main/: The core source directory for the application. </b2>
  - <b2> assets/: Contains the db folder with the sc.script file, which is used to initialize the application's database. </b2>
  - <b2> java/: This is the application's main codebase, organized into the following layers: </b2>
    - <b2> application/: Houses core application logic, including the main entry point (main) and other service-level classes. </b2>
    - <b2> business/: The business logic layer. This contains classes like AccessCourse and AccessStudent, which manage the application's core functions and rules, such as adding, dropping, and looking up courses. </b2>  
    - <b2> objects/: The data objects layer. This contains Java Objects like Course, Student, and User, which represent the data structures used throughout the application. </b2>
    - <b2> persistence/: The data persistence layer. This includes the hsqldb and stub folders, as well as classes like CoursePersistence and StudentPersistence, which are responsible for handling the storage and retrieval of data from the database. </b2>
    - <b2> presentation/: The user interface layer. This contains the Android Activity files (MainActivity, RegistrationHistory etc..) that manage the application's views and user interactions. </b2>
  - <b2> res/: Contains application resources such as images (drawable), layouts (layout), and other values (values). </b2>
  - <b2> AndroidManifest.xml: The manifest file that describes the application's components and permissions. </b2>

This structure ensures that changes to one layer do not require changes to other layers, making the system more robust and scalable.
<br />
<br />

<h2>Tools Used:</h2>

- <b2> Java: Primary programming language for backend logic and Android development. </b2>
- <b2> Android Studio: Integrated Development Environment (IDE) for building the mobile application. </b2>
- <b2> Database Used, MSQLDB: For persistent storage of student and course data. </b2>
<br/>

<h2>Conclusion:</h2>
This project demonstrates my proficiency in Java and Android development, showcasing my ability to design and implement a robust, feature-rich mobile application. It highlights my skills in database integration, user interface design, and developing practical solutions for complex data management.
</br>
