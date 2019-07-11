package fr.openclassrooms.project3;

import fr.openclassrooms.project3.controller.Controller;
import fr.openclassrooms.project3.model.option.Configuration;
import fr.openclassrooms.project3.view.Displayer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Class fr.openclassrooms.project3.Main
 *
 * @author Noel-H
 */
public class Main {
    public static final Logger logger = LogManager.getLogger("GLOBAL");

    /**
     * Methode main
     *
     * @param args = Utiliser "-d" Pour activer le mode developpeur.
     */
    static public void main(String[] args) {

        Configuration.ConfigParam();

        if (args.length > 0 && args[0].equals("-d")) {
            Configuration.DEVELOPPER_MODE = true;
        }

        while (true){
            Displayer.display();
            Controller.parseInput(Displayer.getUserEntry());
        }
    }
}