package java_ankit;
import java.util.*;
class UserNotFoundException extends Exception{
	public UserNotFoundException(String a ) {
		super(a);
	}
}
enum subjects{
	MATHS, ENGLISH, GEOGRAPHY;
}
class School{
	private List<Teacher> teachers= new ArrayList<Teacher>();
	private String schoolname;
	public School(String schoolname) {
		schoolname=schoolname;
	}
	public void  getSchoolName() {
	
		System.out.println("Schoolname is "+schoolname);
	}
	public void  addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
	public void  removeTeacher() {
		System.out.println("1.Remove by id ");
		System.out.println("2.Remove by name");
		System.out.println("3.Remove by age");
		System.out.println("4.Remove by subject ");
	
      Scanner sc = new Scanner(System.in);
      int ch =sc.nextInt();
      sc.nextLine();
	switch(ch) {
	case 1 :
		try{
			int id =sc.nextInt();
			sc.nextLine();
			for(Teacher i :teachers) {
				if(i.getId()==id) {
					break;
				}else {
					throw new UserNotFoundException("Id not found.");
				}
			}
			
		
		
		teachers.removeIf(i ->i.getId()==id);
	}catch(UserNotFoundException a) {
	}
	  break;
	case 3 :
		try{
			int age =sc.nextInt();
			sc.nextLine();
			for(Teacher i :teachers) {
				if(i.getAge()==(age)) {
					break;
				}else {
					throw new UserNotFoundException("Age not found.");
				}
			}
			
		
		
		teachers.removeIf(i ->i.getAge()==age);
	}catch(UserNotFoundException a) {
		System.out.println(a.getMessage());
	}
	  break;
	 
	case 2 :
		try{
			String name =sc.nextLine();
			for(Teacher i :teachers) {
				if(i.getName().equals(name)) {
					break;
				}else {
					throw new UserNotFoundException("Name not found.");
				}
			}
	
		teachers.removeIf(i ->i.getName().equals(name));
	}catch(UserNotFoundException a) {
		System.out.println(a.getMessage());
	}
	  break;
	 
	case 4 :
		String subject =sc.next();
		subjects a = subjects.valueOf(subject.toUpperCase());
		try{
			String name =sc.nextLine();
			for(Teacher i :teachers) {
				if(i.getSubject().equals(a)) {
					break;
				}else {
					throw new UserNotFoundException("Subject not found.");
				}
			}
		
	}catch(UserNotFoundException b) {
		System.out.println(b.getMessage());
	}
		
		teachers.removeIf(i ->i.getSubject().equals(a));
	  break;
	 default:
		 System.out.println("Wrong choice.");
	}
	}
	public void getCount() {
		System.out.println("Total number of teachers are :"+teachers.size());
	}
	public void getTeacherById() {
		Scanner sc=new Scanner(System.in);
	    int id =sc.nextInt();
	    sc.nextLine();
	    for (Teacher i : teachers) {
	    	if(i.getId()==id) {
	    	System.out.println("Details for the teacher with id :"+i.getId()+" subject :"+i.getSubject()+" name : " +i.getName()+" age: "+i.getAge());	
	    }
	    	}
		
	}
	public void getAllTeacherById() {
		for (Teacher i : teachers) {
	    
	    	System.out.println("Details for the teacher with id :"+i.getId()+" subject :"+i.getSubject()+" name : " +i.getName()+" age: "+i.getAge());	
	    
	    	}
		
	}
}
class Teacher{
	private String name;
	private int id;
	private int age;
	private subjects subject;


	public void detailsForNewTeacher() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter age :");
		age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter id :");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name :");
		name= sc.nextLine();
		System.out.println("Enter choice of subject for teacher : 1 for MATHS 2 for English 3 for Geography ");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1 :
			subject=subjects.MATHS;
			break;
		case 2 :
			subject=subjects.ENGLISH;
			break;
		case 3 :
			subject=subjects.GEOGRAPHY;
			break;
		default:
			System.out.println("Wrong subject choice , No such subject present .");	
		}
		
		
	}
	public int  getId() {
		return id;
	}
	public int  getAge() {
		return age;
	}
	public String  getName() {
		return name;
	}
	public subjects  getSubject() {
		return  subject;
	}
}
public class core_java_implementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("Enter schoolname");	
	Scanner sc= new Scanner (System.in);
	String schoolname=sc.nextLine();
    School newSchool= new School(schoolname);
   
    
    System.out.println("1:ENTER NEW TEACHER");
    System.out.println("2:REMOVE A  TEACHER");
    System.out.println("3:COUNT ALL TEACHERS");
    System.out.println("4:GET TEACHER BY ID ");
    System.out.println("5:GET ALL TEACHER NAMES AND THEIR SUBJECTS ");
    System.out.println("6:GET MENU");
    while(true) {
    int choice =sc.nextInt();
	switch(choice) {
	case 1:
		Teacher newTeacher= new Teacher();
		newTeacher.detailsForNewTeacher();
		newSchool.addTeacher(newTeacher);
		 System.out.println("TEACHER ADDED");
		break;
	case 2:
		newSchool.removeTeacher();
		break;
	case 3:
		newSchool.getCount();
	    break;
	case 4 :
		newSchool.getTeacherById();
		break;
	case 5:
		newSchool.getAllTeacherById();
		break;
	case 6:
	    System.out.println("1:ENTER NEW TEACHER");
	    System.out.println("2:REMOVE A  TEACHER");
	    System.out.println("3:COUNT ALL TEACHERS");
	    System.out.println("4:GET TEACHER BY ID ");
	    System.out.println("5:GET ALL TEACHER NAMES AND THEIR SUBJECTS ");
	    System.out.println("6:GET MENU");
		break;
	default:
		System.out.println("Wrong choice");
	}
	}
	}
}
