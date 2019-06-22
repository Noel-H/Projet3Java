package fr.openclassrooms.projet3.Controller;

import fr.openclassrooms.projet3.Model.Model;

public class Controller {
    private static int getNumberSelection(String input){
        try {

            return Integer.parseInt(input);

        } catch (NumberFormatException e) {

            return -1;
        }

    }

    public static void parseInput(String input){

        int selection = getNumberSelection(input);
        Model.executeUserChoice(selection);

    }

}
