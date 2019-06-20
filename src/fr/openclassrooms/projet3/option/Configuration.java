package fr.openclassrooms.projet3.option;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    public static int NB_TRY = 6;
    public static int NB_NUMBER_LENGTH = 4;
    public static boolean DEVELOPPER_MODE = false;

    static public Properties config;

    static private boolean loadConfig() {

        config = new Properties();

        try {
            InputStream file = new FileInputStream("config.properties");
            config.load(file);
        } catch (FileNotFoundException e) {
//            System.out.println("Fichier non trouvé");
//            logger.error("Fichier \"config.properties\" non trouvé");
            return true;
        } catch (IOException e) {
//            System.out.println("Erreur de lecture");
//            logger.error("Erreur de lecture");
            return false;
        }

        return true;
    }

    ///////////////////////////////////////
    public static void ConfigParam(){
        if (loadConfig()) {
            try {
                NB_TRY = Integer.parseInt(Configuration.config.getProperty("nb_try"));
            } catch (NumberFormatException e) {
//                logger.error("Certaines valeurs du fichier de configuration sont incorrectes. Une valeur par défaut sera utilisé.");
            }

            try {
                NB_NUMBER_LENGTH = Integer.parseInt(Configuration.config.getProperty("nb_number_length"));
            } catch (NumberFormatException e) {
//                logger.error("Certaines valeurs du fichier de configuration sont incorrectes. Une valeur par défaut sera utilisé.");
            }

            try {
                DEVELOPPER_MODE = Boolean.parseBoolean(Configuration.config.getProperty("developper_mode"));
            } catch (NumberFormatException e) {
//                logger.error("Certaines valeurs du fichier de configuration sont incorrectes. Une valeur par défaut sera utilisé.");
            }
        }
    }
}
