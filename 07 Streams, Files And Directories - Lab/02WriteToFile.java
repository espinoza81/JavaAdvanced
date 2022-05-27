import java.io.*;
import java.util.HashSet;
import java.util.Set;


public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String inPath = "D:\\bobi\\Java\\Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\bobi\\Java\\Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
        Set<Character> punctuations = new HashSet<>();
        Collections.addAll(punctuations, '.', ',', '!', '?');
        OutputStream out = new FileOutputStream(outputPath);
        try (InputStream in = new FileInputStream(inPath)) {
            int oneByte;
            while ((oneByte = in.read()) >= 0) {
                if(!punctuations.contains((char) oneByte)){
                    out.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
