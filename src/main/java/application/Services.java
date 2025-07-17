package application;

import persistence.CoursePersistence;
import persistence.StudentPersistence;
import persistence.*;
import persistence.hsqldb.CoursePersistenceHSQLDB;
import persistence.stub.CoursePersistenceStub;
import persistence.stub.StudentPersistenceStub;


public class Services
{
    private static StudentPersistence studentPersistence = null;
    private static CoursePersistence coursePersistence = null;
    private static SCPersistence scPersistence = null;

    public static synchronized CoursePersistence getCoursePersistence()
    {
        if (coursePersistence == null)
        {
            coursePersistence = new CoursePersistenceHSQLDB(Main.getDBPathName());
            //coursePersistence = new CoursePersistenceStub();
        }

        return coursePersistence;
    }

    public static synchronized StudentPersistence getStudentPersistence()
    {
        if (studentPersistence == null) {
            //studentPersistence = new StudentPersistenceHSQLDB(Main.getDBPathName());
            studentPersistence = new StudentPersistenceStub();
        }

        return studentPersistence;
    }

}

