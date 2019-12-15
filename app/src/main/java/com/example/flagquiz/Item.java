package com.example.flagquiz;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class Item.
 */
public class Item {
 
 /** The attributes. */
 private HashMap<String, String> attributes;
 private String name;
 
 /**
  * Instantiates a new quiz item.
  */
 // Default constructor
 public Item() {
	 
 }
 
 /**
  * Instantiates a new quiz item.
  *
  * @param attributes the attributes
  */
 // Overloaded constructor
 public Item(String name, HashMap<String, String> attributes)
 {
     this.name = name;
	 this.attributes = attributes;
 }
 
 /**
  * Sets the attributes.
  *
  * @param attributes the attributes
  */
 // Setters
 public void setAttributes(HashMap<String, String> attributes) {
	 this.attributes = attributes;
 }
 public void setName(String name) {this.name = name;};
 /**
  * Gets the attributes.
  *
  * @return the attributes
  */
 // Getters 
 public HashMap<String, String> getAttributes(){
	 return attributes;
 }
 public String getName(){return name;}
 
 /**
  * Prints the quiz item.
  */
 public void printQuizItem() {
  System.out.println(name);
	 for (Map.Entry<String, String> entry : attributes.entrySet()) {
		System.out.println(entry.getKey() + " : " + entry.getValue());
 }

}

}