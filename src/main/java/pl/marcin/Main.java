package pl.marcin;

import java.io.File;

public class Main {
    public static void main(String[] args) {

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
//        File emptyJar = new File("HOME/emptyJar.jar");
//        emptyJar.createNewFile();
//        File emptyJar2 = new File("HOME/emptyJar2.jar");
//        emptyJar2.createNewFile();
//        File emptyXML = new File(("HOME/emptyXML.xml"));
//        emptyXML.createNewFile();

        File[] files = home.listFiles();

        for (File file : files) {
            System.out.println(file.getName());

            if (file.isFile()) {
                String fileName = file.toString();
                int index = fileName.lastIndexOf('.');
                String extension = fileName.substring(index + 1);
                System.out.println(extension);
            }
        }

    }
}