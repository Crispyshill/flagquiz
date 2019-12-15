package com.example.flagquiz;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class QuizItem.
 */
public class QuizItem {
 
 /** The attributes. */
 private HashMap<String, String> attributes;
 
 /**
  * Instantiates a new quiz item.
  */
 // Default constructor
 public QuizItem() {
	 
 }
 
 /**
  * Instantiates a new quiz item.
  *
  * @param attributes the attributes
  */
 // Overloaded constructor
 public QuizItem(HashMap<String, String> attributes) {
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
 
 /**
  * Gets the attributes.
  *
  * @return the attributes
  */
 // Getters 
 public HashMap<String, String> getAttributes(){
	 return attributes;
 }
 
 /**
  * Prints the quiz item.
  */
 public void printQuizItem() {
	 for (Map.Entry<String, String> entry : attributes.entrySet()) {
		System.out.println(entry.getKey() + " : " + entry.getValue());
 }

}
}