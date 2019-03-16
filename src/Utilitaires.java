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

    static String unknownNumber(String numberToCompare1, String numberToCompare2) {

        String comparedNumber = "";

            String operator;

            for (int i = 0; i < numberToCompare2.length(); i++) {
                if (Integer.parseInt(Character.toString(numberToCompare1.charAt(i))) == Integer.parseInt(Character.toString(numberToCompare2.charAt(i)))) {
                    operator = Character.toString(numberToCompare2.charAt(i));
                } else {
                    operator = "?";
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

    static boolean winCondition(String codeToValidate){
        int winPoint=0;
        for (int i = 0; i < codeToValidate.length(); i++) {
            if (Character.toString(codeToValidate.charAt(i)).equals("=")){
                winPoint=winPoint+1;
            }
        }
        if (winPoint==codeToValidate.length()){
            return true;
        } else{
            return false;
        }
    }
}
