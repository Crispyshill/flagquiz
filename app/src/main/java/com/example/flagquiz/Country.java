// Located in the flagquiz package
package com.example.flagquiz;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
*   Class           
*   File            Country.java
*   Description     Class to make object containing all the countries information
*   @author         <i>Seth Hillsberry</i>
*   Environment     PC, Windows 10, NetBeans IDE 8.2, jdk 1.8.2
*   Date            12/02/2019
*   @version        1.0.0   
*   History Log     
*</pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Country {
   // The name of the country.
   private String name;
   // The population of the country.
   private int population;
   // The GDP of the ocuntry.
   private int GDP;
   // The capital of the country.
   private String capital;
   // The continent of the country.
   private String continent;

   public Country(){

   }

   // Default constructor requireing name, population, GDP, capital, and continent
    public Country(String name, int population, int GDP, String capital, String continent) {
        // Sets the name of the country.
        this.name = name;
        // Sets the population of the country.
        this.population = population;
        // Sets the capital of the country.
        this.capital = capital;
        // Sets the continent of the country.
        this.continent = continent;
        // Sets the GDP of the country.
        this.GDP = GDP;
    }
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getName()
    *	Description     Returns the name variable
    *	@author         <i>Seth Hillsberry</i>
    *   @return         Name of the country
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public String getName() {
        // Returns the name of the country.
        return name;
    }
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setName()
    *	Description     Sets the name of the country to the paramater string.
    *	@param		name the name of the country
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public void setName(String name) {
        // Sets the name of the country.
        this.name = name;
    }
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getPopulation()
    *	Description     returns the number of people in the country
    *	@author         <i>Seth Hillsberry</i>
    *   @return         The number of people in the country
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public int getPopulation() {
        // Returns the population of the country.
        return population;
    }
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setPopulation()
    *	Description     Sets the number of people in the country.
    *	@param		population the number of people in the country.
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public void setPopulation(int population) {
        // Sets the population of the country.
        this.population = population;
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setGDP()
    *	Description     Sets the GDP of the country.
    *   @param          GDP the GDP of the country.
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public void setGDP(int GDP){
        // Sets the GDP of the country.
        this.GDP = GDP;
    }
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getCapital()
    *	Description     Returns the name of the countries capital.
    *	@author         <i>Seth Hillsberry</i>
    *   @return         The name of the capital
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public String getCapital() {
        // Returns the capital of the country.
        return capital;
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getGDP()
    *	Description     Gets the GDP of the country
    *	@author         <i>Seth Hillsberry</i>
    *   @return         The GDP of the country
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public int getGDP(){
        // Returns the GDP of the country.
        return GDP;
    }
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setCapital()
    *	Description     Sets the name of the capital of the country.
    *	@param		capital the capital of the country.
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public void setCapital(String capital) {
        // Sets the capital of the country.
        this.capital = capital;
    }
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		getContinent()
    *	Description     Gets the name of the continent the country is on.
    *	@author         <i>Seth Hillsberry</i>
    *   @return         The name of the continent the country is on.
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public String getContinent() {
        // Returns the continent of the country.
        return continent;
    }
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		setContinent()
    *	Description     Sets the name of the continent the country is on.
    *	@param		continent the name of the continent the country is on.
    *	@author         <i>Seth Hillsberry</i>
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public void setContinent(String continent) {
        // Sets the continent of the country.
        this.continent = continent;
    }
    
}
