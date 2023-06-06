package com.student.ops;

public class Student
{
    String name;
    int rollNo;
    String course;
    int totalMarks;
    Student next;

    public Student()	 // Non-Parameterized Constructor
    {
    	
    }

	public Student(String name, int rollNo, String course, int totalMarks)	// Parameterized Constructor
	{
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
        this.totalMarks = totalMarks;
//       next = null;
    }


    Student head=null;
    // Check Student Record
    public boolean checkRecord(int rollNo) 
    {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Create a New Record
    public void createRecord(String name, int rollNo, String course, int totalMarks) 
    {

        Student newStudent = new Student(name, rollNo, course, totalMarks);
        if (head == null) 
        {
            head = newStudent;
        } 
        else 
        {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }
        System.out.println();
        System.out.println("Record added successfully!!!");
    }

    // Search Record by Roll Number
    public void searchRecord(int rollNo) 
    {
        Student temp = head; 
        while (temp != null) 
        {
            if (temp.rollNo == rollNo) 
            {
                System.out.println("Name: " + temp.name);
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Course: " + temp.course);
                System.out.println("Total Marks: " + temp.totalMarks);
                return;
            }
            temp = temp.next;
        }
        System.out.println();
        System.out.println("Record not found");
    }
    
    // Search Record by Name
    public void searchRecord(String name) 
    {
        Student obj = head;
        boolean flag=false;
        while (obj != null) 
        {
            if (obj.name.equalsIgnoreCase(name) || obj.name.contains(name) || obj.name.contains(name.toLowerCase()) || obj.name.contains(name.toUpperCase())) 
            {
            	flag=true;
                System.out.println("Name: " + obj.name);
                System.out.println("Roll No: " + obj.rollNo);
                System.out.println("Course: " + obj.course);
                System.out.println("Total Marks: " + obj.totalMarks);
                System.out.println();
            
            } 
          obj = obj.next;
        }
        if(flag==false) 
        {
        	System.out.println();
        	System.out.println("Record not found");
        }
    }

    // Delete Record by Roll Number
    public int deleteRecord(int rollNo) 
    {
        if (head == null) 
        {
        	System.out.println();
            System.out.println("List is empty");
            return -1;
        }
        if (head.rollNo == rollNo) 
        {
            head = head.next;
            System.out.println();
            System.out.println("Record with Rollno " +rollNo+ " deleted successfully");
            return 0;
        }
        Student prev = head;
        Student curr = head.next;
        while (curr != null) 
        {
            if (curr.rollNo == rollNo) 
            {
                prev.next = curr.next;
//                curr.next = null;
                System.out.println();
                System.out.println("Record deleted successfully!!!");
                System.out.println("-----------------------------------------------");
                return 0;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println();
        System.out.println("Record not found");
        return -1;
    }

    // Show all Records
    public void showRecords() 
    {
        if (head == null) 
        {
        	System.out.println();
            System.out.println("List is empty");
            return;
        }
        System.out.println();
        System.out.println("List of students:");
        System.out.println();
        Student temp = head;
        while (temp != null) 
        {
            System.out.println("Name: " + temp.name);
            System.out.println("Roll No: " + temp.rollNo);
            System.out.println("Course: " + temp.course);
            System.out.println("Total Marks: " + temp.totalMarks);
            System.out.println("-----------------------------------------------");
            temp = temp.next;
        }
    }
}