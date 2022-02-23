package nivell1_ex2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        try{
            if(args.length < 1){
                throw new Exception("Necessites passar per argument el directori a llistar el seu contingut");
            }
            String dir = args[0];
            printFilesInDir(dir);
        }catch(Exception e){
            System.err.println(e);
        }
    }
    private static void printFilesInDir(String dir) throws IOException{
        System.out.println("Contingut Directori:  " + dir);
        Iterator<Path> files = Files.list(Paths.get(dir)).sorted().iterator();
        while (files.hasNext()) {
            File file = new File(files.next().toString());
            if(file.isDirectory()){
                printFilesInDir(file.getAbsolutePath());
            }else{
                System.out.println("Fitxer: " + file.getName());
            }
        }
    }
}
