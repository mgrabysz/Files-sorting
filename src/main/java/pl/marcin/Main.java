package pl.marcin;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // create the file structure
        File home = new File("HOME");
        if (! home.exists()) {
            home.mkdir();
        }
        File dev = new File("HOME/DEV");
        if (! dev.exists()) {
            dev.mkdir();
        }
        File test = new File("HOME/TEST");
        if (! test.exists()) {
            test.mkdir();
        }

        // test set
//        File emptyJar = new File("HOME/emptyJarEven.jar");
//        emptyJar.createNewFile();
//        File emptyJar2 = new File("HOME/emptyJar2.jar");
//        emptyJar2.createNewFile();
//        File emptyXML = new File(("HOME/emptyXML.xml"));
//        emptyXML.createNewFile();

        Segregator segregator = new Segregator();
        segregator.segregate(home);

    }
}