package fr.openclassrooms.project3.model.option;

/**
 * Cette class contient un ensemble de methode utile et reutilisable pour le programme.
 *
 * @author NoelH
 */
public class Utility {


    /**
     * Permet de generer un nombre aleatoire.
     *
     * @param quantityToGenerate Represente la quantite de chiffre a generer aleatoirement pour cette methode.
     * @return Retourne un nombre aleatoire.
     */
    public static String randomNumberGenerator(int quantityToGenerate) {
        String generatedNumber = "";

        for (int i = 0; i < quantityToGenerate; i++) {
            generatedNumber = generatedNumber + ((int) (Math.random() * 10));
        }

        return generatedNumber;
    }

    /**
     * Permet de comparer deux nombres entre eux
     *
     * @param numberToCompare1 Correspond au nombre numero un
     * @param numberToCompare2 Correspond au nombre numero deux
     * @return une chaine de caractere constitue de symbole tel que "+" "-" "="
     */
    public static String numberComparator(String numberToCompare1, String numberToCompare2) {
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
     * Permet de formatter une chaine de caractere.
     * Exemple : abcd = | a | b | c | d |
     *
     * @param stringToFormat Correspond a la chaine de caractere
     * @return La chaine de caracatere formatter
     */
    public static String styleFormat1(String stringToFormat) {
        String formatedString = "";

        for (int i = 0; i < stringToFormat.length(); i++) {
            String charToFormat = Character.toString(stringToFormat.charAt(i));

            formatedString = formatedString + "| " + charToFormat + " ";
        }
        return formatedString + "|";
    }

    /**
     * Permet de verifier la validite que la saisie de l'user soit conforme
     *
     * @param numberToTest       Correspond au nombre a verifier
     * @param stringLengthToTest Correspond a la longueur que doit avoir la chaine de caractere
     * @return Retourne vrai ou faux en fonction du resultat
     */
    public static boolean tryCatchMethod(String numberToTest, int stringLengthToTest) {
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
     * Permet de vérifier le format de l'indice donne par l'user
     *
     * @param answerToTest          Correspond à l'indice donne par l'user
     * @param stringLengthToTest    Correspond à la longueur que doit avoir la chaine de caractere
     * @return                      Retourne vrai ou faux en fonction du resultat
     */
    public static boolean indiceFormatVerification(String answerToTest, int stringLengthToTest) {
        int correctIndiceFormat = 0;

        if (answerToTest.length() == stringLengthToTest) {
            for (int i = 0; i < stringLengthToTest; i++) {
                if (Character.toString(answerToTest.charAt(i)).equals("=") || Character.toString(answerToTest.charAt(i)).equals("+") || Character.toString(answerToTest.charAt(i)).equals("-")) {
                    correctIndiceFormat++;
                }
            }
            if (correctIndiceFormat == stringLengthToTest){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * Permet de verifier si les condition de victoire sont atteinte
     *
     * @param codeToValidate
     *          Correspond a la chaine de caratere qui doit etre verifier
     * @return
     *          Retourne vrai ou faux en fonction du resultat
     */
    public static boolean winCondition(String codeToValidate) {
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
     * Permet de faire une recherche dichotomique sans indice et code
     *
     *
     * @param DFM
     *          Correspond au tableau a utiliser pour la methode
     * @param codeLength
     *          Correspond a la longueur de la chaine de caractere
     * @return
     *          Retourne une chaine dde caractere correspond au resultat de la dichotomie
     */
    public static String rechercheDichotomique(int[][] DFM, int codeLength) {
        for (int i = 0; i < codeLength; i++) {
            DFM[i][0] = 0;
            DFM[i][1] = 10;
            DFM[i][2] = (DFM[i][0] + DFM[i][1]) / 2;
        }

        String rCode = "";

        for (int i = 0; i < codeLength; i++) {
            rCode = rCode + DFM[i][2];
        }
        return rCode;
    }

    /**
     * Permet de faire une recherche dichotomique avec un indice et un code
     *
     * @param DFM
     *          Correspond au tableau a utiliser pour la methode
     * @param lastIndice
     *          Correspond a la chaine de caractere contenant les indices de la recherche precedente
     * @param testCode
     *          Correspond a la chaine de caractere contenant le code precedent pour en generer un nouveau
     * @return
     *          Retourne une chaine de caractere correspondant au nouveau code generer
     */
    public static String rechercheDichotomique(int[][] DFM, String lastIndice, String testCode) {
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