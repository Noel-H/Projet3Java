import java.util.Scanner;

public class Menu {

    void principalMenu() {

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

                    this.modeDeJeuMenu();
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

                    selectedMenu = true;

                    break;

                default:

                    System.out.println();
                    System.out.println("Saisie incorrect.");
                    System.out.println("Veuillez recommencer");
                    System.out.println();
            }
        }
    }

    void modeDeJeuMenu() {

        boolean selectedMenu = false;

        while (!selectedMenu) {

            boolean corectValueForMenu = false;

            int numberSelectionChoiceMenu = 0;

            while (!corectValueForMenu) {

                System.out.println();
                System.out.println("Entrez le numéro correspondant au mode de jeu voulu.");
                System.out.println("1 - Joueur solo");
                System.out.println("2 - Ordi solo");
                System.out.println("3 - Joueur vs Ordi");
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

                    ModePlusMinus modePlusMinus = new ModePlusMinus();
                    modePlusMinus.runGamePlusMinus();
                    selectedMenu = true;

                    break;

                case 2:

                    System.out.println();
                    System.out.println("Choix indisponible pour le moment.");
                    System.out.println();

                    break;

                case 3:

                    System.out.println();
                    System.out.println("Choix indisponible pour le moment.");
                    System.out.println();

                    break;

                case 4:

                    this.principalMenu();

                    selectedMenu = true;

                    break;

                case 5:

                    System.out.println();
                    System.out.println("Bye bye.");
                    System.out.println();

                    selectedMenu = true;

                    break;

                default:

                    System.out.println();
                    System.out.println("Saisie incorrect.");
                    System.out.println("Veuillez recommencer");
                    System.out.println();


            }
        }
    }

    void endGameMenu() {

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

                    ModePlusMinus modePlusMinus = new ModePlusMinus();
                    modePlusMinus.runGamePlusMinus();
                    selectedMenu = true;

                    break;

                case 2:

                    this.principalMenu();

                    break;

                case 3:

                    System.out.println();
                    System.out.println("Bye bye.");
                    System.out.println();

                    selectedMenu = true;

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