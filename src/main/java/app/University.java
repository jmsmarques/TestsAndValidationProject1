package app;

import entities.*;
import java.util.List;

public class University {
    private List<UniversityCourse> UniversityCourses;
    private List<StudentEnrollment> EnrolledStudents;
    private List<Course> Courses;

    public Course createCourse(String name, CourseYear year) {
        Course newCourse = new Course(name, year);
        return newCourse;
    }

    public Student createStudent(String name, String address) {
        Student newStudent = new Student(name, address);
        return newStudent;
    }

    /***
     * Computes the tuition fees that the given student must pay. This value depends
     * on several factors: Number* of courses enrolled by the first time, number of
     * courses enrolled that the student has already* tried to do but has not
     * succeeded yet, total number of enrollments made on those courses* and number
     * of warnings received by the student.
     **/
    public int computeTuitionFees(Student st, List<Course> courses) {
        return 0;
    }
}
