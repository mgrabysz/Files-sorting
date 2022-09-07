package pl.marcin;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

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

        Segregator segregator = new Segregator();

        // code below for listening to changes in directory
        // comes from official Oracle documentation
        // https://docs.oracle.com/javase/tutorial/essential/io/notification.html

        WatchService watcher = FileSystems.getDefault().newWatchService();
        home.toPath().register(watcher, ENTRY_CREATE);

        for (;;) {

            // wait for key to be signaled
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            for (WatchEvent<?> event: key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                if (kind == OVERFLOW) {
                    continue;
                }

                WatchEvent<Path> ev = (WatchEvent<Path>)event;
                Path filename = ev.context();

                // Verify that the new
                //  file is a text file.
                try {
                    Path child = home.toPath().resolve(filename);
                    segregator.segregateFile(new File(child.toString()));
                } catch (IOException x) {
                    System.err.println(x);
                    continue;
                }
            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }
}
