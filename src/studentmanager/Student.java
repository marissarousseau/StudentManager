/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.util.Random;

/**
 *
 * @author marissarousseau
 */
public class Student
{
    /* FIELDS */
    
    private String firstName;
    private String lastName;
    private char gender;
    private int age;
    private int studentId;
    private boolean livesOnCampus;
    private double grade;
    private boolean here;
    
    private Random rng  = new Random();
    
    
    /* CONSTRUCTORS */

    /**
     *Creates a Student object with randomly generated Student ID number and grade of 0.0
     */

    
    public Student()
    {
        studentId = 100000 + rng.nextInt(90000000);
        grade = 0.0;
    }
    
    /* GETTERS */

    /**
     *
     * @return Returns the current first name of a Student
     */

    
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     *
     * @return Returns the current last name of a Student
     */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     *
     * @return Returns the current full name of a Student
     */
    public String getFullName()
    {
        return firstName + " " + lastName;
    }
    
    /**
     *
     * @return Returns the current gender of a Student
     */
    public String getGender()
    {
        if(gender == 'm')
        {
            return "man";
        }
        else if(gender == 'w')
        {
            return "woman";
        }
        else
        {
            return "non-binary";
        }
    }
    
    /**
     *
     * @return Returns the current age of a Student
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     *
     * @return Returns the current identification number of a Student
     */
    public int getStudentId()
    {
        return studentId;
    }
    
    /**
     *
     * @return Returns the housing status of a Student
     */
    public String isLivesOnCampus()
    {
        if(livesOnCampus)
        {
            return "Yes";
        }
        else
        {
            return "No";
        }
    }
    
    /**
     *
     * @return Returns the current grade of a Student
     */
    public double getGrade()
    {
        return grade;
    }
    
    /**
     *
     * @return Returns the attedance status of a Student
     */
    public String isHere()
    {
        if(here)
        {
            return "Present";
        }
        else
        {
            return "Absent";
        }
    }
    
    /**
     *Displays a neatly ordered list of field values of a Student
     */
    public void displayInfo()
    {
        System.out.println("1) Student Name: " + this.getFullName());
        System.out.println("2) Student ID: " + this.getStudentId());
        System.out.println("3) Gender: " + this.getGender());
        System.out.println("4) Age: " + this.getAge());
        System.out.println("5) Grade: " + this.getGrade());
        System.out.println("6) Lives on Campus: "  + this.isLivesOnCampus());
        System.out.println("7) Attendance: " + this.isHere());
    }
    
    /* SETTERS */

    /**
     *
     * @param firstName The new first name of a Student
     */

    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    /**
     *
     * @param lastName The new last name of a Student
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    /**
     *
     * @param gender The new gender of a Student
     */
    public void setGender(char gender)
    {
        this.gender = gender;
    }
    
    /**
     *
     * @param age The new age of a Student
     */
    public void setAge(int age)
    {
        this.age = age;
    }
    
    /**
     *
     * @param livesOnCampus The new housing status of a Student
     */
    public void setLivesOnCampus(boolean livesOnCampus)
    {
        this.livesOnCampus = livesOnCampus;
    }
    
    /**
     *
     * @param grade The new grade of a Student
     */
    public void setGrade(double grade)
    {
        if(grade > 100)
        {
            System.out.println("Extra credit isn't allowed! Grades can only go up to 100.0");
        }
        else
        {
            this.grade = grade;
        }
    }
    
    /**
     *
     * @param here The new attendance status of a Student
     */
    public void setHere(boolean here)
    {
        this.here = here;
    }
    
    /**
     * Resets the Student ID number of a Student
     */
    public void resetStudentId()
    {
        this.studentId = 100000 + rng.nextInt(90000000);
    }
    
}
