package fr.openclassrooms.project3.model.option;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Cette Class permet la configuration de certain element du programme.
 */
public class Configuration {

    public static int NB_TRY = 6;
    public static int NB_DIGITS = 4;
    public static boolean DEVELOPPER_MODE = false;

    static public Properties config;

    /**
     * Methode qui permet de charger le fichier de configuration.
     *
     * @return
     */
    static private boolean loadConfig() {

        config = new Properties();

        try {
            InputStream file = new FileInputStream("config.properties");
            config.load(file);
        } catch (FileNotFoundException e) {
            return true;
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Methode qui permet de verififer les valeurs contenu dans le fichier de configuration.
     *
     * Si celle ci sont incorrecte, une valeur par defaut est utilise.
     */
    public static void ConfigParam(){
        if (loadConfig()) {
            try {
                NB_TRY = Integer.parseInt(Configuration.config.getProperty("nb_try"));
            } catch (NumberFormatException e) {

            }

            try {
                NB_DIGITS = Integer.parseInt(Configuration.config.getProperty("nb_digits"));
            } catch (NumberFormatException e) {

            }

            try {
                DEVELOPPER_MODE = Boolean.parseBoolean(Configuration.config.getProperty("developper_mode"));
            } catch (NumberFormatException e) {

            }
        }
    }
}
