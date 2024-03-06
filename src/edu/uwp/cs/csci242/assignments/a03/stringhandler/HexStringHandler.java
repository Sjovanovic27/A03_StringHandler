package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
 * This class is used to handle the parsing of hexadecimal values through the various process"char" methods.
 * Numbers and Letters between 'A' and 'F' are processed correctly, and any other character invalidates the
 * hex, which causes an intended return of INVALID_NUMBER (-1). In String parser, the String is reversed
 * before being read, as Hexes are read right to left.
 *
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs Any hex value over FFFFFFFE will overflow, referenced in MainDriver class.
 */
public class HexStringHandler implements StringHandler, Validator {

    // Used constants for hexadecimal system
    // Invalid number is default return value if fed an invalid hex number
    public final int INVALID_NUMBER = -1;
    public final int NUMBER_SYSTEM = 16;
    public final int NUMBER_LETTER_MIN = 10;

    //flag that determines whether or not the input hex is valid
    private boolean validHex;

    // numerical value of hex
    private int number;

    // placeholder counter that holds the power of 16 that is currently
    // being read to allow for easy translation from hex to base 10.
    private int place;

    /**
     * No-arg Constructor
     * sets all instance variables to default values
     */
    public HexStringHandler() {
        number = 0;
        validHex = true;
        place = 0;
    }

    /**
     * Accessor method for validHex variable
     *
     * @return flag that checks if hex is a valid hex
     */
    public boolean isValid() {
        return validHex;
    }

    /**
     * Accessor method for number variable
     *
     * @return base 10 value of hex number
     */
    public int getNumber() {
        if (isValid())
            return number;
        else
            return INVALID_NUMBER;
    }

    /**
     * Overrides method from StringHandler class
     * <p>
     * Takes in digits 0-9, and multiplies the digit's value to the power of 16 determined by its position in the hex.
     * Increments place variable to signify that the position of the hex has increased
     */
    @Override
    public void processDigit(char c) {
        number += (c - '0') * (int) (Math.pow((double) NUMBER_SYSTEM, (double) place));
        place++;
    }

    /**
     * Takes in letters [a-zA-Z], and checks if the input letters fall between A-F, in which case it
     * multiplies their numeric equivalent values by the power of 16, or if the letters don't fall
     * within that range, the hex is invalidated
     * @param c
     */
    @Override
    public void processLetter(char c) {
        if (c >= 'A' & c <= 'F') {
            number += (c - 'A' + NUMBER_LETTER_MIN) * (int) (Math.pow((double) NUMBER_SYSTEM, (double) place));
            place++;
        } else {
            validHex = false;
        }
    }

    /**
     * Takes in any other character in the ASCII table, and, if this method is called, the hex will immediately invalidate
     * @param c
     */
    @Override
    public void processOther(char c) {
        validHex = false;
    }

}


