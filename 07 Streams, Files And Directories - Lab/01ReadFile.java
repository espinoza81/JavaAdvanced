import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\bobi\\Java\\Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (InputStream in = new FileInputStream(path)) {
            int oneByte;
            while ((oneByte = in.read()) >=0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
