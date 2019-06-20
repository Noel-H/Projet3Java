package fr.openclassrooms.projet3;

import fr.openclassrooms.projet3.Model.option.Configuration;
import fr.openclassrooms.projet3.Model.menu.MenuPrincipal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Class fr.openclassrooms.projet3.Main
 *
 * @author Noel-H
 */
public class Main {

    //---------------------------------------------------------Log4j
    static Logger logger = LogManager.getLogger(Main.class);

    //---------------------------------------------------------


    /**
     * Methode main
     *
     * @param args Parametre args
     */
    static public void main(String[] args) {

        logger.trace("Entering fr.openclassrooms.projet3.Model.menu.MenuPrincipal.");

        Configuration.ConfigParam();

        if (args.length > 0 && args[0].equals("-d")){
            Configuration.DEVELOPPER_MODE = true;
        }

        MenuPrincipal.principalMenu();
    }
}

