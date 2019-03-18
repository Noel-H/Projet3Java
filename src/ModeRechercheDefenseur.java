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

        int DFM[][] = new int[secretCode.length()][4];
        for (int i = 0; i < secretCode.length(); i++) {
            DFM[i][0] = 0;
            DFM[i][1] = 0;
            DFM[i][2] = 10;
            DFM[i][3] = (DFM[i][1] + DFM[i][2]) / 2;
        }


        boolean winConditionOk = false;

        while (!winConditionOk) {

            if (lastIndice.equals("")) {
                testCode = Utilitaires.number4Generator(secretCode.length());

            } else {
//                testCode = Utilitaires.rechercheDichotomique(testCode, lastIndice);

                for (int i = 0; i < secretCode.length(); i++) {
                    if (Character.toString(lastIndice.charAt(i)).equals("+")) {

                        DFM[i][1] = (Integer.parseInt(Character.toString(testCode.charAt(i))));
                        DFM[i][3] = (DFM[i][1] + DFM[i][2]) / 2;
//                        System.out.println(DFM[i][3]);

                    } else if (Character.toString(lastIndice.charAt(i)).equals("-")) {
                        DFM[i][2] = (Integer.parseInt(Character.toString(testCode.charAt(i))));
                        DFM[i][3] = (DFM[i][1] + DFM[i][2]) / 2;
//                        System.out.println(DFM[i][3]);

                    } else {
//                        System.out.println(DFM[i][3]);
                    }
                }
                testCode = "";
                for (int i = 0; i < secretCode.length(); i++) {
                    testCode = testCode + DFM[i][3];
                }
//                System.out.println(testCode);
                System.out.println("----");
            }

            lastIndice = Utilitaires.numberComparator(testCode, secretCode);
            System.out.println(Utilitaires.styleFormat1(testCode));
            System.out.println(Utilitaires.styleFormat1(lastIndice));

            if (Utilitaires.winCondition(lastIndice)) {
                System.out.println("GG WP !!");
                winConditionOk = true;
            }

        }


    }

}
