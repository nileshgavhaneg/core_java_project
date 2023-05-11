package com.edu.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Student_m {
	
	Scanner sc=new Scanner(System.in);
	
	boolean found=false;

	Student s=new Student(1,"nilesh",25,"fullstack");
	Student s1=new Student(2,"neha",28,"angular");
	Student s2=new Student(3,"aparna",29,"fullstack");
	Student s3=new Student(4,"satvik",24,"sql");

	
	//List<Student> l=Arrays.asList(s,s1,s2,s3);
	List<Student> modified=new ArrayList<>();
	
	List<Student> l=new ArrayList<>();
	
	   int id ;
	   String name;
	   int age;
	   String course;
	  List<Student> l1;
	public Student_m() {
		super();
		l.add(s);
		l.add(s1);
		l.add(s2);
		l.add(s3);
		
		
	}
	public void Delete() {
		
		System.out.println("Enter id :");
		
		id=sc.nextInt();
		Student s=null;
		
		for(Student d:l) {
			if(d.getId()==id) {
				s=d;
				found=true;
				
			}
		}
		if(!found) {
			System.out.println("Employee is not present");
		}
		else {
			l.remove(s);
			System.out.println("Deleted sucessfully");
		}
	}
	public void update() {
		System.out.println("Enter id: ");
		id=sc.nextInt();
		boolean found=false;
		for(Student s:l) {
			if(s.getId()==id) {
				System.out.println("Enter name: ");
				name=sc.next();
				System.out.println("Enter new age");
				age=sc.nextInt();
				System.out.println("Enter new course");
				course=sc.next();
				s.setName(name);
				s.setAge(age);
				s.setCourse(course);
				System.out.println("Updated Details of Student are: ");
				System.out.println(s);
				found=true;
			}
		}
		if(!found) {
			System.out.println("student is not present");
		}
		else {
			System.out.println("Student details updated successfully !!");
		}
	}
	public void viewById() {
		System.out.println("Enter id: ");
		id=sc.nextInt();
		for(Student s:l) {
			if(s.getId()==id) {
				System.out.println(s);
				found=true;
			}
			
		}
		if(!found) {
			System.out.println("student with this id is not present");
		}
	}
     
	public void Highestage(List<Student> l) {
	Optional<Student> g=	l.stream().max(Comparator.comparing(Student::getAge));
		System.out.println(g);
	}
	public void getStudentby_Course(List<Student> l) {
			
		List<Student> l1=l.stream().filter(e->e.getCourse().contains("fullstack")).toList();
		l1.stream().forEach(e->System.out.println(e));
	}
	
	public void Display(List<Student> l) {
		for(Student k:l) {
			System.out.println(k+" ");
		}
		

	}
	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		boolean order=true;
		
		Student_m m=new Student_m();
		
		System.out.println("enter 1 for see all students in university"
				+ "\n enter 2 for display highest age student"
				+ "\n enter 3 for  show students according to there course"
				+ "\n enter 4 for delete student"
				+ "\n enter 5 for update student"
				+"\n enter 6 for view student by Id"
				+"\n enter 8 for exit th Application"
				);
		
		do {
			int choice=sc.nextInt();
			
			switch(choice) {
			
			case 1:
			m.Display(m.l);
			break;
			
			case 2 :
				
		   m.Highestage(m.l);
			
			break;
			
			case 3 :
		
		m.getStudentby_Course(m.l);
		
		     break;
			case 4 :
				m.Delete();
				
				break;
			case 5:
				m.update();
				break;
				
			case 6 :
				
				m.viewById();
				
				break;
				
			case 8 :
            System.out.print("successfully exit");
				System.exit(0);
				
				
				break;
				
				default:
					System.out.println("enter vaid key");
					
					break;
			
			}
			
		}while(order);		
		
	}

}
