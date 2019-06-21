package fr.openclassrooms.projet3.Model.menu;

import java.util.Scanner;

/**
 *Class contenant le menu principal
 *
 * @author NoelH
 */
public class MenuPrincipal {

    public static String getUserEntry(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void displayPrincipalMenu(){
        System.out.println("Que voulez vous faire?");
        System.out.println("1 - Jouer (Mode +/-)");
        System.out.println("2 - Quitter");
    }

    public static void displayIncorrectEntryMessage(){
        System.out.println();
        System.out.println("Saisie incorrecte.");
        System.out.println("Veuillez recommencer");
        System.out.println();
    }

    public static void displayGoodByeMessage(){
        System.out.println();
        System.out.println("Bye bye.");
        System.out.println();
    }

    public static int getNumberSelection(){
        try {

            return Integer.parseInt(getUserEntry());

        } catch (NumberFormatException e) {

            return -1;
        }

    }

    public static boolean executeUserChoice(int userChoice) {
        switch (userChoice) {
            case 1:

                MenuSelectionDeMode.modeDeJeuMenu();
                return false;
            case 2:

                displayGoodByeMessage();

                System.exit(0);

                return true;

            default:

                displayIncorrectEntryMessage();

                return false;
        }
    }

    /**
     *Methode du menu principal
     */
    public static void principalMenu() {

        boolean correctSelection = false;

        while (!correctSelection) {

            displayPrincipalMenu();

            correctSelection=executeUserChoice(getNumberSelection());
        }
    }
}