// Located in the flagquiz package
package com.example.flagquiz;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
*   Class           Players
*   File            Players.java
*   Description     A class representing all the saved and newly created players
*   @author         <i>Seth Hillsberry</i>
*   Environment     PC, Windows 10, NetBeans IDE 8.2, jdk 1.8.2
*   Date            12/02/2019
*   @version        1.0.0
*   History Log     
*   @see            
*</pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Players {
    // Player name
    private String name;
    // Player score
    private byte fullScore;
    // size of the test the player took
    private byte scoreDenominator;
    // dumb kill this variable
    private String continent;    
    // Year that the test was taken
    private int year;
    // Month the test was taken
    private int month;
    // Day the test was taken
    private int date;
    // Default constructor
    public Players(String name, byte fullScore, String continent, int year, int month, int date) {
        this.name = name;
        this.fullScore = fullScore;
        this.year = year;
        this.month = month;
        this.date = date;
        this.continent = continent;
    }
   
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getName()
    *	Description     Gets the name of the player.
    *	@author         <i>Seth Hillsberry</i>
    *   @return         The player name
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public String getName() {
        // Returns the player name
        return name;
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setName()
    *	Description     Sets the name of the player
    *	@param		name The name of the player
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public void setName(String name) {
        // Sets the name of the player.
        this.name = name;
    }
  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getFullScore()
    *	Description     Gets the score of the player
    *	@author         <i>Seth Hillsberry</i>
    *   @return         The score of the player
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public byte getFullScore() {
        // Returns the score of the player
        return fullScore;
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setFullScore()
    *	Description     Sets the score of the player
    *	@param		fullScore The score of the player
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    


    public void setFullScore(byte fullScore) {
        // Sets the score of the player
        this.fullScore = fullScore;
    }
  
  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getScoreDenominator()
    *	Description     Gets the number of questions the player had
    *	@author         <i>Seth Hillsberry</i>
    *   @return         The number of questions the player had
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public byte getScoreDenominator(){
        // Returns the number of questions the player had
        return scoreDenominator;
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getYear()
    *	Description     Gets the year the player played
    *	@author         <i>Seth Hillsberry</i>
    *   @return         The year the player played
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public int getYear(){
        // Returns the year the player played
        return year;
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getMonth()
    *	Description     Gets the month the player played
    *	@author         <i>Seth Hillsberry</i>
    *   @return         The month the player played
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public int getMonth(){
        // Returns the month the player played
        return month;
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getDate()
    *	Description     Gets the day the player played
    *	@author         <i>Seth Hillsberry</i>
    *   @return         The day the player played
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public int getDate(){
        // Returns the day the player played
        return date;
    }
   
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setYear()
    *	Description     Sets the year that the player played
    *	@param		year The player played
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public void setYear(int year){
        // Sets the year the player played
        this.year = year;
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setMonth()
    *	Description     Sets the month the player played
    *	@param		month The player played
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public void setMonth(int month){
        // Sets the month the player played
        this.month = month;
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setDate()
    *	Description     sets the say the player played
    *	@param		date The player played
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public void setDate(int date){
        // Sets the day the player played
        this.date = date;
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setScoreDenominator()
    *	Description     Sets the number of questions that the player used
    *	@param		scoreDenominator The number of questions that the player used
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public void setScoreDenominator(byte scoreDenominator){
        // Sets the number of questions the player used
        this.scoreDenominator = scoreDenominator;
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setContinent()
    *	Description     Sets the continent
    *	@param		continent the continent to set it to
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public void setContinent(String continent){
        this.continent = continent;
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getContinent()
    *	Description     gets the continent
    *	@author         <i>Seth Hillsberry</i>
    *   @return         the continent
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public String getContinent(){
        return continent;
    }

  
 
    
}
