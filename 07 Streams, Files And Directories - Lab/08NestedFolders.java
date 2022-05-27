import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class NestedFolders {
    public static void main(String[] args) {
        File root = new File("D:\\bobi\\Java\\Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        System.out.println(root.getName());
        int countDirectory = 1;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File f : Objects.requireNonNull(nestedFiles)) {
                if (f.isDirectory()) {
                    dirs.offer(f);
                    System.out.println(f.getName());
                    countDirectory++;
                }
            }
        }
        System.out.println(countDirectory + " folders");
    }
}
