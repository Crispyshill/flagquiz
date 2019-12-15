
package com.example.flagquiz;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * The Class JsonReader.
 */
public class JsonReader {
	
	/** The json file. */
	private File jsonFile = new File("src/main/java/jsonFiles/countryList.json");
	Context myContext;


	/**
	 * Instantiates a new json reader.
	 */
	public JsonReader(Context myContext) {
		this.myContext = myContext;

	}


	/**
	 * Instantiates a new json reader.
	 *
	 * @param jsonFile the json file
	 */
	public JsonReader(File jsonFile, Context myContext) {
		this.jsonFile = jsonFile;
		this.myContext = myContext;
	}
	
	
	
	/**
	 * Read json.
	 *
	 * @return the quiz items
	 */
	public ArrayList<Quiz> readJson() {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Quiz> quizList = new ArrayList<>();
		Quiz quiz = new Quiz();
		try {
			File dir = myContext.getFilesDir();
			File[] dirChildren = dir.listFiles();
			for (File child : dirChildren) {
				System.out.println("Checking " + child + " for quizes");
				if (child.getName().contains("quiz.json")) {
					System.out.println("reading quiz from : ");
					System.out.println(myContext.getFilesDir() + "/" + child.getName());
					quizList.add(mapper.readValue(new File(myContext.getFilesDir() + "/" + child.getName()), Quiz.class));
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return quizList;

	}

	
	/**
	 * Prints the quiz items.
	 *
	 * @param quiz the quiz
	 */
	public void printQuizItems(Quiz quiz) {
		HashMap<String, ArrayList<Item>> quizmap = quiz.getQuiz();
		// Iterates through each map key
		for (Map.Entry<String, ArrayList<Item>> entry : quizmap.entrySet()) {
			// Iterates through each ArrayList item
			for (int i = 0; i < entry.getValue().size(); i++) {
				System.out.println("{");
				entry.getValue().get(i).printQuizItem();
				System.out.println("}");
			}
		}

	}

}
