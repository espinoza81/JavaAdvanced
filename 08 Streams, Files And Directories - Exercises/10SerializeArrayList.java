import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) {
        String path = "src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/ArrayList.ser";
        List<String> birds = new ArrayList<>();
        birds.add("Chervenushka");
        birds.add("Sokol orko");
        birds.add("Kokilobegach");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            oos.writeObject(birds);
            Object listFromFile =  ois.readObject();
            System.out.println(listFromFile);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
