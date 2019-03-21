import java.util.Scanner;

public class ModeRechercheDefenseur {

    static void game() {

        do {

            int nbTour=0;
            int loseCondition=6;

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
            for (int i = 0; i < secretCode.length(); i++) {
                DFM[i][0] = 0;
                DFM[i][1] = 10;
                DFM[i][2] = (DFM[i][0] + DFM[i][1]) / 2;
            }

            boolean winConditionOk = false;

            while (!winConditionOk) {

                nbTour++;
                System.out.println("Tour n°"+nbTour+" sur "+loseCondition);

                if (lastIndice.equals("")) {
                    testCode = Utilitaires.rechercheDichotomique(DFM, secretCode.length());
                } else {
                    testCode = Utilitaires.rechercheDichotomique(DFM, lastIndice, testCode);
                }

                lastIndice = Utilitaires.numberComparator(testCode, secretCode);
                System.out.println(Utilitaires.styleFormat1(testCode));
                System.out.println(Utilitaires.styleFormat1(lastIndice));

                if (Utilitaires.winCondition(lastIndice)) {
                    System.out.println("L'ordinateur a gagné. GG WP !!");
                    winConditionOk = true;
                }else if (loseCondition==nbTour){
                    System.out.println("L'ordinateur a perdu.");
                    System.out.println("Solution = "+Utilitaires.styleFormat1(secretCode));
                    winConditionOk = true;
                }
            }
        } while (!MenuFinDePartie.enGameMenu());
    }
}