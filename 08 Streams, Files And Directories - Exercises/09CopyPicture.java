import java.io.*;

public class CopyPicture {
    public static void main(String[] args) throws IOException {
        String inPath = "D:\\bobi\\Java\\Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture.jpg";
        String outputPath = "D:\\bobi\\Java\\Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture-copy.jpg";

        InputStream in = new FileInputStream(inPath);
        OutputStream out = new FileOutputStream(outputPath);

        byte[] allBytes = in.readAllBytes();
        out.write(allBytes);
    }
}
