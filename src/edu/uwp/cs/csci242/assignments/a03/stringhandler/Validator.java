package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * Validator is an interface used for any StringHandler class that needs to validate an input either before it can be
 * parsed, or before it can be returned. Since the conditions for determining validity are dependent on the
 * function of the class, this method needs to be implemented with respect to the desired output of the class.
 *
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */

public interface Validator {
    public boolean isValid();
}
