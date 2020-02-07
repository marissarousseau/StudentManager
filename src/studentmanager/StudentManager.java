/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author marissarousseau
 */
public class StudentManager
{
    public static Scanner input = new Scanner(System.in);
    public static Classroom classroom = new Classroom();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        boolean programRunning = true;
        while(programRunning)
        {
            System.out.println("Welcome to Student Manager!");
            System.out.println("Here you can manage students in your class, mark attendance, and more");
            
            System.out.println();
         
            System.out.println("1) Student management");
            System.out.println("2) Attendance");
            System.out.println("3) Gradebook");
            System.out.print("Select an option: ");

            switch(input.nextInt())
            {
                case 1:
                {
                    System.out.println();
                    studentManagement();
                    break;
                }
                case 2:
                {
                    System.out.println();
                    markAttendance();
                    break;
                }
                case 3:
                {
                    System.out.println();
                    gradeBook();
                    break;
                }
                default:
                {
                    System.out.println();
                    System.out.println("That isn't a valid option!");
                    break;
                }
            }
            
            System.out.println("All operations completed. Would you like to do something else?");
            System.out.println();
            System.out.println("1) Continue");
            System.out.println("2) Quit");
            System.out.print("Select an option: ");
            switch(input.nextInt())
            {
                case 1:
                {
                    System.out.println();
                    break;
                }
                case 2:
                {
                    programRunning = false;
                    System.out.println();
                    System.out.println("Quitting... done.");
                }
                
            }
        }
    }
    
    public static void studentManagement()
    {
        System.out.println("STUDENT MANAGEMENT");
        System.out.println();
        
        System.out.println("1) Add student");
        System.out.println("2) Remove student");
        System.out.println("3) Modify student");
        System.out.print("Select an option: ");
        
        switch(input.nextInt())
        {
            case 1:
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
                    case 'y':
                    {
                        s.setLivesOnCampus(true);
                    }
                    default:
                    {
                        s.setLivesOnCampus(false);
                    }
                }
                
                System.out.println();
                System.out.println(s.getFullName() + " was successfully created!");
                System.out.println("This student's identification number is " + s.getStudentId() + " ");
                System.out.println();
                
                classroom.addStudent(s);
                break;
            }
            case 2:
            {
                if(classroom.getStudentList().isEmpty())
                {
                    System.out.println("There aren't any students to remove!");
                    break;
                }
                for(int x=0; x<classroom.getClassSize(); x++)
                {
                    System.out.println((x+1) + ") " + classroom.getStudent(x).getFullName());
                }
                
                System.out.print("Select a student to remove: ");
                
                System.out.println();
                System.out.print("Are you sure you want to remove this student? (y/n): ");
                
                switch(input.next().charAt(0))
                {
                    case 'y':
                    {
                        System.out.println();
                        classroom.removeStudent(input.nextInt());
                        System.out.println("Student removed successfully!");
                    }
                    default:
                    {
                        System.out.println();
                        System.out.println("Student removal was cancelled.");
                    }
                }
                break;
            }
        }
    }
    
    public static void markAttendance()
    {
        for(int x=0; x<classroom.getClassSize(); x++)
        {
            if(classroom.getStudentList().isEmpty())
            {
                System.out.println("There aren't any students in this class!!");
                break;
            }
            
            System.out.println((x+1) + ") " + classroom.getStudent(x).getFullName() + " (here: " + classroom.getStudent(x).isHere() + ")");
        }
                    
        System.out.print("Select a student to mark attendance for: ");
        int studentNum = input.nextInt();
        Student s = classroom.getStudent(studentNum-1);

        System.out.println();
        System.out.print("Is " + s.getFullName() + " here today? (y/n): ");

        switch(input.next().charAt(0))
        {
            case 'y':
            {
                s.setHere(true);
                System.out.println();
                System.out.println(s.getFullName() + " was marked as here.");
                break;
            }
            default:
            {
                s.setHere(false);
                System.out.println();
                System.out.println(s.getFullName() + " was marked absent.");
                break;
            }
        }

        classroom.modifyStudent(s, studentNum);

    }
    
    public static void gradeBook()
    {
        System.out.println("This is coming soon! Check back another time!");
    }
}
