import java.util.Scanner;

public class Menu {

    static void principalMenu() {

        boolean selectedMenu = false;

        while (!selectedMenu) {

            System.out.println("Entrez le numéro correspondant au mode de jeu voulu.");
            System.out.println("1 - Mode +/-");
            System.out.println("2 - Mastermind");
            System.out.println("3 - Quitter");

            Scanner sc = new Scanner(System.in);
            int selectionChoiceMenu = sc.nextInt();

            switch (selectionChoiceMenu) {
                case 1:

                    ModePlusMinus modePlusMinus = new ModePlusMinus();
                    modePlusMinus.runGamePlusMinus();
                    selectedMenu = true;

                    break;

                case 3:

                    System.out.println("Bye bye.");

                    selectedMenu = true;

                    break;

                default:

                    System.out.println();
                    System.out.println("Choix indisponible pour le moment.");
                    System.out.println();
            }
        }
    }
}