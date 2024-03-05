package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 *
 *
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */


public interface StringHandler {

    public void processDigit(char c);
    public void processLetter(char c);
    public void processOther(char c);

}
