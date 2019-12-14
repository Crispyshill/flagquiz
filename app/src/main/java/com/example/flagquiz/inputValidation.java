package flagquiz;

import java.util.regex.*;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
*   Class           inputValidation
*   File            inputValidation.java
*   Description     A class to validate different kinds of inputs.
*   @author         <i>Seth Hillsberry</i>
*   Environment     PC, Windows 10, NetBeans IDE 8.2, jdk 1.8.2
*   Date            12/02/2019
*   @version        1.0.0
*   History Log     
*   @see            java.util.regex
*</pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class inputValidation {
    // default contructor
    public inputValidation() {
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		validateName()
    *	Description     validates that strings are in the name format
    *	@param		name the name you want to validate
    *	@author         <i>Seth Hillsberry</i>
    *   @return         if the string is a proper name or not
    *	Date            12/02/2019
    *   History Log     
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

    public static boolean validateName(String name) {
        boolean result;
        // Checks if the string is a proper name using regular expressions
        result = Pattern.matches("^[A-Z][a-zA-Z]*\\s*[A-Z]*[a-zA-Z]*", name);
        // returns boolean of if the string fits a name properly
        return result;
    }
}
