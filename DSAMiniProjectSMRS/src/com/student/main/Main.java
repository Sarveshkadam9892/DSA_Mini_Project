/* 4. Student record management system using Single linked list using menu driven program.
	a. Insert Student record
	b. Delete student record
	c. Show student record
	d. Search student record by name or rollno
	e. Show all students
	
	The student record should contain the following items
		Name of Student
		Roll Number of Student
		Course in which Student is Enrolled
		Total Marks of Student
		Total Marks of Student
*/

package com.student.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

import javax.sql.rowset.serial.SQLOutputImpl;

import com.student.ops.Student;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Student srm = new Student();
		System.out.println();
		int choice = 0;
		do {
			System.out.println("Student Record Management System Using Linkedlist ");
			System.out.println("1. Insert Student record");
			System.out.println("2. Delete student record");
			System.out.println("3. Show student record");
			System.out.println("4. Search student record by name or rollno");
			System.out.println("5. Show all students");
			System.out.println("6. Exit");
			System.out.println();

			try {
				System.out.print("Enter your choice:");
				choice = Integer.parseInt(br.readLine());// parseInt is for coverting String into Integer
			} 
			
			    catch (NumberFormatException e) {
			    	
				System.out.println("Please Enter a Valid Choice!!!!");

				// Treating the InputMismatchException
				try {
					System.out.print("Please Enter Valid Choice Again:");
					choice = Integer.parseInt(br.readLine());
				} catch (NumberFormatException ex) {
					System.out.println(ex);
				}
			}
			
			switch (choice) {
				// Insert Student Record
				case 1:
					System.out.println();

					String name;
					do {
						System.out.print("Enter name:");
						name = br.readLine();
						if (!name.matches("^[a-zA-Z ]*$"))
							System.out.println("Please Enter a Valid Name!!");
					} while (!name.matches("^[a-zA-Z ]*$"));

					int rollNo = 0;
					boolean flag = false;
					try {
						do {
							flag = false;
							System.out.print("Enter roll number:");
							rollNo = Integer.parseInt(br.readLine());
							if (srm.checkRecord(rollNo)) {
								System.out.println("Record already exists! Please Enter a Unique RollNo.!!");
								flag = true;
							}
						} while (flag == true);
					} 
					catch (NumberFormatException e) {
					System.out.println("Please Enter a Valid RollNo!!");
					
					try {
						System.out.print("Please Enter Roll Number Again:");
						rollNo = Integer.parseInt(br.readLine());
					} catch (NumberFormatException ex) {
						System.out.println(ex);
					}
				}				
					String course;
					do {
						System.out.print("Enter course:");
						course = br.readLine();
						if (!course.matches("^[a-zA-Z ]*$"))
							System.out.println("Please Enter a Valid Course Name!!");
					} while (!course.matches("^[a-zA-Z ]*$"));

					int totalMarks = 0;
					try {
						System.out.print("Enter total marks:");
						totalMarks = Integer.parseInt(br.readLine());
					} catch (NumberFormatException e) {
						System.out.println("Please Enter Valid Total Marks!!");
						// Treating the InputMismatchException
						try {
							System.out.print("Please Enter Total Marks Again:");
							totalMarks = Integer.parseInt(br.readLine());
						} catch (NumberFormatException ex) {
							System.out.println(ex);
						}
					}
					srm.createRecord(name, rollNo, course, totalMarks);
					srm.showRecords();
					System.out.println("-----------------------------------------------");
					break;

				// Delete student record
				case 2:
					System.out.println();

					rollNo = 0;
					try {
						System.out.print("Enter roll number:");
						rollNo = Integer.parseInt(br.readLine());
					} catch (NumberFormatException e) {
						System.out.println("Please Enter a Valid RollNo!!");
						
						try {
							System.out.print("Please Enter Roll Number Again:");
							rollNo = Integer.parseInt(br.readLine());
						} catch (NumberFormatException ex) {
							System.out.println(ex );
						}
					}
					srm.deleteRecord(rollNo);
					srm.showRecords();
					System.out.println("-----------------------------------------------");

					break;

				// Show student record
				case 3:
					System.out.println();

					rollNo = 0;
					try {
						System.out.print("Enter roll number:");
						rollNo = Integer.parseInt(br.readLine().trim());
					} catch (NumberFormatException e) {
					    System.out.println("Please Enter a Valid RollNo!!");
					    
						try {
							System.out.print("Please Enter Roll Number Again:");
							rollNo = Integer.parseInt(br.readLine().trim());
	      				} catch (NumberFormatException ex) {
	      					System.out.println(ex);
//	      					String err = ex.getMessage();
//	      				    System.out.println("error message: " +err);
						}
				}
					System.out.println();
					srm.searchRecord(rollNo);
					System.out.println("-----------------------------------------------");
					break;

				// Search student record by name or rollno
				case 4:
					String value;
					int valuelength = 0;
					char Value = ' ';
					do {
						System.out.println();
						System.out.print("Press N or n for Name or Press R or r for Rollno:");
						value = br.readLine();
						valuelength = value.length(); 
						if (valuelength == 1)
							Value = value.charAt(0);
						if (Value != 'R' && Value != 'r' && Value != 'N' && Value != 'n' && valuelength == 1)
							System.out.println("Invalid Choice!! Please try again!");
						else if (valuelength > 1)
							System.out.println("Please Enter a Valid Choice!!");
					} while (Value != 'R' && Value != 'r' && Value != 'N' && Value != 'n' && valuelength >= 1);
					System.out.println();
					if (Value == 'N' || Value == 'n') {
						do {
							System.out.print("Enter Name:");
							name = br.readLine();
							if (!name.matches("^[a-zA-Z ]*$"))
								System.out.println("Please Enter a Valid Name!!");
						} while (!name.matches("^[a-zA-Z ]*$"));
						System.out.println();
						srm.searchRecord(name.trim());
					} else if (Value == 'R' || Value == 'r') {
						rollNo = 0;
						String rno = "";
						try {
							System.out.print("Enter roll number:");
							rno = br.readLine().trim();
							rollNo = Integer.parseInt(rno);
						} catch (NumberFormatException e) {
							System.out.println("Please Enter a Valid RollNo!!");
							// Treating the InputMismatchException
							try {
								System.out.print("Please Enter Roll Number Again:");
								rno = br.readLine().trim();
								rollNo = Integer.parseInt(rno);
							} catch (NumberFormatException ex) {
								System.out.println(ex);
							}
						}
						System.out.println();
						srm.searchRecord(rollNo);
					}
					System.out.println("-----------------------------------------------");
					break;

				// Show all students
				case 5:
					srm.showRecords();
					break;

				// Exit
				case 6:
					System.out.println();
					System.out.println("------------Program Terminated Successfully-------------");
					return;

				// For Invalid Choice
				default:
					System.out.println();
					System.out.println("Invalid choice!!! Please enter a Valid Choice!");
					System.out.println("-----------------------------------------------");
					System.out.println();
			}
		} while (choice != 6);
	} 
}
