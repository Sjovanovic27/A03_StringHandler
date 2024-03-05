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
public class PasswordSecurityHandler implements StringHandler {
    public final String SECURITY_LEVEL_MAX = "strong";
    public final String SECURITY_LEVEL_MEDIUM = "medium";
    public final String SECURITY_LEVEL_MIN = "weak";

    private int length;
    private boolean otherCharacter;
    private boolean hasDigit;

    public PasswordSecurityHandler() {
        length = 0;
        otherCharacter = false;
        hasDigit = false;
    }

    public String securityLevel() {
         if(length < 8) {
             return SECURITY_LEVEL_MIN;
         }
         else if(otherCharacter && hasDigit) {
             return SECURITY_LEVEL_MAX;
         }
         else {
             return SECURITY_LEVEL_MEDIUM;
         }
    }

    @Override
    public void processDigit(char c) {
        if(c >= 48 && c <= 57) {
            hasDigit = true;
            length++;
        }
    }

    @Override
    public void processLetter(char c) {
        if((c >= 65 & c <= 90)|(c >= 97 & c <= 122)) {
            length++;
        }
    }

    @Override
    public void processOther(char c) {
        if((c >= 33 & c <= 47) | (c >= 58 & c <= 64) | (c >= 91 & c <= 96) | (c >= 121 & c <= 126)) {
            otherCharacter = true;
            length++;
        }
    }
}
