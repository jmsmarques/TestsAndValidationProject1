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
    	return courses.add(course);

    }
    public Boolean addStudent(Student student){
    	return students.add(student);
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
    }public boolean coursesEmpty(){
        if(courses.isEmpty()){
            return true;
        }else
            return false;
    }

    public void listCourses(){
        System.out.println("\nList of courses:");
        for(int i=0;i< courses.size();i++){
            System.out.println("---\tName: "+ courses.get(i).getName()+" \n\tYears: "+ courses.get(i).getYear().toString());
        }   
    }
    public Course findCourse(String name){
        Course courseAux=null;
        if(!courses.isEmpty()){
            for(int i=0;i< courses.size();i++){
                courseAux=courses.get(i);
                if(courseAux.getName().equals(name)){
                    return courseAux;
                }
            }   
        }
        return null;
    }
    public void listUniversityCourses(){
        System.out.println("\nList of University Courses:");
        for(int i=0;i< universityCourses.size();i++){
            System.out.println("---\tName: "+ universityCourses.get(i).getName());
        }   
    }
    public UniversityCourse findUniversityCourse(String name){
        UniversityCourse universityCourseAux=null;
        if(!universityCourses.isEmpty()){
            for(int i=0;i< universityCourses.size();i++){
                universityCourseAux=universityCourses.get(i);
                if(universityCourseAux.getName().equals(name)){
                    return universityCourseAux;
                }
            }   
        }
        return null;
    }

    public int removeUniversityCourse(String name){
        UniversityCourse universityCourseAux=findUniversityCourse(name);
        if(universityCourseAux!=null){
            universityCourses.remove(universityCourseAux);
            return 1;
        }else

        return 0;
    
    }
    public int removeCourse(String name){

        //Remove from every University Course, check dependencies 
        Course courseAux=findCourse(name);
        return 0;

    }
        
    
}
