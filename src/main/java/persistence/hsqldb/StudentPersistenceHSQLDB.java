package persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import objects.Course;
import objects.Student;
import persistence.CoursePersistence;
import persistence.StudentPersistence;

public class StudentPersistenceHSQLDB implements StudentPersistence {

    private final String dbPath;

    public StudentPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Student fromResultSet(final ResultSet rs) throws SQLException {
        final String fName = rs.getString("firstName");
        final String lName = rs.getString("lastName");
        return new Student(fName, lName);
    }


    @Override
    public List<Student> getStudentSequential() {
        final List<Student> students = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next())
            {
                final Student student = fromResultSet(rs);
                students.add(student);
            }
            rs.close();
            st.close();

            return students;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Student getStudentById(String studentInfo) {

        Student currentStudent = null;
        try (final Connection c = connection()) {    // what is c??
            final PreparedStatement st = c.prepareStatement("SELECT firstName, lastName FROM students WHERE firstName = ?");
            st.setString(1, studentInfo);
            final ResultSet rs = st.executeQuery();
            String a = rs.toString();

            if (rs.next()) {
                final String fName = rs.getString("firstName");
                final String lName = rs.getString("lastName");
                currentStudent = new Student(fName, lName);
            }
            return currentStudent;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Student insertStudent(Student currentStudent) {

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO STUDENTS VALUES(?, ?)");
            st.setString(1, currentStudent.getFirstName());
            st.setString(2, currentStudent.getLastName());

            st.executeUpdate();

            return currentStudent;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Student updateStudent(Student currentStudent) {

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE students SELECT firstName = ?, lastName = ? FROM students WHERE firstName = ? WHERE firstName = ?");
            st.setString(1, currentStudent.getFirstName());
            st.setString(2, currentStudent.getLastName());

            st.executeUpdate();

            return currentStudent;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void deleteStudent(Student currentStudent) {

        try (final Connection c = connection()) {
            //final PreparedStatement sc = c.prepareStatement("DELETE FROM students courses WHERE courseID = ?");
            //sc.setString(1, currentCourse.getCourseCode()+"");
            //sc.executeUpdate();
            final PreparedStatement st = c.prepareStatement("DELETE FROM students WHERE firstName = ?");
            st.setString(1, currentStudent.getFirstName());
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }





}
