package edu.uwp.cs.csci242.assignments.a03.stringhandler;

/**
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

    public void parse(String s) {


        if (this.getHandler() instanceof PasswordSecurityHandler) {
            char[] c = s.toCharArray();
            for (char i : c) {
                getHandler().processDigit(i);
                getHandler().processLetter(i);
                getHandler().processOther(i);
            }
        } else if (this.getHandler() instanceof HexStringHandler) {
            char[] c = new StringBuilder(s).reverse().toString().toCharArray();

            for(char i: c) {
                getHandler().processOther(i);
                getHandler().processLetter(i);
                getHandler().processDigit(i);
            }

        } else {
            System.out.println("Uh oh, somethings gone REALLY wrong");
        }
    }

    public StringHandler getHandler() {
        return handler;
    }

    public static void main(String[] args) {

    }
}
