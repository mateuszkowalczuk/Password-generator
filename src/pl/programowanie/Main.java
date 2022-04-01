package pl.programowanie;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("PASSWORD GENERATOR");
        System.out.println("------------------");
        System.out.print("Enter the password length: ");

        Scanner number = new Scanner(System.in);
        int numberOfCharacters = 0;

        while(numberOfCharacters == 0) {
            try {
                numberOfCharacters = number.nextInt();
                if (numberOfCharacters <= 5){
                    numberOfCharacters = 0;
                    System.out.print("Password is too short. Enter at least 6 characters: ");
                }
            } catch (InputMismatchException e){
                System.out.print("Incorrect character. Try again: ");
                number.next();
            }
        }

        char[] password = new char[numberOfCharacters];
        String characters = "";

        Scanner choice = new Scanner(System.in);
        System.out.print("Small letters?(y/n): ");
        String smallLettersChoice = choice.nextLine();
        switch (smallLettersChoice) {
            case "y", "Y" -> characters += "abcdefghijklmnopqrstuvwxyz";
            case "n", "N" -> System.out.print("");
            default -> System.out.println("Incorrect character.");
        }

        System.out.print("Capital letters?(y/n): ");
        String capitalLettersChoice = choice.nextLine();
        switch (capitalLettersChoice) {
            case "y", "Y" -> characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            case "n", "N" -> System.out.print("");
            default -> System.out.println("Incorrect character.");
        }

        System.out.print("Digits?(y/n): ");
        String digitsChoice = choice.nextLine();
        switch (digitsChoice) {
            case "y", "Y" -> characters += "0123456789";
            case "n", "N" -> System.out.print("");
            default -> System.out.println("Incorrect character.");
        }

        System.out.print("Special characters?(y/n): ");
        String specialCharsChoice = choice.nextLine();
        switch (specialCharsChoice) {
            case "y", "Y" -> characters += "!@#$%^&*?/";
            case "n", "N" -> System.out.print("");
            default -> System.out.println("Incorrect character.");
        }

            char[] chars = characters.toCharArray();
            System.out.print("Generated password: ");
            for (int i = 0; i < numberOfCharacters; i++)
                System.out.print(password[i] = chars[(int) (Math.random() * chars.length)]);
    }
}