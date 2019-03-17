import java.util.Scanner;

public class ModeRechercheDefenseur {

    static void game(){

        String secretCode="";

        String testCode="";
        String previousCode="";
        String lastIndice="";

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

        boolean winConditionOk = false;

        while (!winConditionOk) {

            if (lastIndice.equals("")) {
                testCode = Utilitaires.randomNumberGenerator(secretCode.length());
                lastIndice = Utilitaires.numberComparator(testCode, secretCode);
                previousCode=testCode;

            } else {
                testCode = Utilitaires.rechercheDichotomique(testCode, previousCode, lastIndice);
                lastIndice = Utilitaires.numberComparator(testCode, secretCode);

            }

            System.out.println(Utilitaires.styleFormat1(testCode));
            System.out.println(Utilitaires.styleFormat1(lastIndice));

            if (Utilitaires.winCondition(lastIndice)) {
                System.out.println("GG WP !!");
                winConditionOk = true;
            }

        }






    }

}
