package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * This class parses a string as a password, and determines the strength of the password depending on
 * 3 conditions the password is longer than 8 characters, has a special character,
 * and contains a number. Any password less than 8 characters is automatically considered weak,
 * any password that satisfies the length condition and one other condition is considered medium,
 * and a password that satisfies all 3 conditions is considered strong.
 *
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class PasswordSecurityHandler implements StringHandler {

    // Final constants to represent the security levels of a password
    public final String SECURITY_LEVEL_MAX = "strong";
    public final String SECURITY_LEVEL_MEDIUM = "medium";
    public final String SECURITY_LEVEL_MIN = "weak";

    // Length of password; must be greater or equal to 8 to be not considered weak
    private int length;

    // Flag for if password contains other character
    private boolean otherCharacter;

    // Flag for if password contains a number
    private boolean hasDigit;

    /**
     * No-arg constructor that sets default values to the instance variables
     */
    public PasswordSecurityHandler() {
        length = 0;
        otherCharacter = false;
        hasDigit = false;
    }

    /**
     * Checks flags associated with the handler object to determine whether the password
     * is strong, medium, or weak with the conditions described in the project header.
     *
     * @return Security level
     */
    public String securityLevel() {
        if (length >= 8) {
            if (otherCharacter && hasDigit) {
                return SECURITY_LEVEL_MAX;
            } else if (otherCharacter || hasDigit) {
                return SECURITY_LEVEL_MEDIUM;
            } else {
                return SECURITY_LEVEL_MIN;
            }
        } else {
            return SECURITY_LEVEL_MIN;
        }
    }


    /**
     * Processes if password has number 0-9;
     * Will flag that the password hasDigit, and will increment length.
     * @param c
     */
    @Override
    public void processDigit(char c) {
        hasDigit = true;
        length++;
    }

    /**
     * Processes if password has letter;
     * Will increment length.
     * @param c
     */
    @Override
    public void processLetter(char c) {
        length++;
    }

    /**
     * Processes if password has special character;
     * Will flag that password hasOtherChar, and increment length.
     * @param c
     */
    @Override
    public void processOther(char c) {
        otherCharacter = true;
        length++;
    }
}
