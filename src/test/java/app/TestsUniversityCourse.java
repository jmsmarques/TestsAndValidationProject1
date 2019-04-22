package app;

import org.testng.Assert;
import org.testng.annotations.*;
import entities.*;
import exceptions.InvalidOperationException;

public class TestsUniversityCourse extends Assert{
    
    @DataProvider
    private Object[][] constructorInputs() {
        return new Object[][] {
            {null, 39, 15},
            {new Course("name", CourseYear.FIRST), 0, 0},            
            {new Course("name", CourseYear.FIRST), 51, 49}                        
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
    public void testInvalidConstructor(Course aux, int maxCourses, int nrOfCourses) throws InvalidOperationException {
        UniversityCourse uniAux = new UniversityCourse("teste", aux, maxCourses);
        int auxNr = 1;

        int i = uniAux.getMaximumNumberOfCourses();
        while(i < nrOfCourses) {
            uniAux.addCourse(new Course(Integer.toString(auxNr), CourseYear.FOURTH), null);
            i = uniAux.getMaximumNumberOfCourses();
            auxNr++;
        }
    }

    @Test
    public void testValidConstructor() throws InvalidOperationException {
        int nrOfCourses = 27;
        int aux = 1;
        UniversityCourse uniAux = new UniversityCourse("teste", new Course("name", CourseYear.FOURTH), 50);

        int i = uniAux.getMaximumNumberOfCourses();
        try {
            while(i < nrOfCourses) {
                uniAux.addCourse(new Course(Integer.toString(aux), CourseYear.FOURTH), null);
                i = uniAux.getMaximumNumberOfCourses();
                aux++;
            }
        } catch(InvalidOperationException e) {
            fail("Exception thrown when it shouldn't\n");
        }
    }
}
