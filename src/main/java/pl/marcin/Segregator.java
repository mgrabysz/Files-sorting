package pl.marcin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class Segregator {

    private int movedToTest, movedToDev, movedTotal;

    public int getMovedToTest() {
        return movedToTest;
    }

    public int getMovedToDev() {
        return movedToDev;
    }

    public int getMovedTotal() {
        return movedTotal;
    }

    public Segregator() {
        movedTotal = movedToDev = movedToTest = 0;
    }

    public String getExtension(File file) {
        String fileName = file.toString();
        int index = fileName.lastIndexOf('.');
        String extension = fileName.substring(index + 1);
        return extension;
    }

    public int getCreationHour(File file) throws IOException {
        FileTime creationTime = (FileTime) Files.getAttribute(file.toPath(), "creationTime");
        LocalDateTime ldt =  LocalDateTime.ofInstant(creationTime.toInstant(), ZoneId.systemDefault());
        return ldt.getHour();
    }

    public void segregate(File home) throws IOException {
        File[] files = home.listFiles();

        for (File file : files) {

            // determine if file is not a directory
            if (file.isFile()) {

                String extension = getExtension(file);
                if (extension.equals("jar")) {

                    // determine the creation hour
                    int hour = getCreationHour(file);

                    // if hour is even move the file to DEV
                    if (hour % 2 == 0) {
                        file.renameTo(new File("HOME/DEV/"+file.getName()));
                        movedToDev++;
                        movedTotal++;
                    }
                    // in other case move the file to TEST
                    else {
                        file.renameTo(new File("HOME/TEST/" + file.getName()));
                        movedToTest++;
                        movedTotal++;
                    }
                } else if (extension.equals("xml")) {
                    file.renameTo(new File("HOME/DEV/"+file.getName()));
                    movedToDev++;
                    movedTotal++;
                }
            }
        }

        // crete the count.txt file and actualise it
        File count = new File("HOME/count.txt");
        count.createNewFile();

        FileWriter myWriter = new FileWriter("HOME/count.txt");
        myWriter.write("Number of files moved to HOME/DEV: " + movedToDev + "\n");
        myWriter.write("Number of files moved to HOME/TEST: " + movedToTest + "\n");
        myWriter.write("Number of files moved in total: " + movedTotal + "\n");
        myWriter.close();
    }
}
