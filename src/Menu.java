import java.util.Scanner;

public class Menu {

    void principalMenu() {

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

    void modeDeJeuMenu() {

        boolean again = false;

        while (!again) {

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
                        again=true;

                        break;

                    case 2:

                        ModePlusMinus modePlusMinus1 = new ModePlusMinus();
                        modePlusMinus1.runGamePlusMinusModeOrdi();

                        selectedMenu = true;
                        again=true;

                        break;

                    case 3:

                        System.out.println();
                        System.out.println("Choix indisponible pour le moment.");
                        System.out.println();

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

//                    selectedMenu = true;

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