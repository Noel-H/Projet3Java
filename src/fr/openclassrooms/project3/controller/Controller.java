package fr.openclassrooms.project3.controller;

import fr.openclassrooms.project3.model.Model;

/**
 * Class fr.openclassrooms.project3.controller.Controller
 *
 * @author NoelH
 */
public class Controller {

    /**
     * Permet de teste si l'entree utilisateur est bien un int.
     *
     * @param input = Entree utilisateur qui sera teste par la methode.
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
     * Permet d'executer le choix de l'utilisateur grace a l'input saisie et verifie si il s'agit bien d'un int à l'aide d'une autre methode.
     *
     * @param input
     */
    public static void parseInput(String input){
        int selection = getNumberSelection(input);
        Model.executeUserChoice(selection);
    }
}