/**
 * Cette class contient un ensemble de methode utile et reutilisable pour le programme.
 *
 * @author NoelH
 */
public class Utilitaires {


    /**
     *Permet de générer un nombre aléatoire.
     *
     * @param quantityToGenerate
     *          Représente la quantité de chiffre à générer aléatoirement pour cette méthode.
     * @return
     *          Retourne un nombre aléatoire.
     */
    static String randomNumberGenerator(int quantityToGenerate) {

        String generatedNumber = "";

        for (int i = 0; i < quantityToGenerate; i++) {
            generatedNumber=generatedNumber+((int) (Math.random() * 10));
        }

        return generatedNumber;
    }

    /**
     *Permet de comparer deux nombres entre eux
     *
     * @param numberToCompare1
     *          Correspond au nombre numero un
     * @param numberToCompare2
     *          Correspond au nombre numero deux
     * @return
     *          une chaine de caractere constitue de symbole tel que "+" "-" "="
     */
    static String numberComparator(String numberToCompare1, String numberToCompare2) {

        String comparedNumber = "";

        String operator;

        for (int i = 0; i < numberToCompare2.length(); i++) {
            if (Integer.parseInt(Character.toString(numberToCompare1.charAt(i))) < Integer.parseInt(Character.toString(numberToCompare2.charAt(i)))) {
                operator = "+";
            } else if (Integer.parseInt(Character.toString(numberToCompare1.charAt(i))) > Integer.parseInt(Character.toString(numberToCompare2.charAt(i)))) {
                operator = "-";
            } else {
                operator = "=";
            }

            comparedNumber = comparedNumber + operator;

        }

        return comparedNumber;

    }

    /**
     *
     * @param stringToFormat
     * @return
     */
    static String styleFormat1(String stringToFormat) {

        String formatedString = "";

        for (int i = 0; i < stringToFormat.length(); i++) {
            String charToFormat = Character.toString(stringToFormat.charAt(i));

            formatedString = formatedString + "| " + charToFormat + " ";
        }

        return formatedString + "|";

    }

    /**
     *
     * @param numberToTest
     * @param stringLengthToTest
     * @return
     */
    static boolean tryCatchMethod(String numberToTest, int stringLengthToTest) {

        if (numberToTest.length() == stringLengthToTest) {

            try {

                for (int i = 0; i < stringLengthToTest; i++) {

                    Integer.parseInt(Character.toString(numberToTest.charAt(i)));
                }
            } catch (NumberFormatException e) {

                return false;
            }

            return true;

        } else {
            return false;
        }
    }

    /**
     *
     * @param codeToValidate
     * @return
     */
    static boolean winCondition(String codeToValidate) {
        int winPoint = 0;
        for (int i = 0; i < codeToValidate.length(); i++) {
            if (Character.toString(codeToValidate.charAt(i)).equals("=")) {
                winPoint = winPoint + 1;
            }
        }
        if (winPoint == codeToValidate.length()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param DFM
     * @param a
     * @return
     */
    static String rechercheDichotomique(int[][] DFM, int a) {

        for (int i = 0; i < a; i++) {
            DFM[i][0] = 0;
            DFM[i][1] = 10;
            DFM[i][2] = (DFM[i][0] + DFM[i][1]) / 2;
        }

        String rCode = "";
        for (int i = 0; i < a; i++) {
            rCode = rCode + DFM[i][2];
        }
        return rCode;
    }

    /**
     *
     * @param DFM
     * @param lastIndice
     * @param testCode
     * @return
     */
    static String rechercheDichotomique(int[][] DFM, String lastIndice, String testCode) {

        for (int i = 0; i < lastIndice.length(); i++) {
            if (Character.toString(lastIndice.charAt(i)).equals("+")) {
                DFM[i][0] = (Integer.parseInt(Character.toString(testCode.charAt(i))));
                DFM[i][2] = (DFM[i][0] + DFM[i][1]) / 2;
            } else if (Character.toString(lastIndice.charAt(i)).equals("-")) {
                DFM[i][1] = (Integer.parseInt(Character.toString(testCode.charAt(i))));
                DFM[i][2] = (DFM[i][0] + DFM[i][1]) / 2;
            }
        }

        String rCode = "";
        for (int i = 0; i < lastIndice.length(); i++) {
            rCode = rCode + DFM[i][2];
        }
        return rCode;
    }
}