package edu.cpt187.lastname.program5;

public class Tool {
String toolName;
String owner;
boolean availability;
//Tool Constructors
Tool(String name,String person){
	this.toolName = name;
	availability = true;
	this.owner = person;
}
Tool(String name,boolean test, String person)
{
	this.toolName = name;
	this.owner = person;
	this.availability = test;
}
//Method to get the tool name
public  String getToolName(){
	return toolName;
}
//Method to get the tool owner name
public String getOwnerName() {
	return owner;
}

//Method that gets the tool availability
public boolean getToolAvailability() {
	return availability;
}
//Method that sets the tool availability by changing the boolean value.
public void setToolAvailability(boolean available) {
	availability = available;
}
}
