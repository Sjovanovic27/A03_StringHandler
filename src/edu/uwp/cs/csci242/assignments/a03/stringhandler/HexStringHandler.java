package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class HexStringHandler implements StringHandler, Validator {

    public final int INVALID_NUMBER = -1;
    public final int NUMBER_SYSTEM = 16;
    public final int NUMBER_LETTER_MIN = 10;
    public final int NUMBER_LETTER_MAX = 16;
    private boolean validHex;
    private int number;
    private int place;

    public HexStringHandler() {
        number = 0;
        validHex = true;
        place = 0;
    }

    public boolean isValid() {
        return validHex;
    }

    public int getNumber() {
        if (validHex)
            return number;
        else
            return INVALID_NUMBER;
    }

    @Override
    public void processDigit(char c) {
        if( c >= '0' & c <= '9') {
            number += (c - '0') * (int) (Math.pow((double) NUMBER_SYSTEM, (double) place));
            place++;
        }
    }

    @Override
    public void processLetter(char c) {
        if (c >= 'A' & c <= 'F') {
            number += (c - 'A' + NUMBER_LETTER_MIN) * (int) (Math.pow((double) NUMBER_SYSTEM, (double) place));
            place++;
        }
    }

    @Override
    public void processOther(char c) {
        if(!((c >= 'A' & c <= 'F')|( c >= '0' & c <= '9'))) {
            validHex = false;
        }
    }

}


