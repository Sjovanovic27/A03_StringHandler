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
public class StringParser {
    private StringHandler handler;

    public StringParser(StringHandler handler) {
        this.handler = handler;
    }

    public void parse(String s) throws Exception {

        char[] c = s.toCharArray();

        if(this.getHandler() instanceof PasswordSecurityHandler) {
            for(char i: c) {
                getHandler().processDigit(i);
                getHandler().processLetter(i);
                getHandler().processOther(i);
            }
        }
        else if(this.getHandler() instanceof HexStringHandler) {

        }
        else {
            throw new IllegalStateException("Invalid Handler object");
        }
    }

    public StringHandler getHandler() {
        return handler;
    }

    public static void main(String[] args) {

    }
}
