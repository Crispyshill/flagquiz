// Located in the flagquiz package
package com.example.flagquiz;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;

import com.couchbase.lite.support.SequenceMap;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 *   Class           CoutnryReader
 *   File            CountryReader.java
 *   Description     Reads countries from a csv to objects, and edits those objects.
 *   @author         <i>Seth Hillsberry</i>
 *   Environment PC, Windows 10, NetBeans IDE 8.2, jdk 1.8.2 
 *   Date           12/02/2019
 *   @version       1.0.0 
 *   History Log
 * </pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class CountryReader {
    // File variable for the location of the country list
    // ArrayList to hold the names of the countries, and to remove the used ones.
    ArrayList<String> countryNames;
    // ArrayList to hold the country objects.
    ArrayList<Country> countryList = new ArrayList();
    // ArrayList to hold the country names without removing any.
    ArrayList<String> constantCountryNames = new ArrayList();
    // integer representign the number of countries.
    int numberOfCountries = 0;
    AssetManager mgr = null;
    Context context;

    // Default constructor
    public CountryReader(Context myContext) {
        mgr = myContext.getAssets();
        context = myContext;

        // Calls method to read the countries to objects in an ArrayList
        //readCountriesToObjects();
        readCountriesFromJson();
        writeObjectToJson();
        // Creates an ArrayList holding the country names.
        fillConstantCountryNames();
        // Creates another ArrayList holding the country names.
        fillCountryArray();
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * 	Method		fillCountryArray()
     * 	Description     Fills the country ArrayList with the name of the countries.
     *        @author         <i>Seth Hillsberry</i>
     *  @see            java.util.ArrayList
     *  Date            12/02/2019
     *  History Log
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void fillCountryArray() {
        // Copies the constantCountryNames ArrayList to the countryNames ArrayList
        countryNames = new ArrayList<>(constantCountryNames);
        // Sets the numberOfCountries to the number of countries used.
        numberOfCountries = constantCountryNames.size();
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * 	Method		fillConstantCountryNames()
     * 	Description     fillConstantCountryNames
     *    @author         <i>Seth Hillsberry</i>
     *  Date            12/02/2019
     *  History Log
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void fillConstantCountryNames() {
        // Loops as many times as there are countries.
        for (int i = 0; i < countryList.size(); i++) {
            // Adds the name of the corresponding country to the constantCountryNames ArrayList.
            constantCountryNames.add(countryList.get(i).getName());
        }
        // Trims the size of the ArrayList to the number of countries used.
        constantCountryNames.trimToSize();
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * 	Method		randomizeCountryLabel()
     * 	Description     Selects a new unused conutry to set the image to.
     *    @author         <i>Seth Hillsberry</i>
     *  @return The name of the country selected.
     *  @see            java.util.Random
     *  Date            12/02/2019
     *  History Log
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public String randomizeCountryLabel() {
        // Clears the current Country
        String currentCountry = "";
        // Checks if there are unused countries
        if (countryNames.isEmpty() == false) {
            // Creates a new Random object
            Random countryIcon = new Random();
            // Gets a random index based on the number of countries left
            int randomCountryIndex = countryIcon.nextInt(numberOfCountries);
            // Sets the current country to the country of the random index
            currentCountry = countryNames.get(randomCountryIndex);
            // Removes the country name of the used country
            countryNames.remove(randomCountryIndex);
            // Shrinks the ArrayList to the new size.
            countryNames.trimToSize();
            // Shrinks the number of countries by one.
            numberOfCountries--;

        } else {
            // Displays a message showing you have done all the flags
            //JOptionPane.showMessageDialog(null, "All done");

        }
        // Returns the current country that the labels flag should be set to.
        return currentCountry;

    }
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * 	Method		readCountriesToObjects()
 * 	Description     Reads the countries from the country file to objects
 *        @author         <i>Seth Hillsberry</i>
 *   @see            java.io.BufferedReader
 *   @see            java.io.FileReader
 * 	Date            12/02/2019
 *   History Log
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
private void readCountriesToObjects() {
        // Clears the country object ArrayList
        countryList.clear();
        try {
            // Creates a string to hold the current countries line
            String currentCountryLine;
            // Creates a string array to hold the split country line
            String[] splitCountryLine;
            // Creates a buffered reader to read the country file
            // File list = new File("countryList.csv").getAbsoluteFile();
            //BufferedReader countryReader = new BufferedReader(new InputStreamReader(mgr.open("countryList.csv")));
            System.out.println(context.getFilesDir());
            BufferedReader countryReader = new BufferedReader(new FileReader(context.getFilesDir() + "/countrylist.csv"));

            // Checks if the next line is null and sets it to the current conutry line string
            countryReader.readLine();
            while ((currentCountryLine = countryReader.readLine()) != null) {
                // Splits the country line on commas, which separate the values
                splitCountryLine = currentCountryLine.split(",");
                // Uses the values from that line to construct a country object and adds that object to the country ArrayList
                countryList.add(new Country(splitCountryLine[0], Integer.parseInt(splitCountryLine[3]), Integer.parseInt(splitCountryLine[4]), splitCountryLine[1], splitCountryLine[2]));
            }
            // Closes the file reader
            countryReader.close();
            // Catches if the file does not exist
        } catch (FileNotFoundException ex) {
            // Tells the user the file does not exist
            //JOptionPane.showMessageDialog(null, "Country file location does not exist.");
            // catches IOExceptions
            System.out.println("FILE OES NOT EXIST");
            ex.printStackTrace();
        } catch (IOException ex) {
            // Tells the user that there is an IOException
            //JOptionPane.showMessageDialog(null, "IOException");
        }
    }

    public void writeObjectToJson() {
        ObjectMapper mapper = new ObjectMapper();


        try {
            mapper.writeValue(new File(context.getFilesDir() + "/countryList.json"), countryList);
        } catch (IOException e) {
            Log.e("Damn", Log.getStackTraceString(e));
        }


    }

    public void readCountriesFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(context.getFilesDir() + "/countryList.json");
            countryList = mapper.readValue(new File(context.getFilesDir() + "/countryList.json"), new TypeReference<ArrayList<Country>>() {
            });
            // listOfCountries = Arrays.asList(mapper.readValue(context.getFilesDir() + "/countrylist.json", Country[].class));        } catch (IOException e) {
            System.out.println("Country List:");
            System.out.println(countryList);
        } catch (JsonParseException e) {
            Log.e("Damn", Log.getStackTraceString(e));
        } catch (JsonMappingException e) {
            Log.e("Damn", Log.getStackTraceString(e));
        } catch (IOException e) {
            Log.e("Damn", Log.getStackTraceString(e));
        }
    }
}
