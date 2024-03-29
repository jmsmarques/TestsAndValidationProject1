package app;

import entities.*;
import exceptions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.openmbean.InvalidOpenTypeException;

public class UniversityCourse {
    /**
     * Creates a university course with a single course (represented by parameter
     * course)* and whose maximum number of courses is specified by parameter max.
     **/
    private int max;
    private Set<Course> courses;
    
    public UniversityCourse(String name, Course course, int max) throws InvalidOperationException {
    }
    /**
     * Adds c1 to the list of courses of this university course. If c2 is a valid course then
     * it is set as a precedence of c1. If c2 is null then c1 is added without any precedence.*
     */
    public void addCourse(Course c1, Course c2) throws InvalidOperationException { 
    }

    // Removes a course from the list of courses of this university course.
    public int removeCourse(Course c) throws InvalidOperationException { 
        return 1;
    }

    // Adds a precedence between c1 and c2, meaning that c1 must precede c2.
    public void addPrecedence(Course c1, Course c2) throws InvalidOperationException {
    }

    // Removes precedence between c1 and c2. If c1 does not precede c2 then it does nothing.
    // Returns true if the precedence was removed, false otherwise.
    public boolean removePrecedence(Course c1, Course c2) { 
        return false;
    }

    // Returns the set of courses of this university course
    public Set<Course> getCourses() { 
        return courses;
     }

    // Returns the maximum number of courses for this university course
    public int getMaximumNumberOfCourses() { 
        return max; 
    }

    // Returns the number of courses of this university course
    public int getNumberOfCourses() { 
        return courses.size(); 
    }
}