import java.io.*;

public class SerializeCustomObject02 {
    static class Course implements Serializable {
        String name;
        int students;

        public Course(String name, int students) {
            this.name = name;
            this.students = students;
        }
    }

    public static void main(String[] args) {
        String path = "src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/course.ser";
        Course course = new Course("Java Advanced", 250);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            oos.writeObject(course);
            Course courseFromFile = (Course) ois.readObject();
            System.out.println(courseFromFile.name);
            System.out.println(courseFromFile.students);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
