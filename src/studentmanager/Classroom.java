/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author marissarousseau
 */
public class Classroom 
{
    /* FIELDS */    
    ArrayList<Student> students = new ArrayList<>();
    private int studentCounter = 0;
    private Scanner input = new Scanner(System.in);


    
    /* CONSTRUCTORS */
    public Classroom()
    {
        
    }
    
    /* GETTERS */
    public ArrayList<Student> getStudentList()
    {
        return students;
    }
    
    public Student getStudent(int x)
    {
        return students.get(x);
    }
    
    public int getClassSize()
    {
        return students.size();
    }
    
    /* SETTERS */
    public void addStudent()
    {
        Student s = new Student();
        System.out.println();
        System.out.print("Enter the first and last name of the student: ");
        s.setFirstName(input.next());
        s.setLastName(input.next());

        System.out.println();
        System.out.print("Enter the gender of the student (m/w/n): ");
        s.setGender(input.next().charAt(0));

        System.out.println();
        System.out.print("Enter the age of the student: ");
        s.setAge(input.nextInt());

        System.out.println();
        System.out.print("Does the student live on campus? (y/n): ");
        switch(input.next().charAt(0))
        {
            /* the student livess on campus */
            case 'y':
            {
                s.setLivesOnCampus(true);
            }
            /* the user does not live on campus */
            default:
            {
                s.setLivesOnCampus(false);
            }
        }

        System.out.println();
        System.out.println(s.getFullName() + " was successfully created!");
        System.out.println("This student's identification number is " + s.getStudentId() + " ");
        System.out.println();
        students.add(s);
        studentCounter++;
    }
    
    public void removeStudent()
    {
        System.out.println();
        this.displayStudents();

        System.out.print("Select a student to remove: ");
        
        int number = input.nextInt();

        System.out.println();
        System.out.print("Are you sure you want to remove this student? (y/n): ");

        switch(input.next().charAt(0))
        {
            /* remove the student from the class */
            case 'y':
            {
                System.out.println();
                students.remove(number-1);
                System.out.println("Student removed successfully!");
                break;
            }
            /* cancel student removal if any other input is entered */
            default:
            {
                System.out.println();
                System.out.println("Student removal was cancelled.");
                break;
            }
        }
        studentCounter--;
    }
    
    public void updateStudent(Student s, int number)
    {
        /* update the student with their most recent personal information */
       students.set(number-1, s);
    }
    
    /* OTHER METHODS */
    
    public void displayStudents()
    {
        /* display all students in the classroom in numerical order */
        for(int x=0; x<this.getClassSize(); x++)
        {
            /* cancel print-out if there aren't any students in the classroom */
            if(this.getStudentList().isEmpty())
            {
                System.out.println("There aren't any students in this class!");
                break;
            }
            /* print out the student's full name and whether or not they are absent/present */
            System.out.println((x+1) + ") " + this.getStudent(x).getFullName() + " (" + this.getStudent(x).isHere() + ")");
        }
    }
}
