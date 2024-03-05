package edu.uwp.cs.csci242.assignments.a03.stringhandler;

import java.util.Scanner;

/**
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class MainDriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        HexStringHandler hex = new HexStringHandler();
        StringParser parse = new StringParser(hex);

        System.out.print("Enter a Hexadecimal Number: ");
        String hexNum = input.next();

        parse.parse(hexNum);


        System.out.println(hexNum + " - " + hex.getNumber());

        PasswordSecurityHandler pass = new PasswordSecurityHandler();
        parse = new StringParser(pass);
        System.out.println("\nA strong password has at least eight\n" +
                "characters and contains at least one digit\n" +
                "and one special characters.");
        System.out.print("Enter a password > ");
        String password = input.next();

        parse.parse(password);

        System.out.println("\n" + password + "'s security is: " + pass.securityLevel());

        System.out.println("YAY IT WORKS :D");

    }
}
