import java.util.Scanner;

public class ModeRechercheChallenger {

    static void game() {

        do {

            int nombreDeChiffreATrouver = 4;

            System.out.println("Chiffre dans le code secret = " + nombreDeChiffreATrouver);

            String secretCode = Utilitaires.randomNumberGenerator(nombreDeChiffreATrouver);
            System.out.println("Le code secret est généré.");

            String playerReponse = "";

            boolean winConditionOk = false;

            while (!winConditionOk) {

                boolean correctFormatValue = false;

                while (!correctFormatValue) {

                    System.out.println("Entrez une combinaisons de " + nombreDeChiffreATrouver + " chiffres.");

                    Scanner sc = new Scanner(System.in);

                    playerReponse = sc.nextLine();

                    if (!Utilitaires.tryCatchMethod(playerReponse, nombreDeChiffreATrouver)) {
                        System.out.println("Saisie incorrect.");
                    } else {
                        correctFormatValue = true;
                    }
                }

                String resultatEnOperator = Utilitaires.numberComparator(playerReponse, secretCode);

                System.out.println(Utilitaires.styleFormat1(playerReponse));
                System.out.println(Utilitaires.styleFormat1(resultatEnOperator));

                if (Utilitaires.winCondition(resultatEnOperator)) {
                    System.out.println("GG WP !!");
                    winConditionOk = true;
                }
            }
        } while (!MenuFinDePartie.enGameMenu());
    }
}