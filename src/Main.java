import java.io.*;
import java.util.Properties;

/**
 * Class Main
 *
 * @author Noel-H
 */
public class Main {

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
            System.out.println("Fichier non trouvé");
            return false;
        } catch (IOException e) {
            System.out.println("Erreur de lecture");
            return false;
        }

        return true;
    }

    /**
     * Methode main
     *
     * @param args Parametre args
     */
    static public void main(String... args) {

        if (loadConfig()) {
            MenuPrincipal.principalMenu();
        }
    }
}