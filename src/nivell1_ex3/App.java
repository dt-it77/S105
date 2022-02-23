package nivell1_ex3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import java.io.*;

public class App {
    public static void main(String[] args) {
        try{
            if(args.length < 1){
                throw new Exception("Necessites passar per argument el directori a llistar el seu contingut");
            }
            String dir = args[0];
            printFilesInDir(dir);
        }catch(IOException e){
            System.err.println(e.getMessage());
        }catch(Exception e){
            System.err.println(e.getStackTrace());
        }
    }
    private static void printFilesInDir(String dir) throws IOException{
        System.out.println("Contingut Directori:  " + dir);
        writeToFile("Contingut Directori:  " + dir);
        Iterator<Path> files = Files.list(Paths.get(dir)).sorted().iterator();
        while (files.hasNext()) {
            File file = new File(files.next().toString());
            if(file.isDirectory()){
                printFilesInDir(file.getAbsolutePath());
            }else{
                System.out.println("Fitxer: " + file.getName());
                writeToFile("Fitxer: " + file.getName());
            }
        }
    }
    private static void writeToFile(String message) throws IOException{
        FileWriter fileWriter = new FileWriter("ContingutDirectori.txt",true);
        fileWriter.write(message+"\n");
        fileWriter.close();
    }
}
