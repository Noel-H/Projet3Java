package fr.openclassrooms.projet3.Model.modedejeu;

import fr.openclassrooms.projet3.Model.Model;
import fr.openclassrooms.projet3.Model.menu.MenuFinDePartie;
import fr.openclassrooms.projet3.Model.option.Configuration;
import fr.openclassrooms.projet3.Model.option.Utilitaires;

import java.util.Scanner;

/**
 * Cette class contient le mode de jeu "Duel".
 *
 * @author NoelH
 */
public class ModeRechercheDuel {

    /**
     *Methode pour le mode "Duel".
     */
    public static void game() {

//        do {

            int nbTour=0;
            int loseCondition= Configuration.NB_TRY;

            String secretPlayerCode = "";

            String resultatOrdiEnOperator = "";
            String ordiResponse = "";

            boolean correctFormatValue = false;

            while (!correctFormatValue) {

                System.out.println("Pour génerer votre code secret, entrez une combinaisons de chiffre.");

                Scanner sc = new Scanner(System.in);

                secretPlayerCode = sc.nextLine();

                if (!Utilitaires.tryCatchMethod(secretPlayerCode, secretPlayerCode.length())) {
                    System.out.println("Saisie incorrect.");
                } else {
                    correctFormatValue = true;
                }
            }

            String secretOrdiCode = Utilitaires.randomNumberGenerator(secretPlayerCode.length());
            System.out.println("Le code secret de l'ordinateur est généré.");

            if (Configuration.DEVELOPPER_MODE){
                System.out.println("Developper Mode Solution = "+secretOrdiCode);
            }

            String playerReponse = "";

            int DFM[][] = new int[secretPlayerCode.length()][3];

            boolean winConditionOk = false;

            while (!winConditionOk) {

                nbTour++;
                System.out.println("Tour n°"+nbTour+" sur "+loseCondition);

                boolean correctFormatValue2 = false;

                while (!correctFormatValue2) {

                    System.out.println("Entrez une combinaisons de " + secretOrdiCode.length() + " chiffres.");

                    Scanner sc = new Scanner(System.in);

                    playerReponse = sc.nextLine();

                    if (!Utilitaires.tryCatchMethod(playerReponse, secretOrdiCode.length())) {
                        System.out.println("Saisie incorrect.");
                    } else {
                        correctFormatValue2 = true;
                    }
                }

                if (resultatOrdiEnOperator.equals("")) {
                    ordiResponse = Utilitaires.rechercheDichotomique(DFM, secretOrdiCode.length());
                } else {
                    ordiResponse = Utilitaires.rechercheDichotomique(DFM, resultatOrdiEnOperator, ordiResponse);
                }

                String resultatPlayerEnOperator = Utilitaires.numberComparator(playerReponse, secretOrdiCode);

                resultatOrdiEnOperator = Utilitaires.numberComparator(ordiResponse, secretPlayerCode);

                System.out.println(Utilitaires.styleFormat1(playerReponse));
                System.out.println(Utilitaires.styleFormat1(resultatPlayerEnOperator));
                System.out.println("---");
                System.out.println(Utilitaires.styleFormat1(ordiResponse));
                System.out.println(Utilitaires.styleFormat1(resultatOrdiEnOperator));

                if (Utilitaires.winCondition(resultatPlayerEnOperator)) {
                    System.out.println("Vous avez gagné, GG WP !!");
                    winConditionOk = true;
                } else if (Utilitaires.winCondition(resultatOrdiEnOperator)) {
                    System.out.println("Vous avez perdu.");
                    System.out.println("Le joueur devait trouver : "+ Utilitaires.styleFormat1(secretOrdiCode));
                    winConditionOk = true;
                }else if (loseCondition==nbTour){
                    System.out.println("Vous avez Perdu.");
                    System.out.println("Le joueur devait trouver : "+ Utilitaires.styleFormat1(secretOrdiCode));
                    System.out.println("L'ordinateur devait trouver : "+ Utilitaires.styleFormat1(secretPlayerCode));
                    winConditionOk = true;
                }
            }
//        } while (!Model.leaveEndGameMenu);
    }
}