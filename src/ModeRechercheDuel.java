import java.util.Scanner;

public class ModeRechercheDuel {

    static void game() {

        do {

            int nbTour=0;

            String secretPlayerCode = "";

            String resultatOrdiEnOperator = "";
            String ordiResponse = "";

            boolean correctFormatValue = false;

            while (!correctFormatValue) {

                System.out.println("Pour généré votre code secret, entrez une combinaisons de chiffre.");

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

            String playerReponse = "";

            int DFM[][] = new int[secretPlayerCode.length()][3];
            for (int i = 0; i < secretPlayerCode.length(); i++) {
                DFM[i][0] = 0;
                DFM[i][1] = 10;
                DFM[i][2] = (DFM[i][0] + DFM[i][1]) / 2;
            }

            boolean winConditionOk = false;

            while (!winConditionOk) {

                nbTour++;
                System.out.println("Tour n°"+nbTour+".");

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
                    winConditionOk = true;
                }
            }
        } while (!MenuFinDePartie.enGameMenu());
    }
}