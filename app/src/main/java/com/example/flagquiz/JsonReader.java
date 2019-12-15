
package quizMaker;

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


	/**
	 * Instantiates a new json reader.
	 */
	public JsonReader() {

	}

	
	/**
	 * Instantiates a new json reader.
	 *
	 * @param jsonFile the json file
	 */
	public JsonReader(File jsonFile) {
		this.jsonFile = jsonFile;
	}
	
	
	
	/**
	 * Read json.
	 *
	 * @return the quiz items
	 */
	public Quiz readJson() {
		ObjectMapper mapper = new ObjectMapper();
		Quiz quiz = new Quiz();
		try {
			quiz = mapper.readValue(jsonFile, Quiz.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return quiz;

	}

	
	/**
	 * Prints the quiz items.
	 *
	 * @param quiz the quiz
	 */
	public void printQuizItems(Quiz quiz) {
		HashMap<String, ArrayList<QuizItem>> quizmap = quiz.getQuiz();
		// Iterates through each map key
		for (Map.Entry<String, ArrayList<QuizItem>> entry : quizmap.entrySet()) {
			// Iterates through each ArrayList item
			for (int i = 0; i < entry.getValue().size(); i++) {
				System.out.println("{");
				entry.getValue().get(i).printQuizItem();
				System.out.println("}");
			}
		}

	}

}
