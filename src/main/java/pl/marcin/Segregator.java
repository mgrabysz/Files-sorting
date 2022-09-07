package pl.marcin;

import java.io.File;

public class Segregator {

    public String getExtension(File file) {
        String fileName = file.toString();
        int index = fileName.lastIndexOf('.');
        String extension = fileName.substring(index + 1);
        return extension;
    }

    public void segregate(File home) {
        File[] files = home.listFiles();

        for (File file : files) {

            if (file.isFile()) {
                String extension = getExtension(file);
                System.out.println(extension);
            }
        }
    }
}
