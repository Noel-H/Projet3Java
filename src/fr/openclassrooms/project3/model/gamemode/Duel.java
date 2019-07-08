package fr.openclassrooms.project3.model.gamemode;

import fr.openclassrooms.project3.model.option.Configuration;
import fr.openclassrooms.project3.model.option.Utility;

import java.util.Scanner;

/**
 * Cette class contient le mode de jeu "Duel".
 *
 * @author NoelH
 */
public class Duel {

    /**
     *Methode pour le mode "Duel".
     */
    public static void game() {
        int nbLap=0;
        int loseCondition= Configuration.NB_TRY;

        String secretPlayerCode = "";
        String computerAnswerToOperator = "";
        String computerAnswer = "";

        boolean correctFormatValue = false;

        while (!correctFormatValue) {

            System.out.println("Pour génerer votre code secret, entrez une combinaisons de chiffre.");

            Scanner sc = new Scanner(System.in);

            secretPlayerCode = sc.nextLine();

            if (!Utility.tryCatchMethod(secretPlayerCode, secretPlayerCode.length())) {
                System.out.println("Saisie incorrect.");
            } else {
                correctFormatValue = true;
            }
        }

        String secretComputerCode = Utility.randomNumberGenerator(secretPlayerCode.length());
        System.out.println("Le code secret de l'ordinateur est généré.");

        if (Configuration.DEVELOPPER_MODE){
            System.out.println("Developper Mode Solution = "+secretComputerCode);
        }

        String playerAnswer = "";

        int DFM[][] = new int[secretPlayerCode.length()][3];

        boolean winConditionValidation = false;

        while (!winConditionValidation) {

            nbLap++;
            System.out.println("Tour n°"+nbLap+" sur "+loseCondition);

            boolean correctFormatValue2 = false;

            while (!correctFormatValue2) {

                System.out.println("Entrez une combinaisons de " + secretComputerCode.length() + " chiffres.");

                Scanner sc = new Scanner(System.in);

                playerAnswer = sc.nextLine();

                if (!Utility.tryCatchMethod(playerAnswer, secretComputerCode.length())) {
                    System.out.println("Saisie incorrect.");
                } else {
                    correctFormatValue2 = true;
                }
            }

            if (computerAnswerToOperator.equals("")) {
                computerAnswer = Utility.rechercheDichotomique(DFM, secretComputerCode.length());
            } else {
                computerAnswer = Utility.rechercheDichotomique(DFM, computerAnswerToOperator, computerAnswer);
            }

            String resultatPlayerEnOperator = Utility.numberComparator(playerAnswer, secretComputerCode);

            computerAnswerToOperator = Utility.numberComparator(computerAnswer, secretPlayerCode);

            System.out.println(Utility.styleFormat1(playerAnswer));
            System.out.println(Utility.styleFormat1(resultatPlayerEnOperator));
            System.out.println("---");
            System.out.println(Utility.styleFormat1(computerAnswer));
            System.out.println(Utility.styleFormat1(computerAnswerToOperator));

            if (Utility.winCondition(resultatPlayerEnOperator)) {
                System.out.println("Vous avez gagné, GG WP !!");
                winConditionValidation = true;
            } else if (Utility.winCondition(computerAnswerToOperator)) {
                System.out.println("Vous avez perdu.");
                System.out.println("Le joueur devait trouver : "+ Utility.styleFormat1(secretComputerCode));
                winConditionValidation = true;
            }else if (loseCondition == nbLap){
                System.out.println("Vous avez Perdu.");
                System.out.println("Le joueur devait trouver : "+ Utility.styleFormat1(secretComputerCode));
                System.out.println("L'ordinateur devait trouver : "+ Utility.styleFormat1(secretPlayerCode));
                winConditionValidation = true;
            }
        }
    }
}