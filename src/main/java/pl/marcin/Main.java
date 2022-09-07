package pl.marcin;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        // create the files structure
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

//        File f = new File(dirpath, dname);
//
//        // if directory exists,then
//        if (f.exists()) {
//            // get the contents into arr[]
//            // now arr[i] represent either a File or
//            // Directory
//            String arr[] = f.list();
//
//            // find no. of entries in the directory
//            int n = arr.length;
//
//            // displaying the entries
//            for (int i = 0; i < n; i++) {
//                System.out.println(arr[i]);
//                // create File object with the entry and
//                // test if it is a file or directory
//                File f1 = new File(arr[i]);
//                if (f1.isFile())
//                    System.out.println(": is a file");
//                if (f1.isDirectory())
//                    System.out.println(": is a directory");
//            }
//            System.out.println(
//                    "No of entries in this directory " + n);


    }
}