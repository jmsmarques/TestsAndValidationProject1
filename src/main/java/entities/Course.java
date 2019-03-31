package entities;



public class Course {
    private String name;
    private CourseYear year;
    
    public Course(String name, CourseYear year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public CourseYear getYear() {
        return year;
    }
    public void print(){
        System.out.println("\n\tNome: "+name+"\n\tYear: "+ year);
    }

   
}