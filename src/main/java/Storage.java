package gary;
import gary.Task;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private static String file;

    public Storage(String path) {
        file = path;
    }

    public ArrayList<String> loadFile() {
        ArrayList<String> content = new ArrayList<>();
        try {
            File f = new File(file);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                content.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("New file created:");
            File newFile = new File("./gary.txt");
        }
        return content;
    }

    public static void saveTask(ArrayList<Task> list) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write("1. " + list.get(0).toString() + System.lineSeparator()); // overwrite first line
            fw.close();
            FileWriter fw2 = new FileWriter(file, true);
            int len = list.size();
            for (int i = 1; i < len; i++) {
                fw2.write(i + 1 + ". " + list.get(i).toString() + System.lineSeparator()); // append
            }
            fw2.close();
        } catch (IOException e) {
            System.out.println("No file to save into???");
        }
    }
}