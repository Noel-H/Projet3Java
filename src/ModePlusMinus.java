import java.util.Scanner;

public class ModePlusMinus {

    void runGamePlusMinus() {

        int resultatScanner = 8;
        int numberToFind[] = new int[resultatScanner];
        String numberString = "";
        String chiffreInconnuTableau[] = new String[resultatScanner];
        String chiffreInconnu = "";


        for (int i = 0; i < numberToFind.length; i++) {
            numberToFind[i] = (int) (Math.random() * 10);
//            System.out.println("À l'emplacement " + i + " du tableau nous avons = " + numberToFind[i]);
            String conversion = Integer.toString(numberToFind[i]);
            numberString = numberString + "| " + conversion + " ";

            chiffreInconnuTableau[i] = "?";
            chiffreInconnu = chiffreInconnu + "| " + chiffreInconnuTableau[i] + " ";
        }

        System.out.println("Le code est généré.");
        System.out.println("Code à trouver = " + chiffreInconnu + "|");
        //System.out.println("Code à trouver = " + numberString + "|");
        System.out.println();

        boolean success = false;

        while (!success) {

            boolean corectValueForMenu = false;

            int playerReponseTry = 0;

            String playerReponse="";

            while (!corectValueForMenu) {

            System.out.println("Entrez une combinaisons de "+resultatScanner+" chiffres.");

            Scanner sc = new Scanner(System.in);

            playerReponse = sc.nextLine();


                try {
                    playerReponseTry = Integer.parseInt(playerReponse);
                    corectValueForMenu=true;
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Saisie incorrect.");
                    System.out.println("Veuillez recommencer");

                    //System.out.println("Code à trouver = " + chiffreInconnu + "|");
                    //System.out.println("Code à trouver = " + numberString + "|");
                    System.out.println();
                }
            }

            int numberOfChar=playerReponse.length();

            String playerResponseTableau[] = new String[resultatScanner];

            String numberResponseString = "";

            if (numberOfChar==resultatScanner && playerReponseTry>=0) {

                int numberIntResponseTableau[] = new int[resultatScanner];

                for (int i = 0; i < playerResponseTableau.length; i++) {
                    playerResponseTableau[i] = Character.toString(playerReponse.charAt(i));
                    numberIntResponseTableau[i] = Integer.parseInt(playerResponseTableau[i]);
//                System.out.println("Tableau String = "+playerResponseTableau[i]);
//                System.out.println("Tableau Int = "+numberIntResponseTableau[i]);
                    numberResponseString = numberResponseString + "| " + playerResponseTableau[i] + " ";

                }


                String resultat[] = new String[resultatScanner];
                String resultatEnString = "";

                for (int i = 0; i < playerResponseTableau.length; i++) {
                    if (numberToFind[i] > numberIntResponseTableau[i]) {
                        resultat[i] = "+";
                    } else if (numberToFind[i] < numberIntResponseTableau[i]) {
                        resultat[i] = "-";
                    } else if (numberToFind[i] == numberIntResponseTableau[i]) {
                        resultat[i] = "=";
                        chiffreInconnuTableau[i]=Integer.toString(numberIntResponseTableau[i]);
                        System.out.println("Case "+i+" = "+chiffreInconnuTableau[i]);
                    } else {
                        System.out.println("Error");
                    }

                    resultatEnString = resultatEnString + "| " + resultat[i] + " ";

                }



                {
                    for (int i = 0; i < playerResponseTableau.length; i++) {
                        System.out.print("| " + chiffreInconnuTableau[i] + " ");
                    }
                    System.out.print("|");
                    System.out.println();
                }

                //System.out.println(chiffreInconnu + "|");
                //System.out.println(numberString + "|");
                System.out.println(numberResponseString + "|");
                System.out.println(resultatEnString + "|");


                int winCondition = 0;

                for (int i = 0; i < playerResponseTableau.length; i++) {
                    if (resultat[i] == "=") {
                        winCondition = winCondition + 1;
                    } else {

                    }
                }

                if (winCondition == resultatScanner) {
                    success = true;
                } else {

                }
            } else {
                System.out.println();
                System.out.println("Saisie incorrect.");
                System.out.println("Veuillez recommencer");
                System.out.println("Code à trouver = " + chiffreInconnu + "|");
                //System.out.println("Code à trouver = " + numberString + "|");
                System.out.println();
            }
        }

        System.out.println("GG WP !!");
        System.out.println();
        Menu.principalMenu();

    }
}