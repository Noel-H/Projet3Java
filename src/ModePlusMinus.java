import java.util.Scanner;

public class ModePlusMinus {

    void runGamePlusMinus() {

        int nbGenerate1;
        nbGenerate1 = (int) (Math.random() * 10);
//        System.out.println(nbGenerate1);

        int nbGenerate2;
        nbGenerate2 = (int) (Math.random() * 10);
//        System.out.println(nbGenerate2);

        int nbGenerate3;
        nbGenerate3 = (int) (Math.random() * 10);
//       System.out.println(nbGenerate3);

        int nbGenerate4;
        nbGenerate4 = (int) (Math.random() * 10);
//        System.out.println(nbGenerate4);

        System.out.println("Le code est généré.");
        System.out.println("Code à trouver = ????");
//        System.out.println("Code à trouver = " + nbGenerate1 + " | " + nbGenerate2 + " | " + nbGenerate3 + " | " + nbGenerate4);
        System.out.println();

        boolean success = false;

        while (!success) {

            System.out.println("Entrez une combinaisons de 4 chiffres.");

            Scanner sc = new Scanner(System.in);

            int code = sc.nextInt();

            int nb1 = (code % 10000) / 1000;
            int nb2 = (code % 1000) / 100;
            int nb3 = (code % 100) / 10;
            int nb4 = (code % 10);

            System.out.println(nb1 + " | " + nb2 + " | " + nb3 + " | " + nb4);

            char reponseNumnb1;
            char reponseNumnb2;
            char reponseNumnb3;
            char reponseNumnb4;


            if (nbGenerate1 < nb1) {

                reponseNumnb1 = '-';

            } else if (nbGenerate1 == nb1) {

                reponseNumnb1 = '=';

            } else if (nbGenerate1 > nb1) {

                reponseNumnb1 = '+';

            } else {

                reponseNumnb1 = '\u0000';

            }


            if (nbGenerate2 < nb2) {

                reponseNumnb2 = '-';

            } else if (nbGenerate2 == nb2) {

                reponseNumnb2 = '=';

            } else if (nbGenerate2 > nb2) {

                reponseNumnb2 = '+';

            } else {

                reponseNumnb2 = '\u0000';

            }


            if (nbGenerate3 < nb3) {

                reponseNumnb3 = '-';

            } else if (nbGenerate3 == nb3) {

                reponseNumnb3 = '=';

            } else if (nbGenerate3 > nb3) {

                reponseNumnb3 = '+';

            } else {

                reponseNumnb3 = '\u0000';

            }


            if (nbGenerate4 < nb4) {

                reponseNumnb4 = '-';

            } else if (nbGenerate4 == nb4) {

                reponseNumnb4 = '=';

            } else if (nbGenerate4 > nb4) {

                reponseNumnb4 = '+';

            } else {

                reponseNumnb4 = '\u0000';

            }


            if (reponseNumnb1 == '\u0000' || reponseNumnb2 == '\u0000' || reponseNumnb3 == '\u0000' || reponseNumnb4 == '\u0000') {

                System.out.println("Error");

            } else if (reponseNumnb1 == '=' && reponseNumnb2 == '=' && reponseNumnb3 == '=' && reponseNumnb4 == '=') {

                System.out.println(reponseNumnb1 + " | " + reponseNumnb2 + " | " + reponseNumnb3 + " | " + reponseNumnb4);

                success = true;

            } else {

                System.out.println(reponseNumnb1 + " | " + reponseNumnb2 + " | " + reponseNumnb3 + " | " + reponseNumnb4);

            }
        }

        System.out.println("GG WP !!");
        System.out.println();
        Menu.principalMenu();

    }
}