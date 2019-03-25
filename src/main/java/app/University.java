package app;

import entities.*;
import java.util.ArrayList;
import java.util.List;

public class University {
    private List<UniversityCourse> UniversityCourses;
    private List<StudentEnrollment> EnrolledStudents;
    private List<Student> Students= new ArrayList<Student>();
    private List<Course> Courses= new ArrayList<Course>();

    public Course createCourse(String name, CourseYear year) {
        Course newCourse = new Course(name, year);
        addCourse(newCourse);
        return newCourse;
    }

    public Student createStudent(String name, String address) {
        Student newStudent = new Student(name, address);
       	addStudent(newStudent);
        return newStudent;
    }
    public Boolean addCourse(Course course){
    	return Courses.add(course);

    }
    public Boolean addStudent(Student student){
    	return Students.add(student);
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
	
	
        /*if() { //no delayed courses
            st.resetWarnings();
        }
        else if() { //between 1 and 4 delayed courses

        }
        else {

        }
*/
        return result;
    }
}
