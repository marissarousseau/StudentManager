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
    
    public Student()
    {
        studentId = 100000 + rng.nextInt(90000000);
        grade = 0.0;
    }
    
    /* GETTERS */
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getFullName()
    {
        return firstName + " " + lastName;
    }
    
    public char getGender()
    {
        return gender;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public int getStudentId()
    {
        return studentId;
    }
    
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
    
    public double getGrade()
    {
        return grade;
    }
    
    public String isHere()
    {
        if(here)
        {
            return "Absent";
        }
        else
        {
            return "Here";
        }
    }
    
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
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setGender(char gender)
    {
        this.gender = gender;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public void setLivesOnCampus(boolean livesOnCampus)
    {
        this.livesOnCampus = livesOnCampus;
    }
    
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
    
    public void setHere(boolean here)
    {
        this.here = here;
    }
    
}
