package fr.openclassrooms.project3.view;

import fr.openclassrooms.project3.model.Model;

import java.util.Scanner;

/**
 *
 */
public class Displayer {

    /**
     * Menu de fin de jeu
     */
    private static void displayEndGameMenu(){
        System.out.println("Partie terminée. Voulez vous rejouez?");
        System.out.println("1 - Rejouer");
        System.out.println("2 - Menu Principal");
        System.out.println("3 - Quitter");
    }

    /**
     * Message de saisie incorrecte
     */
    private static void displayIncorrectEntryMessage(){
        System.out.println();
        System.out.println("Saisie incorrecte.");
        System.out.println("Veuillez recommencer");
        System.out.println();
    }

    /**
     * Message de fin de programme
     */
    private static void displayGoodByeMessage(){
        System.out.println();
        System.out.println("Bye bye.");
        System.out.println();
    }

    /**
     * Message de retour au Menu principal
     */
    private static void displayBackToMainMenuMessage(){
        System.out.println();
        System.out.println("Retour au Menu principal");
        System.out.println();
    }

    /**
     * Menu de selection de mode de jeu
     */
    private static void displayGameModeSelectionMenu(){
        System.out.println();
        System.out.println("Choisissez le mode de jeu voulu.");
        System.out.println("1 - Challenger");
        System.out.println("2 - Defenseur");
        System.out.println("3 - Duel");
        System.out.println("4 - Retour");
        System.out.println("5 - Quitter");
    }

    /**
     * Menu principal
     */
    private static void displayMainMenu(){
        System.out.println("Que voulez vous faire?");
        System.out.println("1 - Jouer (Mode +/-)");
        System.out.println("2 - Quitter");
    }

    /**
     * Methode pour recuperer la saisie utilisateur
     */
    public static String getUserEntry(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Methode permettant l'affichage des elements utiles
     */
    public static void display(){
        switch (Model.getInfo()) {
            case Model.INFO_ERROR_ENTRY:
                displayIncorrectEntryMessage();
                break;

            case Model.INFO_BYEBYE:
                displayGoodByeMessage();
                break;

            case Model.INFO_BACK_MAIN_MENU:
                displayBackToMainMenuMessage();
                break;

            default:
                break;
        }

        switch (Model.getMenu()){
            case Model.MENU_MAIN:
                displayMainMenu();
                break;

            case Model.MENU_MODE:
                displayGameModeSelectionMenu();
                break;

            case Model.MENU_END:
                displayEndGameMenu();
                break;
        }
    }
}