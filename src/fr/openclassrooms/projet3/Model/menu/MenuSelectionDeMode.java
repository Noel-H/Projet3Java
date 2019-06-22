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

    public static String getUserEntry(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int getNumberSelection(){
        try {

           return Integer.parseInt(getUserEntry());

        } catch (NumberFormatException e) {

            return -1;
        }
    }




    /**
     *Cette methode permet de choisir un mode de jeu.
     */
//    public static void modeDeJeuMenu() {
//
//        boolean correctSelection = false;
//
//        while (!correctSelection) {
//                    displayGameModeSelectionMenu();
//
//                correctSelection= executeUserChoice(getNumberSelection());
//        }
//    }
}