package app;

import entities.*;
import exceptions.*;
import java.util.ArrayList;
import java.util.List;

public class StudentEnrollment {
    public enum EnrollmentMode { NOT_ENROLLED, IN_ENROLLMENT, ENROLLED, SUSPENDED; }
    private Student enrolledStudent;
    private EnrollmentMode status;
    private List<Course> enrolledCourses;

    //Creates a StudentEnrollment object in mode NOT_ENROLLED associated with the given student.
    public StudentEnrollment(Student st) { 
        enrolledStudent = st;
        status = EnrollmentMode.NOT_ENROLLED;
        enrolledCourses = new ArrayList<Course>();
     }
    
    //Changes the mode of this StudentEnrollment to IN_ENROLLMENT if the current
    //mode is NOT_ENROLLED. Otherwise, it throws InvalidInvocationException.
    void startEnrollment() throws InvalidInvocationException { 
        if(status.equals(EnrollmentMode.NOT_ENROLLED)) {
            status = EnrollmentMode.IN_ENROLLMENT;
        }
        else {
            throw new InvalidInvocationException();
        }
    }

    //Enrolls in the given course if the current mode is IN_ENROLLMENT. If the mode
    //is not this one, then it throws InvalidInvocationException.
    void enrollInCourse(Course c) throws InvalidInvocationException { 
        if(status.equals(EnrollmentMode.IN_ENROLLMENT)) {
            enrolledCourses.add(c);
        }
        else {
            throw new InvalidInvocationException();
        }
     }

    //Cancels the enrollment in the given course if the mode is IN_ENROLLMENT. If student is not enrolled in the
    //course, then it does nothing. It throws InvalidInvocationException if the mode is not IN_ENROLLMENT.
    void cancelEnrollmentInCourse(Course c) throws InvalidInvocationException { 
        if(status.equals(EnrollmentMode.IN_ENROLLMENT)) {
            enrolledCourses.remove(c);
        }
        else {
            throw new InvalidInvocationException();
        }
    }
    
    //Ends the enrollment process, setting the mode of this StudentEnrollment to ENROLLED if its mode is IN_ENROLLMENT
    //and the student is enrolled in at least one course. Otherwise, it throws InvalidInvocationException.
    void finishEnrollment() throws InvalidInvocationException { 
        if(enrolledCourses.size() > 0 && status.equals(EnrollmentMode.IN_ENROLLMENT)) {
            status = EnrollmentMode.ENROLLED;
        }
        else {
            throw new InvalidInvocationException();
        }
    }

    //Set the final result of the course for this student (final grade/failed). If student is not enrolled in the
    //course, then this invocation is ignored. If mode is not ENROLLED, then it throws InvalidInvocationException.
    void setResult(Course c, Result r) throws InvalidInvocationException {  
        if(status.equals(EnrollmentMode.ENROLLED)) {
            if(enrolledCourses.contains(c)) {
                //set result
            }
        }
        else {
            throw new InvalidInvocationException();
        }
    }

    //Suspends this student. A suspended student cannot enroll in courses. A StudentEnrollment can be
    //suspended if its mode is NOT_ENROLLED or IN_ENROLLMENT. Otherwise, it throws InvalidInvocationException.
    void suspend() throws InvalidInvocationException { 
        if(status.equals(EnrollmentMode.NOT_ENROLLED) || status.equals(EnrollmentMode.IN_ENROLLMENT)) {
            status = EnrollmentMode.SUSPENDED;
        }
        else {
            throw new InvalidInvocationException();
        }
    }

    //Set the mode of this StudentEnrollment to NOT_ENROLLED. All information of the
    //current enrolled courses is cleared.
    public void cancel() throws InvalidInvocationException  { 
        enrolledCourses.clear();
        status = EnrollmentMode.NOT_ENROLLED;
     }

    //Returns the mode of this StudentEnrollment
    public EnrollmentMode getMode() { 
        return status;
    }

    //Returns the current set of enrolled courses of this StudentEnrollment. Throws InvalidInvocationException~
    //if mode of this StudentEnrollment is not IN_ENROLLMENT nor ENROLLED.
    public List<Course> getEnrolledCourses() throws InvalidInvocationException { 
        if(status.equals(EnrollmentMode.IN_ENROLLMENT) || status.equals(EnrollmentMode.ENROLLED)) {
            return enrolledCourses;
        }
        else {
            throw new InvalidInvocationException();
        }
    }
}

    