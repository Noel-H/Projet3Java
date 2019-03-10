import java.util.Scanner;

public class ModePlusMinus {

    void runGamePlusMinus() {
        boolean again = false;

        while (!again) {

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
                        for (String s : chiffreInconnuTableau) {
                            System.out.print("| " + s + " ");
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

                    for (String s : resultat) {
                        if (s.equals("=")) {
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

            boolean again01 = false;

            while (!again01) {

                boolean selectedMenu = false;

                while (!selectedMenu) {

                    boolean corectValueForMenu = false;

                    int numberSelectionChoiceMenu = 0;

                    while (!corectValueForMenu) {

                        System.out.println("Entrez le numéro correspondant au mode de jeu voulu.");
                        System.out.println("1 - Rejouer");
                        System.out.println("2 - Menu Principal");
                        System.out.println("3 - Quitter");

                        Scanner sc = new Scanner(System.in);
                        String selectionChoiceMenu = sc.nextLine();


                        try {

                            numberSelectionChoiceMenu = Integer.parseInt(selectionChoiceMenu);
                            corectValueForMenu = true;

                        } catch (NumberFormatException e) {

                            System.out.println();
                            System.out.println("Saisie incorrect.");
                            System.out.println("Veuillez recommencer");
                            System.out.println();

                        }
                    }


                    switch (numberSelectionChoiceMenu) {
                        case 1:

                            selectedMenu = true;
                            again01 = true;

                            break;

                        case 2:

                            System.out.println();
                            System.out.println("Retour au Menu principal");
                            System.out.println();
                            selectedMenu = true;
                            again01 = true;
                            again = true;

                            break;

                        case 3:

                            System.out.println();
                            System.out.println("Bye bye.");
                            System.out.println();

                            System.exit(0);

//                        selectedMenu = true;

                            break;

                        default:

                            System.out.println();
                            System.out.println("Saisie incorrect.");
                            System.out.println("Veuillez recommencer");
                            System.out.println();
                    }
                }
            }
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    void runGamePlusMinusModeOrdi() {

        boolean again = false;

        while (!again) {


            String playerReponse = "";

            boolean corectValueForMenu = false;

            while (!corectValueForMenu) {

                System.out.println("Entrer une combinaisons de chiffre que l'ordinateur devra trouver.");

                Scanner sc = new Scanner(System.in);

                playerReponse = sc.nextLine();


                String playerReponseTableau[] = new String[playerReponse.length()];
                int playerReponseTableauInt[] = new int[playerReponse.length()];

                try {
                    for (int i = 0; i < playerReponse.length(); i++) {
                        playerReponseTableau[i] = Character.toString(playerReponse.charAt(i));
                        playerReponseTableauInt[i] = Integer.parseInt(playerReponseTableau[i]);
                    }
                    corectValueForMenu = true;
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Saisie incorrect.");
                    System.out.println("Veuillez recommencer");
                    System.out.println();
                }


            }

            String playerReponseTableau2[] = new String[playerReponse.length()];
            int playerReponseTableauInt2[] = new int[playerReponse.length()];
            int winCondition = 0;
            int nbTry = 0;

            for (int i = 0; i < playerReponse.length(); i++) {
                playerReponseTableau2[i] = Character.toString(playerReponse.charAt(i));
                playerReponseTableauInt2[i] = Integer.parseInt(playerReponseTableau2[i]);
            }

            System.out.println();
            System.out.println("C'est parti !");
            System.out.println();

            int ordiReponse[] = new int[playerReponse.length()];
            String resultat[] = new String[playerReponse.length()];
            int ordiReponseModif[] = new int[playerReponse.length()];

            for (int i = 0; i < playerReponse.length(); i++) {
                ordiReponse[i] = 5;
            }
            System.out.println();

            for (int i = 0; i < playerReponse.length(); i++) {
                ordiReponseModif[i] = ordiReponse[i];
            }


            while (winCondition != playerReponse.length()) {

                nbTry = nbTry + 1;
                winCondition = 0;

                System.out.println("Essai numéro : " + nbTry);

                for (int i : playerReponseTableauInt2) {
                    System.out.print("| " + i + " ");
                }
                System.out.print("|");
                System.out.println();

                for (int i : ordiReponse) {
                    System.out.print("| " + i + " ");
                }
                System.out.print("|");
                System.out.println();


                for (int i = 0; i < playerReponse.length(); i++) {
                    if (ordiReponse[i] == playerReponseTableauInt2[i]) {
                        resultat[i] = "=";
                        System.out.print("| " + resultat[i] + " ");
                        winCondition = winCondition + 1;
                    } else if (ordiReponse[i] > playerReponseTableauInt2[i]) {
                        resultat[i] = "-";
                        System.out.print("| " + resultat[i] + " ");
//                System.out.println("ordiReponse i = "+ordiReponseModif[i]);
                        ordiReponseModif[i] = ordiReponse[i] - 1;
//                System.out.println("ordiReponse i = "+ordiReponseModif[i]);
                    } else {
                        resultat[i] = "+";
                        System.out.print("| " + resultat[i] + " ");
                        ordiReponseModif[i] = ordiReponse[i] + 1;
                    }
                }
                System.out.print("|");
                System.out.println();
//        for ( int i=0; i < playerReponse.length(); i++){
//            System.out.print(ordiReponseModif[i]);
//        }

                for (int i = 0; i < playerReponse.length(); i++) {
                    ordiReponse[i] = ordiReponseModif[i];
//                System.out.print(ordiReponse[i]);
                }
                System.out.println();
//            System.out.println(winCondition);
            }

            System.out.println("GG WP !!");
            System.out.println();

            boolean again01 = false;

            while (!again01) {

                boolean selectedMenu = false;

                while (!selectedMenu) {

                    boolean corectValueForMenu01 = false;

                    int numberSelectionChoiceMenu = 0;

                    while (!corectValueForMenu01) {

                        System.out.println("Entrez le numéro correspondant au mode de jeu voulu.");
                        System.out.println("1 - Rejouer");
                        System.out.println("2 - Menu Principal");
                        System.out.println("3 - Quitter");

                        Scanner sc = new Scanner(System.in);
                        String selectionChoiceMenu = sc.nextLine();


                        try {

                            numberSelectionChoiceMenu = Integer.parseInt(selectionChoiceMenu);
                            corectValueForMenu01 = true;

                        } catch (NumberFormatException e) {

                            System.out.println();
                            System.out.println("Saisie incorrect.");
                            System.out.println("Veuillez recommencer");
                            System.out.println();

                        }
                    }


                    switch (numberSelectionChoiceMenu) {
                        case 1:

                            selectedMenu = true;
                            again01 = true;

                            break;

                        case 2:

                            System.out.println();
                            System.out.println("Retour au Menu principal");
                            System.out.println();
                            selectedMenu = true;
                            again01 = true;
                            again = true;

                            break;

                        case 3:

                            System.out.println();
                            System.out.println("Bye bye.");
                            System.out.println();

                            System.exit(0);

//                        selectedMenu = true;

                            break;

                        default:

                            System.out.println();
                            System.out.println("Saisie incorrect.");
                            System.out.println("Veuillez recommencer");
                            System.out.println();
                    }
                }
            }
            //

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    void runGameVersusMode() {

        boolean fin = false;

        while (!fin) {

            String playerReponse = "";

            boolean corectValueForMenu = false;

            while (!corectValueForMenu) {

                System.out.println();
                System.out.println("Entrer une combinaisons de chiffre que l'ordinateur devra trouver.");

                Scanner sc = new Scanner(System.in);

                playerReponse = sc.nextLine();


                String playerReponseTableau[] = new String[playerReponse.length()];
                int playerReponseTableauInt[] = new int[playerReponse.length()];

                try {
                    for (int i = 0; i < playerReponse.length(); i++) {
                        playerReponseTableau[i] = Character.toString(playerReponse.charAt(i));
                        playerReponseTableauInt[i] = Integer.parseInt(playerReponseTableau[i]);
                    }
                    corectValueForMenu = true;
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Saisie incorrect.");
                    System.out.println("Veuillez recommencer");
                    System.out.println();
                }
            }

            String playerReponseTableau[] = new String[playerReponse.length()];
            int playerReponseTableauInt[] = new int[playerReponse.length()];

            for (int i = 0; i < playerReponse.length(); i++) {
                playerReponseTableau[i] = Character.toString(playerReponse.charAt(i));
                playerReponseTableauInt[i] = Integer.parseInt(playerReponseTableau[i]);
            }

            System.out.println();
            System.out.println("Vous venez de générer un code pour l'ordinateur.");
            System.out.println();

            for (int i : playerReponseTableauInt) {
                System.out.print("| " + i + " ");
            }
            System.out.print("|");
            System.out.println();
            /////////////////////

            int ordiReponse[] = new int[playerReponse.length()];

            for (int i = 0; i < playerReponse.length(); i++) {
                ordiReponse[i] = (int) (Math.random() * 10);
                ;
            }

            System.out.println();
            System.out.println("L'ordinateur vient de générer un code pour vous.");
            System.out.println();

            for (int i : ordiReponse) {
                System.out.print("| " + i + " ");
            }
            System.out.println("|");
            System.out.println();

            //////////////////////////////
            boolean inGamePlay = false;
            int nbTour = 0;
            int ordiWinCondition = 0;
            int playerWinCondition = 0;

            String chiffreInconnuTableau[] = new String[playerReponse.length()]; // tableau qui affiche les chiffres trouver au fur et a mesure

            int ordiReponseModif[] = new int[playerReponse.length()];

            int ordiReponseFind[] = new int[playerReponse.length()];

            for (int i = 0; i < playerReponse.length(); i++) {
                ordiReponseFind[i] = 5;
            }

            for (int i = 0; i < playerReponse.length(); i++) {
                chiffreInconnuTableau[i] = "?";
            }

            while (!inGamePlay) {

                ordiWinCondition = 0;
                playerWinCondition = 0;

                String playerReponseGuess = "";

                System.out.println("Entrez une combinaisons de " + playerReponse.length() + " chiffres.");

                Scanner sc = new Scanner(System.in);

                playerReponseGuess = sc.nextLine();

                if (playerReponseGuess.length() == playerReponse.length()) {

                    String inputPlayer[] = new String[playerReponse.length()];
                    int inputPlayerInt[] = new int[playerReponse.length()];

                    try {
                        for (int i = 0; i < playerReponse.length(); i++) {
                            inputPlayer[i] = Character.toString(playerReponseGuess.charAt(i));
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
///////
                    String resultat[] = new String[playerReponse.length()];
                    String resultatEnString = "";

                    for (int i = 0; i < playerReponse.length(); i++) {
                        if (ordiReponse[i] > inputPlayerInt[i]) {
                            resultat[i] = "+";
                        } else if (ordiReponse[i] < inputPlayerInt[i]) {
                            resultat[i] = "-";
                        } else if (ordiReponse[i] == inputPlayerInt[i]) {
                            resultat[i] = "=";
                            chiffreInconnuTableau[i] = Integer.toString(inputPlayerInt[i]);
                            playerWinCondition = playerWinCondition + 1;
                            //System.out.println("Case "+i+" = "+chiffreInconnuTableau[i]); // Verbose
                        } else {
                            System.out.println("Error");
                        }

                        resultatEnString = resultatEnString + "| " + resultat[i] + " ";

                    }

                    //System.out.println("OK = "+nbTrouver+"/"+resultatScanner); //ne fonctionne pas
//            {
//                for (String s : chiffreInconnuTableau) {
//                    System.out.print("| " + s + " ");
//                }
//                System.out.print("|");
//                System.out.println();
//            }
//
//            //System.out.println(chiffreInconnu + "|"); // Verbose
//            //System.out.println(numberString + "|"); // Verbose
//            System.out.println(numberResponseString + "|");

                    System.out.println();

                    nbTour = nbTour + 1;
                    System.out.println("Tour : " + nbTour);
                    System.out.println();
                    System.out.println("Vous");

                    for (String i : chiffreInconnuTableau) {
                        System.out.print("| " + i + " ");
                    }
                    System.out.println("|");

                    // Affichage du code de l'ordinateur
//                    for (int i : ordiReponse) {
//                        System.out.print("| " + i + " ");
//                    }
//                    System.out.println("|");

                    for (int i : inputPlayerInt) {
                        System.out.print("| " + i + " ");
                    }
                    System.out.println("|");

                    System.out.println(resultatEnString + "|");

                    //////////////////////////////////////////////////

                    System.out.println("Ordi");

                    for (int i : playerReponseTableauInt) {
                        System.out.print("| " + i + " ");
                    }
                    System.out.println("|");

                    for (int i : ordiReponseFind) {
                        System.out.print("| " + i + " ");
                    }
                    System.out.println("|");

                    for (int i = 0; i < playerReponse.length(); i++) {
                        if (ordiReponseFind[i] == playerReponseTableauInt[i]) {
                            resultat[i] = "=";
                            System.out.print("| " + resultat[i] + " ");
                            ordiReponseModif[i] = ordiReponseFind[i];
                            ordiWinCondition = ordiWinCondition + 1;
                        } else if (ordiReponseFind[i] > playerReponseTableauInt[i]) {
                            resultat[i] = "-";
                            System.out.print("| " + resultat[i] + " ");
//                System.out.println("ordiReponse i = "+ordiReponseModif[i]);
                            ordiReponseModif[i] = ordiReponseFind[i] - 1;
//                System.out.println("ordiReponse i = "+ordiReponseModif[i]);
                        } else {
                            resultat[i] = "+";
                            System.out.print("| " + resultat[i] + " ");
                            ordiReponseModif[i] = ordiReponseFind[i] + 1;
                        }
                    }
                    System.out.print("|");
                    System.out.println();
                    System.out.println();

                } else {
                    System.out.println();
                    System.out.println("Saisie incorrect.");
                    System.out.println("Veuillez recommencer");
                    System.out.println();
                }

                if (playerWinCondition == playerReponse.length() && ordiWinCondition != playerReponse.length()) {
                    System.out.println("Vous avez Gagné !");
                    System.out.println();
                    inGamePlay = true;
                } else if (playerWinCondition != playerReponse.length() && ordiWinCondition == playerReponse.length()) {
                    System.out.println("Vous avez Perdu !");
                    System.out.println();
                    inGamePlay = true;
                } else if (playerWinCondition == playerReponse.length() && ordiWinCondition == playerReponse.length()) {
                    System.out.println("Egalité");
                    System.out.println();
                    inGamePlay = true;
                } else {
                    System.out.println("Aucun code trouver ce tour.");
                    System.out.println();
                }

                for (int i = 0; i < playerReponse.length(); i++) {
                    ordiReponseFind[i] = ordiReponseModif[i];
                }

            }

            ////////////

            boolean again01 = false;

            while (!again01) {

                boolean selectedMenu = false;

                while (!selectedMenu) {

                    boolean corectValueForMenu01 = false;

                    int numberSelectionChoiceMenu = 0;

                    while (!corectValueForMenu01) {

                        System.out.println("Entrez le numéro correspondant au mode de jeu voulu.");
                        System.out.println("1 - Rejouer");
                        System.out.println("2 - Menu Principal");
                        System.out.println("3 - Quitter");

                        Scanner sc = new Scanner(System.in);
                        String selectionChoiceMenu = sc.nextLine();


                        try {

                            numberSelectionChoiceMenu = Integer.parseInt(selectionChoiceMenu);
                            corectValueForMenu01 = true;

                        } catch (NumberFormatException e) {

                            System.out.println();
                            System.out.println("Saisie incorrect.");
                            System.out.println("Veuillez recommencer");
                            System.out.println();

                        }
                    }


                    switch (numberSelectionChoiceMenu) {
                        case 1:

                            selectedMenu = true;
                            again01 = true;

                            break;

                        case 2:

                            System.out.println();
                            System.out.println("Retour au Menu principal");
                            System.out.println();
                            selectedMenu = true;
                            again01 = true;
                            fin = true;

                            break;

                        case 3:

                            System.out.println();
                            System.out.println("Bye bye.");
                            System.out.println();

                            System.exit(0);

//                        selectedMenu = true;

                            break;

                        default:

                            System.out.println();
                            System.out.println("Saisie incorrect.");
                            System.out.println("Veuillez recommencer");
                            System.out.println();
                    }
                }
            }

        }


    }

}



