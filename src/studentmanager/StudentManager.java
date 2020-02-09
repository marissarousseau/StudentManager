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
        /* loop the program until the user requests it to end */
        boolean programRunning = true;
        while(programRunning)
        {
            /* intro */
            System.out.println("Welcome to Student Manager!");
            System.out.println("Here you can manage students in your class, mark attendance, and more");
            
            System.out.println();
         
            System.out.println("1) Student management");
            System.out.println("2) Attendance");
            System.out.println("3) Gradebook");
            System.out.print("Select an option: ");

            switch(input.nextInt())
            {
                /* student management: add, remove, or modify a student */
                case 1:
                {
                    System.out.println();
                    studentManagement();
                    break;
                }
                /* attendance: mark student attendance (here/not here)*/
                case 2:
                {
                    System.out.println();
                    markAttendance();
                    break;
                }
                /* gradebook: set the current grade & gpa of each student */
                case 3:
                {
                    System.out.println();
                    gradeBook();
                    break;
                }
                /* default: message if the input is invalid */
                default:
                {
                    System.out.println();
                    invalidInput();
                    break;
                }
            }
            
            /* ask user if they want to end the program */
            programRunning = setProgramRunning();
        }
    }
    
    public static void studentManagement()
    {
        /* student management options */
        System.out.println("STUDENT MANAGEMENT");
        System.out.println();
        
        System.out.println("1) Add student");
        System.out.println("2) Remove student");
        System.out.println("3) Modify student");
        System.out.print("Select an option: ");
        
        switch(input.nextInt())
        {
            /* Add student: Appends a new student to the classroom list */
            case 1:
            {
                classroom.addStudent();
                break;
            }
            /* Remove student: Removes a specified student from the classroom list */
            case 2:
            {
                classroom.removeStudent();
                break;
            }
            case 3:
            {
                modifyStudent();
                break;
            }
            /* default: message if the input is invalid */
            default:
            {
                System.out.println();
                invalidInput();
            }
        }
    }
    
    public static void markAttendance()
    {
        classroom.displayStudents();
        
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
                System.out.println(s.getFullName() + " was marked here.");
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

        classroom.updateStudent(s, studentNum);

    }
    
    public static void gradeBook()
    {
        System.out.println("This is coming soon! Check back another time!");
    }
    
    public static boolean setProgramRunning()
    {
        System.out.println();
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
                return true;
            }
            default:
            {
                System.out.println();
                System.out.println("Quitting... done.");
                return false;
            }
        }
    }
    
    public static void invalidInput()
    {
        System.out.println("That isn't a valid option!");
    }
    
    public static void modifyStudent()
    {
        System.out.println();
        classroom.displayStudents();
        System.out.println();
        System.out.print("Select a student to modify: ");
        int studentNum = input.nextInt();
        Student s = classroom.getStudent(studentNum-1);
        System.out.println();
        s.displayInfo();
        System.out.println();
        System.out.print("Select an attribute to modify: ");
        switch(input.nextInt())
        {
            case 1:
            {
                System.out.println();
                System.out.print("Enter the student's first and last name: ");
                s.setFirstName(input.next());
                s.setLastName(input.next());
                classroom.updateStudent(s,studentNum);
                System.out.println("Student was updated successfully.");
            }
        }
    }
}
