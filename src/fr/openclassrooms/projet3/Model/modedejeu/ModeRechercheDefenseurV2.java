package fr.openclassrooms.projet3.Model.modedejeu;

import fr.openclassrooms.projet3.Model.menu.MenuFinDePartie;
import fr.openclassrooms.projet3.Model.option.Configuration;
import fr.openclassrooms.projet3.Model.option.Utilitaires;

import java.util.Scanner;

/**
 *Cette class contient le mode de jeu "Defenseur".
 *
 * @author NoelH
 */
public class ModeRechercheDefenseurV2 {

    /**
     *Methode pour le mode "Defenseur".
     */
    public static void game() {

        do {

            int nbTour=0;
            int loseCondition= Configuration.NB_TRY;

            String secretCode = "";
            String testCode = "";
            String lastIndice = "";

            boolean correctFormatValue = false;

            while (!correctFormatValue) {

                System.out.println("Entrez une combinaisons de chiffre.");

                Scanner sc = new Scanner(System.in);

                secretCode = sc.nextLine();

                if (!Utilitaires.tryCatchMethod(secretCode, secretCode.length())) {
                    System.out.println("Saisie incorrect.");
                } else {
                    correctFormatValue = true;
                }
            }

            int DFM[][] = new int[secretCode.length()][3];

            boolean winConditionOk = false;

            while (!winConditionOk) {

                nbTour++;
                System.out.println("Tour n°"+nbTour+" sur "+loseCondition);

                if (lastIndice.equals("")) {
                    testCode = Utilitaires.rechercheDichotomique(DFM, secretCode.length());
                } else {
                    testCode = Utilitaires.rechercheDichotomique(DFM, lastIndice, testCode);
                }

                System.out.println(Utilitaires.styleFormat1(testCode));

                boolean correctFormatValue2 = false;

                while (!correctFormatValue2) {

                    System.out.println("Entrez l'indice.");

                    Scanner sc = new Scanner(System.in);

                    lastIndice = sc.nextLine();

                    if (!Utilitaires.indiceFormatVerification(lastIndice, secretCode.length())) {
                        System.out.println("Saisie incorrect.");
                    } else {
                        correctFormatValue2 = true;
                    }
                }

                if (Utilitaires.winCondition(lastIndice)) {
                    System.out.println("L'ordinateur a gagné. GG WP !!");
                    winConditionOk = true;
                }else if (loseCondition==nbTour){
                    System.out.println("L'ordinateur a perdu.");
                    System.out.println("Solution = "+ Utilitaires.styleFormat1(secretCode));
                    winConditionOk = true;
                }
            }
        } while (!MenuFinDePartie.enGameMenu());
    }
}