import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Class Main
 *
 * @author Noel-H
 */
public class Main {

    public static int NB_TRY = 6;
    public static int NB_NUMBER_LENGTH = 4;
    public static boolean DEVELOPPER_MODE = false;

    static public Properties config;

    /**
     * Methode pour charger le fichier de config
     *
     * @return
     *          Retourne true si le fichier s'est charger sans soucis et false dans le cas contraire
     */
    static private boolean loadConfig() {

        config = new Properties();

        try {
            InputStream file = new FileInputStream("config.properties");
            config.load(file);
        } catch (FileNotFoundException e) {
//            System.out.println("Fichier non trouvé");
            logger.error("Fichier \"config.properties\" non trouvé");
            return true;
        } catch (IOException e) {
//            System.out.println("Erreur de lecture");
            logger.error("Erreur de lecture");
            return false;
        }

        return true;
    }

    //---------------------------------------------------------Log4j
    static Logger logger = LogManager.getLogger(Main.class);

    //---------------------------------------------------------


    /**
     * Methode main
     *
     * @param args Parametre args
     */
    static public void main(String... args) {


        logger.trace("Entering MenuPrincipal.");
        if (loadConfig()) {

            try {
                NB_TRY = Integer.parseInt(Main.config.getProperty("nb_try"));
                NB_NUMBER_LENGTH = Integer.parseInt(Main.config.getProperty("nb_number_length"));
                DEVELOPPER_MODE = Boolean.parseBoolean(Main.config.getProperty("developper_mode"));
            } catch (NumberFormatException e){
                logger.error("Certaines valeurs du fichier de configuration sont incorrectes. Une valeur par défaut sera utilisé.");
            }
            MenuPrincipal.principalMenu();
        }
    }
}