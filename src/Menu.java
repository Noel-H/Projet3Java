import java.util.Scanner;

public class Menu {

    static void principalMenu() {

        boolean selectedMenu = false;

        while (!selectedMenu) {

            boolean corectValueForMenu = false;

            int numberSelectionChoiceMenu = 0;

            String selectionChoiceMenu = "";

            while (!corectValueForMenu) {

                System.out.println("Entrez le numéro correspondant au mode de jeu voulu.");
                System.out.println("1 - Mode +/-");
                System.out.println("2 - Mastermind");
                System.out.println("3 - Quitter");

                Scanner sc = new Scanner(System.in);
                selectionChoiceMenu = sc.nextLine();


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

            int numberOfChar = selectionChoiceMenu.length();

            if (numberOfChar == 1) {


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
            }else {
                System.out.println();
                System.out.println("Saisie incorrect.");
                System.out.println("Veuillez recommencer");
                System.out.println();
            }
        }
    }
}