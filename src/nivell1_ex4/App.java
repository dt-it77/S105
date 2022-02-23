package nivell1_ex4;

import java.io.IOException;
import java.io.*;

public class App {
    public static void main(String[] args) {
        try{
            if(args.length < 1){
                throw new Exception("Necessites passar per argument la ruta del fitxer a llegir");
            }
            String file = args[0];
            FileReader fileReader = new FileReader(file);
            System.out.println("===Sortida per pantalla lectura fitxer: " + file);
            int valor = fileReader.read();
            while(valor != -1){
                System.out.print((char)valor);
                valor = fileReader.read();
            }
            fileReader.close();
        }catch(IOException e){
            System.err.println(e.getMessage());
        }catch(Exception e){
            System.err.println(e.getStackTrace());
        }
    }
}
