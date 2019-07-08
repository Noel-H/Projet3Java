package fr.openclassrooms.project3.model.gamemode;

import fr.openclassrooms.project3.model.option.Configuration;
import fr.openclassrooms.project3.model.option.Utility;

import java.util.Scanner;

/**
 *Cette class contient le mode de jeu "Defenseur".
 *
 * @author NoelH
 */
public class Defender {

    /**
     *Methode pour le mode "Defenseur".
     */
    public static void game() {
        int nbLap = 0;
        int loseCondition = Configuration.NB_TRY;

        String secretCode = "";
        String testCode = "";
        String lastOperatorAnswer = "";

        boolean correctFormatValue = false;

        while (!correctFormatValue) {

            System.out.println("Entrez une combinaisons de chiffre.");

            Scanner sc = new Scanner(System.in);

            secretCode = sc.nextLine();

            if (!Utility.tryCatchMethod(secretCode, secretCode.length())) {
                System.out.println("Saisie incorrect.");
            } else {
                correctFormatValue = true;
            }
        }

        int DFM[][] = new int[secretCode.length()][3];

        boolean winConditionValidation = false;

        while (!winConditionValidation) {

            nbLap++;

            System.out.println("Tour n°"+nbLap+" sur "+loseCondition);

            if (lastOperatorAnswer.equals("")) {
                testCode = Utility.rechercheDichotomique(DFM, secretCode.length());
            } else {
                testCode = Utility.rechercheDichotomique(DFM, lastOperatorAnswer, testCode);
            }

            System.out.println(Utility.styleFormat1(testCode));

            boolean correctFormatValue2 = false;

            while (!correctFormatValue2) {

                System.out.println("Entrez l'indice.");

                Scanner sc = new Scanner(System.in);

                lastOperatorAnswer = sc.nextLine();

                if (!Utility.indiceFormatVerification(lastOperatorAnswer, secretCode.length())) {
                    System.out.println("Saisie incorrect.");
                } else {
                    correctFormatValue2 = true;
                }
            }

            if (Utility.winCondition(lastOperatorAnswer)) {
                System.out.println("L'ordinateur a gagné. GG WP !!");
                winConditionValidation = true;
            }else if (loseCondition == nbLap){
                System.out.println("L'ordinateur a perdu.");
                System.out.println("Solution = "+ Utility.styleFormat1(secretCode));
                winConditionValidation = true;
            }
        }
    }
}