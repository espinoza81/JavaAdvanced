import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String inPath = "D:\\bobi\\Java\\Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\bobi\\Java\\Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        BufferedReader in = new BufferedReader(new FileReader(inPath));
        PrintWriter out = new PrintWriter(new FileWriter(outputPath));

        int counter = 1;
        String line;
        while ((line = in.readLine()) != null) {
            if (counter % 3 == 0) out.println(line);
            counter++;
        }
        out.close();
    }
}
