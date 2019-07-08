package fr.openclassrooms.project3.model.option;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    public static int NB_TRY = 6;
    public static int NB_DIGITS = 4;
    public static boolean DEVELOPPER_MODE = false;

    static public Properties config;

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
