package fr.openclassrooms.project3.model;

import fr.openclassrooms.project3.model.gamemode.Challenger;
import fr.openclassrooms.project3.model.gamemode.Defender;
import fr.openclassrooms.project3.model.gamemode.Duel;

/**
 * Class fr.openclassrooms.project3.model.Model
 *
 * @author NoelH
 */
public class Model {

    public static final int MENU_MAIN = 0;
    public static final int MENU_MODE = 1;
    public static final int MENU_END = 2;

    private static int menu = MENU_MAIN;

    public static final int INFO_NONE = -1;
    public static final int INFO_ERROR_ENTRY = 0;
    public static final int INFO_BYEBYE = 1;
    public static final int INFO_BACK_MAIN_MENU = 2;

    private static int info = INFO_NONE;

    public static final int LAST_GAME_NONE = -1;
    public static final int LAST_GAME_CHALLENGER = 0;
    public static final int LAST_GAME_DEFENDER = 1;
    public static final int LAST_GAME_DUEL = 2;

    private static int lastGame = LAST_GAME_NONE;

    /**
     * Methode qui permet de recuperer la valeur de la variable info
     *
     * @return
     */
    public static int getInfo(){
        return info;
    }

    /**
     * Methode qui permet de recuperer la valeur de la variable menu
     *
     * @return
     */
    public static int getMenu(){
        return menu;
    }

    /**
     * Methode qui permet d'enrengistrer le dernier mode de jeu jouer dans la variable lastGame
     */
    public static void replayLastGame(){
        switch (lastGame){
            case LAST_GAME_NONE:
                break;
            case LAST_GAME_CHALLENGER:
                Challenger.game();
                break;
            case LAST_GAME_DEFENDER:
                Defender.game();
                break;
            case LAST_GAME_DUEL:
                Duel.game();
                break;
        }

    }

    /**
     * Methode qui modifie les variables necessaires en fonction de la saisie utilisateur
     *
     * @param userChoice = saisie recuperer avec la methode parseInput
     * @return
     */
    private static boolean executeUserChoiceMainMenu(int userChoice) {
        switch (userChoice) {
            case 1:
                menu = MENU_MODE;
                return false;

            case 2:
                info = INFO_BYEBYE;
                return true;

            default:
                info = INFO_ERROR_ENTRY;
                return false;
        }
    }

    /**
     * Methode qui modifie les variables necessaires en fonction de la saisie utilisateur
     *
     * @param userChoice = saisie recuperer avec la methode parseInput
     * @return
     */
    private static boolean executeUserChoiceGameModeSelection(int userChoice){
        switch (userChoice) {
            case 1:
                Challenger.game();
                menu = MENU_END;
                lastGame = LAST_GAME_CHALLENGER;
                return true;

            case 2:
                Defender.game();
                menu = MENU_END;
                lastGame = LAST_GAME_DEFENDER;
                return true;

            case 3:
                Duel.game();
                menu = MENU_END;
                lastGame = LAST_GAME_DUEL;
                return true;

            case 4:
                menu = MENU_MAIN;
                info = INFO_BACK_MAIN_MENU;
                return true;

            case 5:
                info = INFO_BYEBYE;
                return true;

            default:
                info = INFO_ERROR_ENTRY;
                return false;
        }
    }

    /**
     * Methode qui modifie les variables necessaires en fonction de la saisie utilisateur
     *
     * @param userChoice = saisie recuperer avec la methode parseInput
     * @return
     */
    private static boolean executeUserChoiceEndGameMenu(int userChoice){
        switch (userChoice) {
            case 1:
                replayLastGame();
                return true;

            case 2:
                info = INFO_BACK_MAIN_MENU;
                menu = MENU_MAIN;
                return true;

            case 3:
                info = INFO_BYEBYE;
                return true;

            default:
                info = INFO_ERROR_ENTRY;
                return false;
        }
    }

    /**
     * Methode qui modifie les variables necessaires en fonction de la saisie utilisateur
     *
     * @param selection = saisie recuperer avec la methode parseInput
     */
    public static void executeUserChoice(int selection){
        info = INFO_NONE;
        switch (menu) {
            case MENU_MAIN:
                executeUserChoiceMainMenu(selection);
                break;

            case MENU_MODE:
                executeUserChoiceGameModeSelection(selection);
                break;

            case MENU_END:
                executeUserChoiceEndGameMenu(selection);
                break;
        }
    }
}