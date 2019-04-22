package app;

import org.testng.Assert;
import org.testng.annotations.*;
import entities.*;
import exceptions.InvalidOperationException;

public class TestsUniversityCourse extends Assert{
    
    @DataProvider
    private Object[][] constructorInputs() {
        return new Object[][] {
            {null, 20},
            {new Course("name", CourseYear.FIRST), 51},
            {new Course("name", CourseYear.FIRST), 0},
            {new Course("name", CourseYear.FOURTH), 50}
        };
    }

    @Test()
    public void testConstructor() {
        try {
            UniversityCourse uniAux = new UniversityCourse("teste", new Course("name", CourseYear.FIRST), 1);
        } catch (InvalidOperationException e) {
            fail("Threw exception when it shouldn't");
        }
    }

    @Test(expectedExceptions = InvalidOperationException.class, dataProvider = "constructorInputs")
    public void testInvalidConstructor(Course aux, int maxCourses) throws InvalidOperationException {
        UniversityCourse uniAux = new UniversityCourse("teste", aux, maxCourses);
    }

    @Test(expectedExceptions = InvalidOperationException.class)
    public void testMaxNrCourses() throws InvalidOperationException{
        UniversityCourse uniAux;

        uniAux = new UniversityCourse("teste", new Course("name", CourseYear.FIRST), 1);

        uniAux.addCourse(new Course("na", CourseYear.FIRST), null);
    }

    @Test(expectedExceptions = InvalidOperationException.class)
    public void testCourseName(Course c1, Course c2) throws InvalidOperationException{ //testing repeated names
        UniversityCourse uniAux;

        uniAux = new UniversityCourse("teste", new Course("name", CourseYear.FIRST), 5);

        uniAux.addCourse(new Course("name", CourseYear.FIRST), null);
    }
}
