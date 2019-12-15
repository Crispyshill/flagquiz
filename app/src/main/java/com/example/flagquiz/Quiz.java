package com.example.flagquiz;

import java.util.ArrayList;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Quiz.
 */
public class Quiz {
	
	/** The quiz. */
	private HashMap<String, ArrayList<Item>> quiz;
	
	/**
	 * Instantiates a new quiz.
	 */
	// Default constructor
	public Quiz() {
		
	}
	
	/**
	 * Instantiates a new quiz.
	 *
	 * @param quiz the quiz
	 */
	// Overloaded constructor
	public Quiz(HashMap<String, ArrayList<Item>> quiz) {
		this.quiz = quiz;
	}
	
	/**
	 * Sets the quiz.
	 *
	 * @param quiz the quiz
	 */
	// Setters
	public void setQuiz(HashMap<String, ArrayList<Item>> quiz) {
		this.quiz = quiz;
	}
	
	/**
	 * Gets the quiz.
	 *
	 * @return the quiz
	 */
	// Getters
	public HashMap<String, ArrayList<Item>> getQuiz() {
		return quiz;
	}
}

