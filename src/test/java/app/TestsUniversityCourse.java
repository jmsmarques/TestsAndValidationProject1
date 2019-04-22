package app;

import org.testng.Assert;
import org.testng.annotations.*;
import entities.*;
import exceptions.InvalidOperationException;

public class TestsUniversityCourse extends Assert{
    private Course aux;
    private UniversityCourse uniCourse;
    
    @DataProvider
    private Object[][] constructorInputs() {
        return new Object[][] {
            {null, 20},
            {null, 51},
            {new Course("name", CourseYear.FIRST), 51},
            {new Course("name", CourseYear.FIRST), 0}
        };
    }

    @DataProvider
    private Object[][] addRemoveInputs() {
        return new Object[][] {
            {new Course("name", CourseYear.FIRST), new Course("name", CourseYear.FIRST)}
        };
    }

    @BeforeClass
    public void createUniversityCourse() {
        try {
            uniCourse = new UniversityCourse("teste", aux, 20);
        } catch(InvalidOperationException e) {
        
        }
    }

    @Test(expectedExceptions = InvalidOperationException.class, dataProvider = "constructorInputs")
    public void testConstructor(Course aux, int maxCourses) throws InvalidOperationException {
        //max nr of courses cannot be bigget than 50
        UniversityCourse uniAux;

        uniAux = new UniversityCourse("teste", aux, maxCourses);
    }

    @Test(dataProvider = "addRemoveInputs")
    public void testAddCourse(Course c1, Course c2) {
        int nrCourses;
        nrCourses = uniCourse.getNumberOfCourses();

        //Act
        try {
            uniCourse.addCourse(c1, c2);
        } catch(InvalidOperationException e){

        }

        //Assert
        assertEquals(uniCourse.getNumberOfCourses(), nrCourses + 1, "Invalid nr of courses");
        assertTrue(uniCourse.getCourses().contains(c1), "Wrong item added");
    }

    @Test(dataProvider = "addRemoveInputs")
    public void testRemoveCourse(Course c1, Course c2) {
        int nrCourses;
        nrCourses = uniCourse.getNumberOfCourses();

        //Act
        try {
            uniCourse.removeCourse(c1);
        } catch(InvalidOperationException e){

        }

        //Assert
        assertEquals(uniCourse.getNumberOfCourses(), nrCourses - 1, "Invalid nr of courses");
        assertFalse(uniCourse.getCourses().contains(c1), "Wrong item removed");
    }

    @Test
    public void testAddPrecedence() {
        //the nr of precedences cannot be bigger than 3
        //the year of c1 must be lower than c2
    }

    @Test
    public void testRemovePrecedence() {

    }

    @Test(expectedExceptions = InvalidOperationException.class)
    public void testMaxNrCourses() throws InvalidOperationException{
        UniversityCourse uniAux;

        uniAux = new UniversityCourse("teste", new Course("name", CourseYear.FIRST), 1);

        uniAux.addCourse(new Course("na", CourseYear.FIRST), null);
    }

    @Test(expectedExceptions = InvalidOperationException.class)
    public void testCourseName(Course c1, Course c2) throws InvalidOperationException{
        UniversityCourse uniAux;

        uniAux = new UniversityCourse("teste", new Course("name", CourseYear.FIRST), 5);

        uniAux.addCourse(new Course("name", CourseYear.FIRST), null);
    }
}
