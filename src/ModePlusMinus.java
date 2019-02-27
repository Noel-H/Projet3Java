import java.util.Scanner;

public class ModePlusMinus {

    void runGamePlusMinus() {

        int resultatScanner = 4; //Indique le nombre de chiffre a trouver
        int numberToFind[] = new int[resultatScanner]; // tableau qui stock le nmbre aleatoire
        String numberString = "";
        String chiffreInconnuTableau[] = new String[resultatScanner]; // tableau qui affiche les chiffres trouver au fur et a mesure
        String chiffreInconnu = "";
        int nbTrouver = 0;

//Generation des chiffres aléatoires et les stock dans un tableau.
        //
        for (int i = 0; i < numberToFind.length; i++) {
            numberToFind[i] = (int) (Math.random() * 10);
            //System.out.println("À l'emplacement " + i + " du tableau nous avons = " + numberToFind[i]); // Verbose
            String conversion = Integer.toString(numberToFind[i]);
            numberString = numberString + "| " + conversion + " ";

            chiffreInconnuTableau[i] = "?";
            chiffreInconnu = chiffreInconnu + "| " + chiffreInconnuTableau[i] + " ";
        }

        System.out.println("Le code est généré.");
        System.out.println("Code à trouver = " + chiffreInconnu + "|");
        //System.out.println("Code à trouver = " + numberString + "|"); // Verbose
        System.out.println();
        //
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Debut du mode de jeu
        boolean success = false;

        while (!success) {

            boolean corectValueForMenu = false;

            int playerReponseTry = 0; // Initialisation de la variable qui stockera les inputs du joueur

            String playerReponse = ""; // Initialisation de la variable qui convertira en String la variable des input du joueur pour pouvoir les affichers

            while (!corectValueForMenu) {

                System.out.println("Entrez une combinaisons de " + resultatScanner + " chiffres.");

                Scanner sc = new Scanner(System.in);

                playerReponse = sc.nextLine();

                //Vérification de l'input du joueur. On s'assurre qu'il ne contient pas de caractere inadequat ou de chiffre negatif
                //

                String inputPlayer[] = new String[playerReponse.length()];
                int inputPlayerInt[] = new int[playerReponse.length()];

                try {
                    for (int i = 0; i < playerReponse.length(); i++) {
                        inputPlayer[i] = Character.toString(playerReponse.charAt(i));
                        inputPlayerInt[i] = Integer.parseInt(inputPlayer[i]);
                    }
                    corectValueForMenu = true;
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Saisie incorrect.");
                    System.out.println("Veuillez recommencer");

                    //System.out.println("Code à trouver = " + chiffreInconnu + "|"); // Verbose
                    //System.out.println("Code à trouver = " + numberString + "|"); // Verbose
                    System.out.println();
                }
            }

            int numberOfChar = playerReponse.length();

            String playerResponseTableau[] = new String[resultatScanner];

            String numberResponseString = "";

            if (numberOfChar == resultatScanner && playerReponseTry >= 0) {

                int numberIntResponseTableau[] = new int[resultatScanner];

                for (int i = 0; i < playerResponseTableau.length; i++) {
                    playerResponseTableau[i] = Character.toString(playerReponse.charAt(i));
                    numberIntResponseTableau[i] = Integer.parseInt(playerResponseTableau[i]);
                    //System.out.println("Tableau String = "+playerResponseTableau[i]); // Verbose
                    // System.out.println("Tableau Int = "+numberIntResponseTableau[i]); // Verbose
                    numberResponseString = numberResponseString + "| " + playerResponseTableau[i] + " ";

                }
                //
                //////////////////////////////////////////////////////////////////////////////////////////////////////


                //Comparaison entre la réponse et l'input du joueur et affichage
                //
                String resultat[] = new String[resultatScanner];
                String resultatEnString = "";

                for (int i = 0; i < playerResponseTableau.length; i++) {
                    if (numberToFind[i] > numberIntResponseTableau[i]) {
                        resultat[i] = "+";
                    } else if (numberToFind[i] < numberIntResponseTableau[i]) {
                        resultat[i] = "-";
                    } else if (numberToFind[i] == numberIntResponseTableau[i]) {
                        resultat[i] = "=";
                        chiffreInconnuTableau[i] = Integer.toString(numberIntResponseTableau[i]);
                        nbTrouver = nbTrouver + 1;
                        //System.out.println("Case "+i+" = "+chiffreInconnuTableau[i]); // Verbose
                    } else {
                        System.out.println("Error");
                    }

                    resultatEnString = resultatEnString + "| " + resultat[i] + " ";

                }

                //System.out.println("OK = "+nbTrouver+"/"+resultatScanner); //ne fonctionne pas
                {
                    for (int i = 0; i < playerResponseTableau.length; i++) {
                        System.out.print("| " + chiffreInconnuTableau[i] + " ");
                    }
                    System.out.print("|");
                    System.out.println();
                }

                //System.out.println(chiffreInconnu + "|"); // Verbose
                //System.out.println(numberString + "|"); // Verbose
                System.out.println(numberResponseString + "|");
                System.out.println(resultatEnString + "|");
                //
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////

                //Verification pour savoir si la partie est terminé
                //
                int winCondition = 0;

                for (int i = 0; i < playerResponseTableau.length; i++) {
                    if (resultat[i] == "=") {
                        winCondition = winCondition + 1;
                    }
                }

                if (winCondition == resultatScanner) {
                    success = true;
                }
                //
                ////////////////////////////////////////////////////////////////////////////////////////////////////
            } else {
                System.out.println();
                System.out.println("Saisie incorrect.");
                System.out.println("Veuillez recommencer");
                //System.out.println("Code à trouver = " + chiffreInconnu + "|");
                //System.out.println("Code à trouver = " + numberString + "|"); // Verbose
                System.out.println();
            }
        }
        System.out.println("GG WP !!");
        System.out.println();
        Menu menu = new Menu();
        menu.endGameMenu();
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
