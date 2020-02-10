/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.util.Scanner;

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
            System.out.println("2) Attendance log");
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
                /* mark student as here */
                s.setHere(true);
                System.out.println();
                System.out.println(s.getFullName() + " was marked here.");
                break;
            }
            default:
            {
                /* mark student as absent */
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
        System.out.println();
        System.out.println("GRADEBOOK");
        System.out.println();
        classroom.displayStudents();
        System.out.print("Select a student to update: ");
        int studentNum = input.nextInt();
        Student s = classroom.getStudent(studentNum-1);
        System.out.println(s.getFullName());
        System.out.println("Current grade: " + s.getGrade());
        System.out.print("Please enter the new grade: ");
        s.setGrade(input.nextDouble());
        classroom.updateStudent(s,studentNum);
        System.out.println("Student grade updated successfully!");
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
            /* keep the program running */
            case 1:
            {
                System.out.println();
                return true;
            }
            /* shut down the program */
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
        /* general error message for input that is invalid */
        System.out.println("That isn't a valid option!");
    }
    
    public static void modifyStudent()
    {
        /* Method used for student modifications, such as updating personal information */
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
                /* update the given student's first and last name */
                System.out.println();
                System.out.print("Enter the student's first and last name: ");
                s.setFirstName(input.next());
                s.setLastName(input.next());
                classroom.updateStudent(s,studentNum);
                System.out.println("Student was updated successfully.");
                break;
            }
            case 2:
            {
                /* create a new student ID number */
                System.out.println();
                System.out.println("WARNING: You are regenerating " + s.getFullName() + "\'s identification number.");
                System.out.println();
                System.out.print("Please type \"YES\" in all caps to confirm: ");
                switch(input.next())
                {
                    case "YES":
                    {
                        /* confirm student id rengeneration*/
                        System.out.println();
                        System.out.println("Regenerating...");
                        s.resetStudentId();
                        classroom.updateStudent(s, studentNum);
                        System.out.println(s.getFullName() + "\'s identification number is now " + s.getStudentId());
                        break;
                    }
                    default:
                    {
                        /* cancel student regeneration */
                        System.out.println();
                        System.out.println("Student ID regeneration was cancelled!");
                        break;
                    }
                }
                break;
            }
            case 3:
            {
                /* set student's gender */
                System.out.println();
                System.out.print("Please enter the student's gender (m/w/n): ");
                s.setGender(input.next().charAt(0));
                classroom.updateStudent(s,studentNum);
                System.out.println(s.getFullName() + "\'s gender is now set as " + s.getGender());
                break;
            }
            case 4:
            {
                /* set student's age */
                System.out.println();
                System.out.print("Plase enter the student's new age: ");
                s.setAge(input.nextInt());
                classroom.updateStudent(s, studentNum);
                System.out.println("Age successfully updated!");
                break;
            }
            case 5:
            {
                /* you can't modify the student's grade from here! */
                System.out.println();
                System.out.print("To modify a student's grade, please visit the Gradebook!");
                break;
            }
            case 6:
            {
                /* set whether the student lives on or off campus – eventually I want to change the logic of the isLivesOnCampus() method to return a string of either "on" or "off" */
                System.out.println();
                System.out.print("Does this student live on campus? (y/n): ");
                switch(input.next().charAt(0))
                {
                    /* student lives on campus now */
                    case 'y':
                    {
                        s.setLivesOnCampus(true);
                        System.out.println("Student now lives on campus.");
                        break;
                    }
                    default:
                    {
                        /* student doesnt' live on campus or input was not equal to 'y' */
                        s.setLivesOnCampus(false);
                        System.out.println("Student no longer lives on campus.");
                        break;
                    }
                }
                break;
            }
            case 7:
            {
                /* you can't mark attendance from here! */
                System.out.println();
                System.out.println("To set attendance, please visit the Attendance Log!");
                break;
            }
        }
    }
}
