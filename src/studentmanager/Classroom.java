/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.util.ArrayList;

/**
 *
 * @author marissarousseau
 */
public class Classroom 
{
    /* FIELDS */    
    ArrayList<Student> students = new ArrayList<>();
    private int studentCounter = 0;

    
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
    public void addStudent(Student s)
    {
        students.add(s);
        studentCounter++;
    }
    
    public void removeStudent(int number)
    {
        students.remove(number-1);
        studentCounter--;
    }
    
    public void modifyStudent(Student s, int number)
    {
       students.set(number-1, s);
    }
}
