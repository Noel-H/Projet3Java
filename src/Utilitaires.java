public class Utilitaires {

    static String randomNumberGenerator(int quantityToGenerate) {

        String generatedNumber = "";
        String numberGenerate[] = new String[quantityToGenerate];

        for (int i = 0; i < quantityToGenerate; i++) {

            numberGenerate[i] = Integer.toString((int) (Math.random() * 10));
            generatedNumber = generatedNumber + numberGenerate[i];
        }


        return generatedNumber;
    }

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

    static String styleFormat1(String stringToFormat) {

        String formatedString = "";


        for (int i = 0; i < stringToFormat.length(); i++) {
            String charToFormat = Character.toString(stringToFormat.charAt(i));

            formatedString = formatedString + "| " + charToFormat + " ";
        }

        return formatedString + "|";

    }

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

    static String rechercheDichotomique(String code, String previousCode, String indice) {

        String newCode = "";

        int idD;
        int idF;
        int idM;
        int idV;

        for (int i = 0; i < code.length(); i++) {
            if (Character.toString(indice.charAt(i)).equals("=")) {
                int a = (Integer.parseInt(Character.toString(code.charAt(i))));
                newCode = newCode + (a);
            } else if (Character.toString(indice.charAt(i)).equals("+")) {

                idD=(Integer.parseInt(Character.toString(previousCode.charAt(i))));
                idF=9;
                idM=;
                idV=(Integer.parseInt(Character.toString(code.charAt(i))));

                int idC=(idM+idV)/2;

                newCode = newCode + (idC);
            } else if ((Character.toString(indice.charAt(i)).equals("-"))) {

                idD=0;
                idF=9;
                idM=(Integer.parseInt(Character.toString(previousCode.charAt(i))));
                idV=(Integer.parseInt(Character.toString(code.charAt(i))));


                newCode = newCode + (idV);
            }

        }

        return newCode;
    }

}