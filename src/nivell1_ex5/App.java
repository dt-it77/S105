package nivell1_ex5;

import java.io.*;

public class App {
    public static void main(String[] args) {
        try{
            //crear objecte
            ObjectClass objectSerialized = new ObjectClass(23,"Michael Jordan");
            //serialitzar
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("java.ser"));
            oos.writeObject(objectSerialized);
            oos.close();

            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("java.ser"));
            ObjectClass objectDeserialized = (ObjectClass)ois.readObject();            
            System.out.println("Objecte Deserialitzat:");
            System.out.println("ID: " + objectDeserialized.id + " Valor:" + objectDeserialized.value);
        }catch(Exception e){
            System.err.println(e.getStackTrace());
        }
    }
}
