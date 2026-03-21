package edu.cpt187.dykema.program4;

//Import the Java io and util class
import java.io.*;
import java.util.*;

public class MainClass {
//Establish our public final variables
	public static String FILE_PATH = "Grades.txt";
	public static int ZERO = 0;
	public static String[] menuOptions = { "Student with Highest Grade", "Student with Lowest Grade", "Quit" };
	public static String[] menuSelections = { "A.)", "B.)", "Q" };

//Main Method
	public static void main(String[] args) throws IOException {
//establish our local variables
		Scanner input = new Scanner(System.in);
		char menuSelection = 0;

		// Create our classroom object
		ClassRoom Class1 = new ClassRoom();
		Class1.loadGrades(FILE_PATH);
//Get a menu selection from our user
		menuSelection = getValidInput(input, menuSelections, menuOptions, Class1);
//Filter our selection and apply the correct output
		while (menuSelection != 'Q') {
			if (menuSelection == 'A') {
				getMaxGrade(Class1);
			} else if (menuSelection == 'B') {
				getMinGrade(Class1);
			}
			menuSelection = getValidInput(input, menuSelections, menuOptions, Class1);
		}
//If the selection is "Q" we end the program.
		System.out.println("\t\tProgram Closed.");
	}

//Method Development Past Here

//Method for displaying our User Menu
	public static void displayMenu(String[] menuSelections, String[] menuOptions, ClassRoom Class1) {
		System.out.println("          Grade Accessing Program");
		System.out.printf("\tClass: %s\n", Class1.getCourseName());
		System.out.println("\n\t     ***Menu Selection***");
		for (int i = 0; i < menuOptions.length; i++) {
			System.out.printf("\t%s: %s\n", menuSelections[i], menuOptions[i]);
		}
	}

//Method to get a valid input from the user and to check to make sure that it isn't invalid
//Throws an error message if it is invalid and promts the user to input a correct selection.
	public static char getValidInput(Scanner borrowedInput, String[] menuSelections, String[] menuOptions,
			ClassRoom Class1) {
		displayMenu(menuSelections, menuOptions, Class1);
		System.out.println("\n\t  Please make a selection!");
		char selection = borrowedInput.next().toUpperCase().charAt(0);
		while (selection != 'A' && selection != 'B' && selection != 'Q') {
			System.out.println("\t  Please enter a valid selection!\n\t\t Example input: A");
			selection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return selection;
	}

//Method that uses the Class Object to find the index of the max grade, then prints out the student and grade at that index
	public static void getMaxGrade(ClassRoom Class1) {
		int i = Class1.indexMaxGrade();
		System.out.println("\tThe Highest grade is:");
		System.out.printf("\tClassmate:%-10s\tGrade:%.1f\n\n", Class1.getStudentNameByIndex(i),
				Class1.getGradeByIndex(i));
	}

//Method that uses the Class Object to find the index of the min grade, then prints out the student and grade at that index
	public static void getMinGrade(ClassRoom Class1) {
		int i = Class1.indexMinGrade();
		System.out.println("\tThe Lowest grade is:");
		System.out.printf("\tClassmate:%-15s\tGrade:%.1f\n\n", Class1.getStudentNameByIndex(i),
				Class1.getGradeByIndex(i));
	}
}
