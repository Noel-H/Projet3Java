package fr.openclassrooms.projet3.Model.modedejeu;

import fr.openclassrooms.projet3.Model.menu.MenuFinDePartie;
import fr.openclassrooms.projet3.Model.option.Configuration;
import fr.openclassrooms.projet3.Model.option.Utilitaires;

import java.util.Scanner;

/**
 * Cette class contient le mode de jeu "Challenger".
 *
 * @author NoelH
 */
public class ModeRechercheChallenger {

    /**
     *Methode pour le mode "Challenger".
     */
    public static void game() {
        do {

            int nombreDeChiffreATrouver = Configuration.NB_NUMBER_LENGTH;
            int nbTour=0;
            int loseCondition= Configuration.NB_TRY;

            System.out.println("Chiffre dans le code secret = " + nombreDeChiffreATrouver);

            String secretCode = Utilitaires.randomNumberGenerator(nombreDeChiffreATrouver);
            System.out.println("Le code secret est généré.");

            if (Configuration.DEVELOPPER_MODE){
                System.out.println("Developper Mode Solution = "+secretCode);
            }

            String playerReponse = "";

            boolean winConditionOk = false;

            while (!winConditionOk) {

                nbTour++;
                System.out.println("Tour n°"+nbTour+" sur "+loseCondition);

                boolean correctFormatValue = false;

                while (!correctFormatValue) {

                    System.out.println("Entrez une combinaisons de " + nombreDeChiffreATrouver + " chiffres.");

                    Scanner sc = new Scanner(System.in);

                    playerReponse = sc.nextLine();

                    if (!Utilitaires.tryCatchMethod(playerReponse, nombreDeChiffreATrouver)) {
                        System.out.println("Saisie incorrect.");
                    } else {
                        correctFormatValue = true;
                    }
                }

                String resultatEnOperator = Utilitaires.numberComparator(playerReponse, secretCode);

                System.out.println(Utilitaires.styleFormat1(playerReponse));
                System.out.println(Utilitaires.styleFormat1(resultatEnOperator));

                if (Utilitaires.winCondition(resultatEnOperator)) {
                    System.out.println("GG WP !!");
                    winConditionOk = true;
                } else if (loseCondition==nbTour){
                    System.out.println("Vous avez Perdu.");
                    System.out.println("Solution = "+ Utilitaires.styleFormat1(secretCode));
                    winConditionOk = true;
                }
            }
        } while (!MenuFinDePartie.enGameMenu());
    }
}