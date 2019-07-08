package fr.openclassrooms.project3.model.gamemode;

import fr.openclassrooms.project3.model.option.Configuration;
import fr.openclassrooms.project3.model.option.Utility;

import java.util.Scanner;

/**
 * Cette class contient le mode de jeu "Challenger".
 *
 * @author NoelH
 */
public class Challenger {

    /**
     *Methode pour le mode "Challenger".
     */
    public static void game() {
        int numberOfDigitsToFind = Configuration.NB_DIGITS;
        int nbLap = 0;
        int loseCondition = Configuration.NB_TRY;

        System.out.println("Chiffre dans le code secret = " + numberOfDigitsToFind);

        String secretCode = Utility.randomNumberGenerator(numberOfDigitsToFind);
        System.out.println("Le code secret est généré.");

        if (Configuration.DEVELOPPER_MODE){
            System.out.println("Developper Mode Solution = "+secretCode);
        }

        String playerAnswer = "";

        boolean winConditionOk = false;

        while (!winConditionOk) {
            nbLap++;

            System.out.println("Tour n°"+nbLap+" sur "+loseCondition);

            boolean correctFormatValue = false;

            while (!correctFormatValue) {

                System.out.println("Entrez une combinaisons de " + numberOfDigitsToFind + " chiffres.");

                Scanner sc = new Scanner(System.in);

                playerAnswer = sc.nextLine();

                if (!Utility.tryCatchMethod(playerAnswer, numberOfDigitsToFind)) {
                    System.out.println("Saisie incorrect.");
                } else {
                    correctFormatValue = true;
                }
            }

            String operatorSigns = Utility.numberComparator(playerAnswer, secretCode);

            System.out.println(Utility.styleFormat1(playerAnswer));
            System.out.println(Utility.styleFormat1(operatorSigns));

            if (Utility.winCondition(operatorSigns)) {
                System.out.println("GG WP !!");
                winConditionOk = true;
            } else if (loseCondition == nbLap){
                System.out.println("Vous avez Perdu.");
                System.out.println("Solution = "+ Utility.styleFormat1(secretCode));
                winConditionOk = true;
            }
        }
    }
}