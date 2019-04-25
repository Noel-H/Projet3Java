import java.util.Scanner;

/**
 *Cette class contient le mode de jeu "Defenseur".
 *
 * @author NoelH
 */
public class ModeRechercheDefenseur {

    /**
     *Methode pour le mode "Defenseur".
     */
    static void game() {

        do {

            int nbTour=0;
            int loseCondition=Integer.parseInt(Main.config.getProperty("nb_try_defenseur", "6"));

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