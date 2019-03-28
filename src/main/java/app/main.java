package app;
import java.util.Scanner;
import entities.*;
////////////
public class main{
	public static void main(String[] args){
		

		System.out.println( "      ___                                 ");
		System.out.println ("     /\\__\\                        ___     ");
		System.out.println( "    /:/ _/_         ___          /\\  \\    ");
		System.out.println( "   /:/ /\\  \\       /\\__\\         \\:\\  \\   ");
		System.out.println( "  /:/ /::\\  \\     /:/  /          \\:\\  \\  ");
		System.out.println( " /:/_/:/\\:\\__\\   /:/__/       ___  \\:\\__\\ ");
		System.out.println( " \\:\\/:/ /:/  /  /::\\  \\     /\\  \\ |:|  | ");
		System.out.println( "  \\::/ /:/  /  /:/\\:\\  \\    \\:\\  \\|:|  | ");
		System.out.println( "   \\/_/:/  /   \\/__\\:\\  \\    \\:\\__|:|__| ");
		System.out.println( "     /:/  /         \\:\\__\\     \\::::/__/  ");
		System.out.println( "     \\/__/           \\/__/      ~~~~      ");
		
		System.out.println("\t\t\t\t\t\tProject done by:\n\t\t\t\t\t\tFrancisco Quinaz\n\t\t\t\t\t\tJorge Marques\n\n");
		//Initialization
		Scanner in= new Scanner(System.in);
		String op,menu="menu1";
		String name,address,year;
		University ist=new University();

		/*
			POPULATE
			___________________________________________________
		*/	
			System.out.println("[X]Populating....");
			CourseYear cY=null;

			//Courses

			//UniversityCourse uniCourse= new UniversityCourse(ist.createCourse("AMI", cY.FIRST),50);
			//System.out.println("[X]Course Created: INFORMATICS: AMI - First...");
			Course courseAux = ist.createCourse("ED", cY.FIRST);
			System.out.println("[X]Course Created: AMI - First...");
			try{
				UniversityCourse universityCourseAux= new UniversityCourse(courseAux,50);
				System.out.println("[X]UniversityCourse Created with "+courseAux.getName());
			}
			catch(Exception e){
				System.out.println("Exceprion catched: "+e);
			}
			ist.createCourse("AMII",cY.SECOND);
			System.out.println("[X]Course Created: AMII - Second... ");
			ist.createCourse("POO",cY.SECOND);
			System.out.println("[X]Course Created: POO - Second...");
			ist.createCourse("BD",cY.THIRD);
			System.out.println("[X]Course Created: BD - Third...");
			ist.createCourse("PPP", cY.FIRST);
			System.out.println("[X]Course Created: PPP - First...");
			ist.createCourse("ALGA", cY.FIRST);
			System.out.println("[X]Course Created: ALGA - First...");
			ist.createCourse("PC",cY.SECOND);
			System.out.println("[X]Course Created: PC - Second... ");
			ist.createCourse("ATD",cY.SECOND);
			System.out.println("[X]Course Created: ATD - Second...");
			ist.createCourse("ES",cY.THIRD);
			System.out.println("[X]Course Created: ES - Third...");

			//Create Students
			ist.createStudent("Francisco Quinaz", "Rua xyz");
			System.out.println("[X]Student Created: Francisco Quinaz");
			ist.createStudent("Jorge Marques", "Rua jota");
			System.out.println("[X]Student Created: Jorge Marques");
			ist.createStudent("Rui Cenas","Sem abrigo");
			System.out.println("[X]Student Created: Rui Cenas");
			
			//University Courses
			/*
			In order to create an university course we need at minimum a Coueres and a max 
			*/

			

			//Dependencies 









		/*
			---------------------------------------------------
		*/

		while(true){
		
			
			switch(menu){
				case "menu1":
					System.out.print("\t\t== MENU1 ==\n\n\t1 - University\n\t2 - Student\n\n\t0-Exit\n>>>");
					op=in.nextLine();
					switch(op){
						case "1":
							menu="menuUni";
							break;
						case "2":
						menu="menuStud";
							
							break;
						case "0":
							System.exit(0);

					}
					break;
				case "menuUni":
					System.out.print("\t\t== University ==\n\n\t1 - Create University Course\n\t2 - Create Course\n\t3 - Remove Course \n\t4 - Add Precedence\n\t5 - Remove precedence\n\n\t0-Back\n>>>");
					op=in.nextLine();
					switch(op){
						case "1":

							
							break;
						case "2":
						
							System.out.println("\n\n\tCreate Course\n\n");
							System.out.print("Course Name: ");
							name=in.nextLine();
							System.out.print("Course Year: ");
							year=in.nextLine();
								switch(year){
									case "first":
									case"FIRST":
									ist.createCourse(name, cY.FIRST);
									System.out.println("[X]Course Created: "+name+" - First...");
										break;
									case "second":
									case "SECOND":
									ist.createCourse(name, cY.SECOND);
									System.out.println("[X]Course Created: "+name+" - Second...");
										break;
									case "third":
									case "THIRD":
									ist.createCourse(name, cY.THIRD);
									System.out.println("[X]Course Created: "+name+" - Third...");
										break;
									case "fourth":
									case "FOURTH":
									ist.createCourse(name, cY.FOURTH);
									System.out.println("[X]Course Created: "+name+" - Fourth...");
										break;
									case "fifth":
									case "FIFTH":
									ist.createCourse(name, cY.FIFTH);
									System.out.println("[X]Course Created: "+name+" - Fifth...");
										break;
									default:
										System.out.println("INVALID YEAR! Try again...");

								}

						
							
							break;
						case "0":
							menu="menu1";
							break;

					}
					break;
				case "menuStud":
					System.out.print("\t\t== Student ==\n\n\t1 -Create Student \n\t2 - Calculate Fee \n\t3 - Student Enrollment\n\n\t0-Back\n>>>");
					op=in.nextLine();
					switch(op){
						case "1":
							
							System.out.println("\n\n\tCreate Student\n\n");
							System.out.print(" Name: ");
							name=in.nextLine();
							System.out.print("Address: ");
							address=in.nextLine();
							ist.createStudent(name, address);
							System.out.println("[X]Student Created: "+name);
							break;
						case "2":
							
							System.out.print("\n\n\tCalculate Student's Fee\n\n\nStudent's name: ");
							name=in.nextLine();
							//Calculate Fee Algorithm

						
							
							break;
						case "3":
							menu="stenroll";

							break;
						case "0":
							menu="menu1";
							break;

					}
					
					break;
				case "stenroll":
					System.out.println("Nothing to see here....YET!\nreturning to previous menu...");
					menu="menuStud";
					break;

			}
		}


		
	}

}
