package edu.uwp.cs.csci242.assignments.a03.stringhandler;

import java.util.Scanner;

/**
 * This class is the main method for this project, and does most of the method calls and prompts
 * of the user for information to be parsed by the StringParser class
 *
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs
 * Because the handler class use int data types, hex values between 0 and FFFFFFFE
 * will work correctly, while anything greater will overflow.
 *
 * The solution would be to change the data types to longs or even veryLongs,
 * but honestly, who cares?
 */
public class MainDriver {

    /**
     * Main method that prompts user for information, and parses information correctly
     * @param args
     */
    public static void main(String[] args) {

        //Creates Scanner object for user input
        Scanner input = new Scanner(System.in);

        //Instantiates HexHandler object, and feeds that object as a parameter into StringParser object
        HexStringHandler hex = new HexStringHandler();
        StringParser parse = new StringParser(hex);

        //Prompts user for hexadecimal input to be parsed
        System.out.print("Enter a Hexadecimal Number: ");
        String hexNum = input.next();

        //Parses value with respect to a hexadecimal number
        parse.parse(hexNum);

        //Prints result to console
        System.out.println(hexNum + " - " + hex.getNumber());

        //Re-instantiates StringParser object as a new StringParser with a PasswordSecurityHandler object as a parameter
        PasswordSecurityHandler pass = new PasswordSecurityHandler();
        parse = new StringParser(pass);

        //Prompts user for password
        System.out.println("\nA strong password has at least eight\n" +
                "characters and contains at least one digit\n" +
                "and one special characters.");
        System.out.print("Enter a password > ");
        String password = input.next();

        //Parses value as password
        parse.parse(password);

        //Returns security level of password using securityLevel method found in PSH
        System.out.println("\n" + password + "'s security is: " + pass.securityLevel());


        System.out.println("YAY IT WORKS :D");

    }
}
