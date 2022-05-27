import java.io.File;
import java.io.IOException;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\bobi\\Java\\Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if(file.exists()){
            File[] files = file.listFiles();
            for (File f : files != null ? files : new File[0]) {
                if(!f.isDirectory()){
                    System.out.println(f.getName() + ": [" + f.length() + "]");
                }
            }
        }
    }
}
