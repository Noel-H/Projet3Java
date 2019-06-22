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

    private static boolean leaveEndGameMenu=true;

    /**
     * Methode contenant le menu
     *
     * @return
     *          retourne un booleen pour sortir de la boucle.
     */

    public static boolean endGameMenu() {

        boolean validSelection=false;

//        while (!validSelection) {
//
//            displayEndGameMenu();
//
//            validSelection=executeUserChoice(getNumberSelection());
//        }
        return leaveEndGameMenu;
    }
}