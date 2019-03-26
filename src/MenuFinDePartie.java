import java.util.Scanner;

/**
 * Cette class est un menu permettant de faire un choix a la fin d'une partie.
 *
 *<p><b>Exemple de partie :</b></p>
 * @see ModeRechercheChallenger
 * @see ModeRechercheDefenseur
 * @see ModeRechercheDuel
 * @author NoelH
 */
public class MenuFinDePartie {

    /**
     * Methode contenant le menu
     *
     * @return
     *          retourne un booleen pour sortir de la boucle.
     */
    static boolean enGameMenu() {

        boolean b = false;

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

                        b = true;
                        selectedMenu = true;
                        again01 = true;
////                        again = true;

                        break;

                    case 3:

                        System.out.println();
                        System.out.println("Bye bye.");
                        System.out.println();

                        System.exit(0);

                        break;

                    default:

                        System.out.println();
                        System.out.println("Saisie incorrect.");
                        System.out.println("Veuillez recommencer");
                        System.out.println();
                }
            }
        }
        return b;
    }
}