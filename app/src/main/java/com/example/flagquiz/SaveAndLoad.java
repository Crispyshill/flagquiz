// Located in the flagquiz package
package com.example.flagquiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
*   Class           SaveAndLoad
*   File            SaveAndLoad.java
*   Description     Reads and writes player names and scores
*   @author         <i>Seth Hillsberry</i>
*   Environment     PC, Windows 10, NetBeans IDE 8.2, jdk 1.8.2
*   Date            12/02/2019
*   @version        1.0.0
*   History Log     
*</pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class SaveAndLoad {

    // The file location of the saved players file
    private final File fileLocation = new File("src/flagquiz/playerList.csv");
    // The column of the players name in the saved file
    private final byte COL_NAME = 0;
    // The column of the score in the saved file
    private final byte COL_FULL_SCORE = 1;
    // The column of the denominator of the score in the saved file
    private final byte COL_SMALL_SCORE = 2;
    // The column of the year in the saved file
    private final byte COL_YEAR = 3;
    // The column of the month in the saved file
    private final byte COL_MONTH = 4;
    // The column of the say in the saved file
    private final byte COL_DAY = 5;

    //list of player names
    private final ArrayList<String> playerNames = new ArrayList();
    // List of player objects
    final ArrayList<Players> playerList = new ArrayList();
    // List of Country objects
    private final ArrayList<Country> countryList = new ArrayList();

    //default constructor
    public SaveAndLoad() {
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		readPlayerNames()
    *	Description     Reads the names of the players into an ArrayList from the saved file
    *	@author         <i>Seth Hillsberry</i>
    *   @return         The ArrayList of the player names
    *   @see            java.io.BufferedReader
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    private ArrayList<String> readPlayerNames() {
            // Clears the ArrayList of player names
            playerNames.clear();
            // Shrinks the ArrayList to the number of player names.
            playerNames.trimToSize();
            // Creates a string to hold each player information
            try ( // Creates a BufferedReader to read the saved players file
                    BufferedReader playerFileReader = new BufferedReader(new FileReader(fileLocation))) {
                // Creates a string to hold each player information
                String playerString;
                // Checks if the next line is empty and sets the player string to that line
                while ((playerString = playerFileReader.readLine()) != null) {
                    // Splits the player info line into its values and stores it in playerStringArray
                    String[] playerStringArray = playerString.split(",");
                    // Sets the string playerName to the name of the player on that line
                    String playerName = playerStringArray[COL_NAME];
                    // Adds that players name to the playerName ArrayList
                    playerNames.add(playerName);
                }
                // Closes the player file reader
                // Catches if the player file does not exist
        } catch (FileNotFoundException ex) {
            // Tells the user that the file does not exist
           // JOptionPane.showMessageDialog(null, "Player file not found");
            // Catches an IOException
        } catch (IOException ex) {
            // Tells the user that there is an IOException
            //JOptionPane.showMessageDialog(null, "IOException");       // Find out what an IOException is.
        }
        // Returns the ArrayList of player names
        return playerNames;
    }

     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		writePlayerObjects()
    *	Description     Puts the information from the player objects into the saved player file
    *	@author         <i>Seth Hillsberry</i>
    *   @see            java.io.BufferedWriter
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public void writePlayerObjects() {
            // Writes nothing
            try ( // Creates a BufferedWriter to write to the saved players file
                    BufferedWriter bf = new BufferedWriter(new FileWriter(fileLocation))) {
                // Writes nothing
                bf.write("");
                // loops as many times as there are player objects
                for (int i = 0; i < playerList.size(); i++) {
                    // as long as its not the first one, put a newline in the file
                    if (i > 0){
                        // adds a newline to the file
                        bf.append("\n");
                    }
                    // write the rest of the information of the player object on the next line
                    bf.append(playerList.get(i).getName() + "," + playerList.get(i).getFullScore() + "," + playerList.get(i).getContinent() + "," + playerList.get(i).getYear() + "," + playerList.get(i).getMonth() + "," + playerList.get(i).getDate());
                }
                // closes the bufferedWriter
                // catches an IOException
        } catch (IOException ex) {
            // Tells the user that there is an IOException
          //  JOptionPane.showMessageDialog(null, "The thingy isnt working");
        }
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		readPlayersToObject()
    *	Description     Stores the saved player's information in a player object in an ArrayList
    *	@author         <i>Seth Hillsberry</i>
    *   @see            java.io.BufferedReader
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public void readPlayersToObjects() {
            // Clears the list of player objects
            playerList.clear();
            // Creates an array to hold the current line of player's information
            String[] currentLineRead;
            // Loops for each of the player names
            try ( // Creates a bufferedReader to read from the saved players file
                    BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
                // Loops for each of the player names
                for (String playerName : playerNames) {
                    // Splits the current line into its components and stores in a String array
                    currentLineRead = br.readLine().split(",");
                    // Constructs a player with the values from that array and stores it in the player object arrayList
                    playerList.add(new Players(currentLineRead[COL_NAME], Byte.parseByte(currentLineRead[COL_FULL_SCORE]), currentLineRead[COL_SMALL_SCORE], Integer.parseInt(currentLineRead[COL_YEAR]), Integer.parseInt(currentLineRead[COL_MONTH]), Integer.parseInt(currentLineRead[COL_DAY])));
                }   // Shrinks the arraylist to the size of the contents
                playerList.trimToSize();
                // Closes the file reader
                // Catches if the file does not exist
            }
         catch (FileNotFoundException ex) {
            // Tells the user that the file does not exist
            //JOptionPane.showMessageDialog(null, "The thingy isnt working");
            // Catches a IOEcxeption
        } catch (IOException ex) {
            // Tells the user that there is an IOException
            //JOptionPane.showMessageDialog(null, "The thingy isnt working");
        }
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		addNewPlayerLong()
    *	Description     Creates a new player object and adds it to the ArrayList
    *	@param		name The name of the new player
    *   @param          fullScore The score the player got
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public void addNewPlayerLong(String name, byte fullScore, String continent){
        // Creates a new date object
        Date todaysDate = new Date();
        // gets the current year
        int year = todaysDate.getYear() + 1900;
        // Gets the current month
        int month = todaysDate.getMonth();
        // Gets the current day
        int date = todaysDate.getDay();
        // REMOVE THIS CODE AND ADD A WAY TO CHECK WHAT DENOMINATOR THEY USE BERY IMPORTANTTTT!!!!!
        // Checks if the playerlist already has the name
        if (playerNames.contains(name)){
            // If the player exists, set the score of the player to their new score
            playerList.get(playerNames.indexOf(name)).setFullScore(fullScore);
            // Sets the new year
            playerList.get(playerNames.indexOf(name)).setYear(year);
            // Sets the new month
            playerList.get(playerNames.indexOf(name)).setMonth(month);
            // sets the new day 
            playerList.get(playerNames.indexOf(name)).setDate(date);
            // sets the continent
            playerList.get(playerNames.indexOf(name)).setContinent(continent);
        }
        // if the player does not exist:
        else{
            // Adds a newly created player with the new values the the ArrayList of players
        playerList.add(new Players(name, fullScore, continent, year, month, date));
        }
    }
    
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		addNewPlayerShort()
    *	Description     DEAD. KILL ME. I SHOULD NOT EXIST ANYMORE
    *	@param		args are the command line strings
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

//    public void addNewPlayerShort(String name, byte shortScore){
//        Date todaysDate = new Date();
//        int year = todaysDate.getYear() + 1900;
//        int month = todaysDate.getMonth();
//        int date = todaysDate.getDay();
//        byte fullScore = 0;
//         if (playerNames.contains(name)){
//            playerList.get(playerNames.indexOf(name)).setSmallScore(shortScore);
//            playerList.get(playerNames.indexOf(name)).setYear(year);
//            playerList.get(playerNames.indexOf(name)).setMonth(month);
//            playerList.get(playerNames.indexOf(name)).setDate(date);
//        }
//         else{
//        playerList.add(new Players(name, fullScore, shortScore, year, month, date));
//         }
//    }

    // getter for the player name ArrayList
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getPlayerNames()
    *	Description     reads the player names from the file and then returns it in an ArrayList
    *	@author         <i>Seth Hillsberry</i>
    *   @return         ArrayList of the player names
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public ArrayList getPlayerNames() {
        // Reads the player names from the player file
        readPlayerNames();
        // returns the player names
        return playerNames;
    }
    
}
