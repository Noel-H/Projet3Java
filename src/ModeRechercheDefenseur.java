import java.util.Scanner;

public class ModeRechercheDefenseur {

    static void game() {

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

            if (lastIndice.equals("")) {
                testCode = Utilitaires.rechercheDichotomique(DFM, secretCode.length());
            } else {
                testCode = Utilitaires.rechercheDichotomique(DFM, lastIndice, testCode);
            }

            lastIndice = Utilitaires.numberComparator(testCode, secretCode);
            System.out.println(Utilitaires.styleFormat1(testCode));
            System.out.println(Utilitaires.styleFormat1(lastIndice));

            if (Utilitaires.winCondition(lastIndice)) {
                System.out.println("GG WP !!");
                winConditionOk = true;
            }
        }

        MenuFinDePartie.enGameMenu();
    }
}