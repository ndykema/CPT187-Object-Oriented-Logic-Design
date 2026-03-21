package edu.cpt187.dykema.program4;

import java.util.*;
import java.io.*;

public class ClassRoom {
	private String courseName;
	private String[] studentNames;
	private double[] studentGrades;
	private int numStudents;
	private int numGrades;

	public static final int ZERO = 0;
	
//I think I did the loadGrades method differently than you were explaining in your instructions. I tried to make my program
//more adaptable to a longer file and more information, than one that could only hold 50 lines.
//I added the methods "getNumberOfStudents" and "getNumberOfGrades" - these tell the program how many lines there are (students)
//and how many numbers follow the first student's name (setting a standard for the number of grades in the school year)
//using these two added methods, the file could have an unlimited amount of entries and an unlimited amount of grades for the year.
	
//I know I took some liberty, and if you aren't happy with me doing that, I have no problem accepting the responsibility of a 
//mark down in score for this assignment.
	public void loadGrades(String FILE_PATH) throws IOException
	{
		FileInputStream File = new FileInputStream(FILE_PATH);
		Scanner Title = new Scanner(File);
		courseName = Title.nextLine();
		Title.close();
		this.numStudents = getNumberOfStudents(FILE_PATH);
		this.numGrades = getNumberOfGrades(FILE_PATH);
		this.studentNames = getStudentNames(FILE_PATH);
		this.studentGrades = getStudentGrades(FILE_PATH);
		
	}
	//returns the course name
	public String getCourseName()
	{
		return courseName;
	}
	//This method goes through the file and counts the number of rows that contain data, it returns an integer that holds the number of
	//rows that hold data (if the file is formated correctly, this would be the number of students)
	public int getNumberOfStudents(String FILE_PATH) throws IOException 
	{
		int numberOfStudents=ZERO;
		FileInputStream File = new FileInputStream(FILE_PATH);
		Scanner dataFile = new Scanner (File);
		dataFile.nextLine();
			while(dataFile.hasNextLine()) 
			{
				dataFile.nextLine();
				numberOfStudents++;
			}
			dataFile.close();
			return numberOfStudents;	
	}
	// goes through the file and counts the number of individual grades after the first student's name - this sets a precedence for
	//the rest of the students and determines the number of grades that can be expected to be read.
	public int getNumberOfGrades(String FILE_PATH) throws IOException
	{
		int number =ZERO;
		int numberOfGrades=ZERO;
		FileInputStream File = new FileInputStream(FILE_PATH);
		Scanner dataFile = new Scanner (File);
		dataFile.nextLine();
		dataFile.next();
			while(dataFile.hasNextInt())
			{
				dataFile.nextInt();
				number++;
			}
		dataFile.close();
		numberOfGrades = number;
		return numberOfGrades;
	}
	//Searches through the file and establishes all of the students names into the array.
	public  String[] getStudentNames(String FILE_PATH) throws IOException
	{
		//Searching through the file for just the names of the students.
		FileInputStream nameFile = new FileInputStream(FILE_PATH);
		Scanner Names = new Scanner(nameFile);
		String[] studentClassRole = new String[numStudents];
		Names.nextLine();
		for (int i = ZERO; i < numStudents; i++) 
		{
			studentClassRole[i] = Names.next();
			Names.nextLine();
		}
		Names.close();
		return studentClassRole;
	}
	//Get the Students Grades and put them into the array
	public double[] getStudentGrades(String FILE_PATH) throws IOException
	{
	int numberOfStudents = getNumberOfStudents(FILE_PATH);
	FileInputStream gradeFile = new FileInputStream(FILE_PATH);
	Scanner Grades = new Scanner(gradeFile);
	double[] calculatedGrades = new double[numberOfStudents];
	while (Grades.hasNext()) 
	{ 
		int Exam = ZERO;
		//this loop walks us through each student
			for (int a = ZERO; a<numberOfStudents; a++)
				
			{
					int i=ZERO;
					//checking for the last grade in the line for the title of "final"/"exam"
					int b=(numGrades-1);
					//anything else is just a normal grade
					int c=(numGrades-2);
					
					Grades.nextLine();
					Grades.next();
					double gradeTally=ZERO;
					// this loop walks us through each student's grades. 
					// they are added together, until the "final exam" is reached, the final exam grade is multiplied by 3,
					// then added to the rest of the grades, to calculate the average grade for each student, we take the total
					// added grade, then divide it by 10. Once this average is put into the array for the grades, we move onto
					// the next student and do these same steps over.
					for (i = 0; i < numGrades; i++) 
					{	
						int number;
						number = Grades.nextInt();
						if (i == b) 
						{
							Exam = number * 3;
							gradeTally += number;
						} 
						else if (i < c) 
						{
							gradeTally += number;
						}
					}
					gradeTally += Exam;
					double averageGrade = gradeTally / 10;
					calculatedGrades[a]=averageGrade;
					
			}
	}
	Grades.close();
	return calculatedGrades;
	}
	//Get the students names by index - will be used for a search when looking for the highest and lowest grade.
	public String getStudentNameByIndex(int index)
	{
		String name = studentNames[index];
		return name;
	}
	//Get the students grades by index
	public double getGradeByIndex(int index)
	{
		double grade = studentGrades[index];
		return grade;
	}	
	//find the lowest grade in the array and figure out what position it holds
	public int indexMinGrade()
	{
		double lowest = studentGrades[0];
		int index=0;
		for (int i = 1; i < numStudents;i++)
		{
			if (studentGrades[i] < lowest)
			{
				lowest = studentGrades[i];
				index = i;
				
			}
		}
		return index;
	}	
	//find the highest grade in the array and figure out what position it holds
	public int indexMaxGrade()
	{
		double max = studentGrades[0];
		int index = 0;
		for (int i = 1; i < numStudents;i++)
		{
			if (studentGrades[i] > max)
			{
				max = studentGrades[i];
				index = i;
				
			}
		}
		return index;
	}
}

