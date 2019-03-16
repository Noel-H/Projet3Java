import java.util.Scanner;

public class ModeRechercheChallenger {

    static void game() {

        int nombreDeChiffreATrouver = 4;

        System.out.println("Chiffre dans le code secret = " + nombreDeChiffreATrouver);

        String secretCode = Utilitaires.randomNumberGenerator(nombreDeChiffreATrouver);

        String playerReponse = "";

//        String resultatDuMoment = "";

//        String resultatDuMomentArray []=new String[nombreDeChiffreATrouver];

//        for (int i = 0; i < nombreDeChiffreATrouver; i++) {
//            resultatDuMomentArray[i]="?";
//        }
//
//        for (int i = 0; i < nombreDeChiffreATrouver; i++) {
//            if (resultatDuMomentArray[i].equals("?")) {
//                if (resultatDuMomentArray[i] != Character.toString(resultatDuMoment.charAt(i))){
//                    resultatDuMomentArray[i].equals(Character.toString(resultatDuMoment.charAt(i)));
//                }
//            }
//        }

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

//            resultatDuMoment = Utilitaires.unknownNumber(playerReponse, secretCode);


//            System.out.println(Utilitaires.styleFormat1(resultatDuMoment));
            System.out.println(Utilitaires.styleFormat1(playerReponse));
            System.out.println(Utilitaires.styleFormat1(resultatEnOperator));

            if (Utilitaires.winCondition(resultatEnOperator)) {
                System.out.println("GG WP !!");
                winConditionOk = true;
            }
        }
    }

}
