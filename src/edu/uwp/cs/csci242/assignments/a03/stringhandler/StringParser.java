package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * This class contains the parse method, which is usable by any StringHandler object.
 * <p>
 * The parse method will do something different depending on what class is calling the method,
 * and instanceof is used in order to differentiate the different functions
 *
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class StringParser {

    // Handler used by parse method
    private StringHandler handler;

    /**
     * 1-arg constructor
     * takes in handler object to be used as reference for parse method
     * @param handler
     */
    public StringParser(StringHandler handler) {
        this.handler = handler;
    }

    /**
     * The big boy
     * <p>
     *     The parse method uses the StringHandler type specified in the constructor to set up an array
     *     of chars from the string parameter to be read by the StringHandler. This method reads through
     *     the char array, and feeds each input into the three process methods, which have their own checks
     *     to ensure that the correct character type is being fed into each method.
     * </p>
     * @param s
     */
    public void parse(String s) {

        char[] c = new char[0];

        if (this.getHandler() instanceof HexStringHandler) {
            c = new StringBuilder(s).reverse().toString().toCharArray();
        } else if (this.getHandler() != null) {
            c = s.toCharArray();
        } else {
            System.out.println("Uh oh, somethings gone REALLY wrong");
            System.exit(2);
        }

        for (char i : c) {
            if (i >= 'a' & i <= 'z' | i >= 'A' & i <= 'Z')
                getHandler().processLetter(i);
            else if (i >= '0' & i <= '9')
                getHandler().processDigit(i);
            else
                getHandler().processOther(i);
        }


    }

    /**
     * Accessor method for handler object
     * @return handler object;
     */
    public StringHandler getHandler() {
        return handler;
    }
}
