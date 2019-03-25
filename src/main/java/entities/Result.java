package entities;
import java.util.List;

public class Result {

	private Course course=null;
	private List<Integer> values;
	private Boolean complete=false;

    public Result(Course course){
    	this.course=course;
    	
    }
    public Course getCourse(){
    	return course;
    }
    public void setCourse(Course course){
    	this.course=course;
    }
    
    public void addValue(int value){
    	values.add(value);
    	if(value>=10){ 
    		complete=true;
    	}	
    }

    public List<Integer> getValues(){
    	return values;
    }

}