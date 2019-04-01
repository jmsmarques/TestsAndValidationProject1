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
    private String name;
    private int max;
    private Set<Course> courses;
    private String[][] depMatrix= new String[50][4]; 
    
    public UniversityCourse(String name, Course course, int max) throws InvalidOperationException {
        this.max = max;
        this.name=name;
        courses = new HashSet<Course>();
        courses.add(course);
        depMatrix[courses.size()][0]=name;
        /*
            Operations held by hashsets:
                - .add()
                - .contains()
                - Iterator<String> i = h.iterator(); 
                        while (i.hasNext()) 
        */
    }
    /**
     * Adds c1 to the list of courses of this university course. If c2 is a valid course then
     * it is set as a precedence of c1. If c2 is null then c1 is added without any precedence.*
     */
    public void addCourse(Course c1, Course c2) throws InvalidOperationException { 
        if(c2 == null) {
            courses.add(c1);
            depMatrix[courses.size()][0]=c1.getName();
            System.out.println("[X]Added to depMatrix["+courses.size()+"]["+0+"]");
        }
        else if(courses.contains(c2)) { //c2 is valid
            //Create dependency 
            // Matrix
            courses.add(c1);
            depMatrix[courses.size()][0]=c1.getName();
            System.out.println("[X]Added to depMatrix["+courses.size()+"]["+0+"]");
            depMatrix[courses.size()][1]=c2.getName();
            System.out.println("[X]Added to depMatrix["+courses.size()+"]["+1+"]");




            //Touple???

            
        }
        else {
            throw new InvalidOpenTypeException();
        }
     }

    // Removes a course from the list of courses of this university course.
    public int removeCourse(Course c) throws InvalidOperationException { 

        if(courses.contains(c)) {
            courses.remove(c);
            for(int i=0; i< 50;i++){
                if(depMatrix[i][0].equals(c.getName())){
                    System.out.println("Course "+c.getName()+" removed from "+this.name+"!");

                    depMatrix[i][0]=null;
                    depMatrix[i][1]=null;
                    depMatrix[i][2]=null;
                    depMatrix[i][3]=null;
                }else{
                    for(int j=1;j<4;j++){
                        if(depMatrix[i][j].equals(c.getName())){
                            depMatrix[i][j]=null;
                            System.out.println("Course "+c.getName()+" removed from dependencie of "+depMatrix[i][0]+"!");
                        }
                    }
                }

            }


        }else{
            throw new InvalidOpenTypeException();
        }
        return 1;
     }

    // Adds a precedence between c1 and c2, meaning that c1 must precede c2.
    public void addPrecedence(Course c1, Course c2) throws InvalidOperationException {
        if(courses.contains(c1) && courses.contains(c2)){        
            for(int i=0;i<50;i++) {
                if(depMatrix[i][0].equals(c1.getName())){
                    for(int j=1;j<4;j++){
                        if(depMatrix[i][j]==null){
                            depMatrix[i][j]=c2.getName();
                            System.out.println("[X] precedence added to depMatrix["+i+"]["+j+"]");
                            return;
                        }
                    }
                }
            }
        }
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
    public String getName(){
        return name;
    }

}