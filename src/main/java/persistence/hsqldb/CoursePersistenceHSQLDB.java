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
import objects.Instructor;
import persistence.CoursePersistence;


public class CoursePersistenceHSQLDB implements CoursePersistence{
    private final String dbPath;

    public CoursePersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Course fromResultSet(final ResultSet rs) throws SQLException {
        final String courseName = rs.getString("courseName");
        final int courseCode = rs.getInt("courseCode");
        //final String courseInstructor = rs.getString("courseInst");
        final int courseCapacity = rs.getInt("courseCap");
        //final String coursePrereq = rs.getString("coursePr");
        final int courseTime = rs.getInt("courseTime");
        final int courseCreditHour = rs.getInt("courseCHr");
        return new Course(courseName, courseCode, courseCapacity, courseTime, courseCreditHour);
    }


    @Override
    public List<Course> getCourseSequential() {
        final List<Course> courses = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM courses");
            while (rs.next())
            {
                final Course course = fromResultSet(rs);
                courses.add(course);
            }
            rs.close();
            st.close();

            return courses;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Course getCourseById(String courseInfo) {

        Course currentCourse = null;
        try (final Connection c = connection()) {    // what is c??
            final PreparedStatement st = c.prepareStatement("SELECT courseName, courseCode, courseInstructor, courseCapacity, coursePrerequisite, courseTime, courseCreditHour FROM courses WHERE courseCode = ?");
            st.setString(1, courseInfo);
            final ResultSet rs = st.executeQuery();
            String a = rs.toString();

            if (rs.next()) {
                final String courseName = rs.getString("courseName");
                final int courseCode = rs.getInt("courseCode");
                //final String courseInstructor = rs.getString("courseInst");
                final int courseCapacity = rs.getInt("courseCap");
                //final String coursePrereq = rs.getString("coursePr");
                final int courseTime = rs.getInt("courseTime");
                final int courseCreditHour = rs.getInt("courseCHr");
                currentCourse = new Course(courseName, courseCode, courseCapacity, courseTime, courseCreditHour);
            }
            return currentCourse;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Course insertCourse(Course currentCourse) {

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO COURSES VALUES(?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, currentCourse.getCourseName());
            st.setInt(2, currentCourse.getCourseCode());

            st.setInt(3, currentCourse.getCapacity());
            st.setInt(4, currentCourse.getTime());
            st.setInt(5, currentCourse.getCreditHour());

            st.executeUpdate();

            return currentCourse;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Course updateCourse(Course currentCourse) {

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE courses SELECT courseName = ?, courseCode = ?, courseInstructor = ?, courseCapacity = ?, coursePrerequisite = ?, courseTime = ?, courseCreditHour = ? FROM courses WHERE courseCode = ? WHERE courseCode = ?");
            st.setString(1, currentCourse.getCourseName());
            st.setInt(2, currentCourse.getCourseCode());
            st.setInt(3, currentCourse.getCapacity());
            st.setInt(4, currentCourse.getTime());
            st.setInt(5, currentCourse.getCreditHour());

            st.executeUpdate();

            return currentCourse;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void deleteCourse(Course currentCourse) {

        try (final Connection c = connection()) {
            //final PreparedStatement sc = c.prepareStatement("DELETE FROM students courses WHERE courseID = ?");
            //sc.setString(1, currentCourse.getCourseCode()+"");
            //sc.executeUpdate();
            final PreparedStatement st = c.prepareStatement("DELETE FROM courses WHERE courseID = ?");
            st.setString(1, currentCourse.getCourseCode()+"");
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }





}
