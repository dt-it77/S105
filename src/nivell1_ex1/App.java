package nivell1_ex1;

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
            System.out.println("** LLista directori " + dir);
            Iterator<Path> files = Files.list(Paths.get(dir)).sorted().iterator();
            while (files.hasNext()) {
                System.out.println(files.next().getFileName());
            }
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
