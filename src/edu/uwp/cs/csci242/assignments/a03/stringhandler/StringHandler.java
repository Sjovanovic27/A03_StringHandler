package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * StringHandler is an interface used by all handler objects in order to process the different components
 * of a string. This class separates the processing of chars in the string into letters, numbers, and
 * special characters, which is important since the different handler objects interprets the different
 * character types in different contexts.
 *
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */


public interface StringHandler {

    /**
     * Processes char 0-9
     * @param c
     */
    public void processDigit(char c);

    /**
     * Processes char [a-zA-Z]
     * @param c
     */
    public void processLetter(char c);

    /**
     * Processes any other non-alphanumeric ASCII character
     * @param c
     */
    public void processOther(char c);

}
