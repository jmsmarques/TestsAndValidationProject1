package app;

import entities.*;
import java.util.ArrayList;
import java.util.List;

public class University {
    private List<UniversityCourse> universityCourses= new ArrayList<UniversityCourse>();;
    private List<StudentEnrollment> enrolledStudents;
    private List<Student> students= new ArrayList<Student>();
    private List<Course> courses= new ArrayList<Course>();

    public Course createCourse(String name, CourseYear year) {   
        return null;
    }

    public Student createStudent(String name, String address) {
        return null;
    }

    /***
     * Computes the tuition fees that the given student must pay. This value depends
     * on several factors: Number* of courses enrolled by the first time, number of
     * courses enrolled that the student has already* tried to do but has not
     * succeeded yet, total number of enrollments made on those courses* and number
     * of warnings received by the student.
     **/

     /*
    Fee Depends on:
		-first time courses
		-delayed courses
		-total number of enrollments in delayed courses
		-number of warnings
	
	Warning Depends on:	
		-number of delayed courses
		-number of enrollments in delayed courses

	Suspended with 3 warnings

	*/
    public int computeTuitionFees(Student st, List<Course> courses) {
        int result = 0;
        return result;
    }
}
