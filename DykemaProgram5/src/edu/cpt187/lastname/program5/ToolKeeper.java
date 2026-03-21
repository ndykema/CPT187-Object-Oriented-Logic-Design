package edu.cpt187.lastname.program5;

import java.util.*;
import java.io.*;

public class ToolKeeper {

	static ArrayList<Tool> toolList = new ArrayList<>();
//Method that loads all of the data from the file using the file path
	public static void loadToolList(String filePath) throws IOException {
		FileInputStream toolFile = new FileInputStream(filePath);
		Scanner inputFile = new Scanner(toolFile);

		while (inputFile.hasNext()) {
			String tool = inputFile.next();
			boolean availability = inputFile.nextBoolean();
			String owner = inputFile.next();
			Tool entry = new Tool(tool, availability, owner);
			toolList.add(entry);
		}
		inputFile.close();
	}
//Method that returns the number of tools in the array
	public int getNumTools() {
		return toolList.size();
	}
//Method that searches the Array List looking for a match based on the provided tool
	public static Tool findToolByName(String searchInput) {
		int mid = 0;
		int first = 0;
		int last = toolList.size() - 1;
		Tool searchedTool = null;
		boolean exists = false;
		int position = 0;

		while (exists == false && first <= last)

		{
			mid = (first + last) / 2;
			if (toolList.get(mid).getToolName().compareToIgnoreCase(searchInput) == 0) {
				exists = true;
				position = mid;
			} else if (toolList.get(mid).getToolName().compareToIgnoreCase(searchInput) < 0) {
				first = (mid + 1);
			} else {
				last = mid - 1;
			}

		}
		if (exists == true) {
			searchedTool = toolList.get(position);
		} else {
			searchedTool = null;
		}

		return searchedTool;
	}
	//Method that adds a tool to the Array List - is given a tool object and it is added to the ArrayList
	public static void addTool(Tool toolInput) {
		toolList.add(toolInput);
	}
	//Method that removes a given tool from the Array List
	public static void removeTool(Tool toolInput) {
		toolList.remove(toolInput);
	}
	//Method that gets the tool list
	public static ArrayList<Tool> getToolList() {
		return toolList;
	}	
	//Method that sorts through the ArrayList based on a given tool to add it to a proper location based on
	//the alphabetical location.
	public static void sortToolList(String searchInput, Tool toolInput) {
	int mid = 0;
	int first = 0;
	int last = toolList.size() - 1;
	boolean exists = false;
	int newToolPos = 0;

	while (exists == false && first <= last)

	{
		mid = (first + last) / 2;
		if (toolList.get(mid).getToolName().compareToIgnoreCase(searchInput) == 0) {
			exists = true;
		} else if (toolList.get(mid).getToolName().compareToIgnoreCase(searchInput) < 0) {
			first = (mid + 1);
		} else {
			last = mid - 1;
		}
newToolPos = mid;
	}
	toolList.add(newToolPos, toolInput);

	
}
}
