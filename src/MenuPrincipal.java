import java.util.Scanner;

/**
 *Class contenant le menu principal
 *
 * @author NoelH
 */
public class MenuPrincipal {

    /**
     *Methode du menu principal
     */
    static void principalMenu() {

        boolean again = false;

        while (!again) {

            boolean selectedMenu = false;

            while (!selectedMenu) {

                boolean corectValueForMenu = false;

                int numberSelectionChoiceMenu = 0;

                while (!corectValueForMenu) {

                    System.out.println("Entrez le numéro correspondant au mode de jeu voulu.");
                    System.out.println("1 - Mode +/-");
                    System.out.println("2 - Mastermind");
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

                        MenuSelectionDeMode.modeDeJeuMenu();
                        selectedMenu = true;

                        break;

                    case 2:

                        System.out.println();
                        System.out.println("Choix indisponible pour le moment.");
                        System.out.println();

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
    }
}