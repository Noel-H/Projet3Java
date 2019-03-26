import java.util.Scanner;

/**
 * Cette class est un menu permettant la selection du mode de jeu.
 *
 * @author NoelH
 */
public class MenuSelectionDeMode {

    /**
     *Cette methode permet de choisir un mode de jeu.
     */
    static void modeDeJeuMenu() {

        boolean again = false;

        while (!again) {

            boolean selectedMenu = false;

            while (!selectedMenu) {

                boolean corectValueForMenu = false;

                int numberSelectionChoiceMenu = 0;

                while (!corectValueForMenu) {

                    System.out.println();
                    System.out.println("Entrez le numéro correspondant au mode de jeu voulu.");
                    System.out.println("1 - Challenger");
                    System.out.println("2 - Defenseur");
                    System.out.println("3 - Duel");
                    System.out.println("4 - Retour");
                    System.out.println("5 - Quitter");

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

                        ModeRechercheChallenger.game();

                        selectedMenu = true;
                        again = true;

                        break;

                    case 2:

                        ModeRechercheDefenseur.game();

                        selectedMenu = true;
                        again = true;

                        break;

                    case 3:

                        ModeRechercheDuel.game();

                        selectedMenu = true;
                        again = true;

                        break;

                    case 4:

                        again = true;
                        selectedMenu = true;

                        break;

                    case 5:

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
    }
}