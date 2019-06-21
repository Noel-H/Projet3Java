package fr.openclassrooms.projet3.Model.menu;

import fr.openclassrooms.projet3.Model.modedejeu.ModeRechercheChallenger;
import fr.openclassrooms.projet3.Model.modedejeu.ModeRechercheDuel;
import fr.openclassrooms.projet3.Model.modedejeu.ModeRechercheDefenseurV2;

import java.util.Scanner;

/**
 * Cette class est un menu permettant la selection du mode de jeu.
 *
 * @author NoelH
 */
public class MenuSelectionDeMode {

    public static void displayGameModeSelectionMenu(){
        System.out.println();
        System.out.println("Choisissez le mode de jeu voulu.");
        System.out.println("1 - Challenger");
        System.out.println("2 - Defenseur");
        System.out.println("3 - Duel");
        System.out.println("4 - Retour");
        System.out.println("5 - Quitter");
    }

    public static String getUserEntry(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
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

    public static boolean executeUserChoice(int userChoice){
        switch (userChoice) {

            case 1:
                ModeRechercheChallenger.game();
                return true;

            case 2:
                ModeRechercheDefenseurV2.game();
                return true;

            case 3:
                ModeRechercheDuel.game();
                return true;

            case 4:
                return true;

            case 5:
                displayGoodByeMessage();
                System.exit(0);
                return true;

            default:
                displayIncorrectEntryMessage();
                return false;
        }
    }


    /**
     *Cette methode permet de choisir un mode de jeu.
     */
    public static void modeDeJeuMenu() {

        boolean correctSelection = false;

        while (!correctSelection) {
                    displayGameModeSelectionMenu();

                correctSelection= executeUserChoice(getNumberSelection());
        }
    }
}