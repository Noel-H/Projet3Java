package fr.openclassrooms.projet3.Model.menu;

import fr.openclassrooms.projet3.Model.modedejeu.ModeRechercheChallenger;
import fr.openclassrooms.projet3.Model.modedejeu.ModeRechercheDefenseurV2;
import fr.openclassrooms.projet3.Model.modedejeu.ModeRechercheDuel;

import java.util.Scanner;

/**
 * Cette class est un menu permettant de faire un choix a la fin d'une partie.
 *
 *<p><b>Exemple de partie :</b></p>
 * @see ModeRechercheChallenger
 * @see ModeRechercheDefenseurV2
 * @see ModeRechercheDuel
 * @author NoelH
 */
public class MenuFinDePartie {

    private static boolean leaveEndGameMenu;

    public static void displayEndGameMenu(){
        System.out.println("Partie terminée. Voulez vous rejouez?");
        System.out.println("1 - Rejouer");
        System.out.println("2 - Menu Principal");
        System.out.println("3 - Quitter");
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

    public static void displayBackToPrincipalMenuMessage(){
        System.out.println();
        System.out.println("Retour au Menu principal");
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

                leaveEndGameMenu=false;

                return true;
            case 2:

                displayBackToPrincipalMenuMessage();

                leaveEndGameMenu=true;

                return true;

            case 3:

                displayGoodByeMessage();

                System.exit(0);

                return true;

            default:

                displayIncorrectEntryMessage();

                return false;
        }
    }


    /**
     * Methode contenant le menu
     *
     * @return
     *          retourne un booleen pour sortir de la boucle.
     */

    public static boolean endGameMenu() {

        boolean validSelection=false;

        while (!validSelection) {

            displayEndGameMenu();

            validSelection=executeUserChoice(getNumberSelection());
        }
        return leaveEndGameMenu;
    }
}