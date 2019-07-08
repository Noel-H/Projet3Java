package fr.openclassrooms.project3.controller;

import fr.openclassrooms.project3.model.Model;

/**
 *
 * @author NoelH
 */
public class Controller {

    /**
     *
     * @param input
     * @return
     */
    private static int getNumberSelection(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     *
     * @param input
     */
    public static void parseInput(String input){
        int selection = getNumberSelection(input);
        Model.executeUserChoice(selection);
    }
}