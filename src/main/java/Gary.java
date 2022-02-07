import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Gary {
    public static void main(String[] args) throws GaryException {

        ArrayList<Task> items = new ArrayList<>();
        System.out.println("Hello, i'm Gary! What's on your to do list today?\n");
        try {
            File f = new File("./gary.txt");
            Scanner sc2 = new Scanner(f);
            System.out.println("This is your current to do list.\n");
            while (sc2.hasNext()) {
                Gary.decode(sc2.nextLine(), items);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No history recorded, let's start being productive today!");
        }

        Scanner sc = new Scanner(System.in);
        String nxt = sc.nextLine();

        while (!nxt.equals("bye")) {
            try {

                if (nxt.equals("list")) {
                    Gary.printList(1, items);
                } else if (nxt.equals("mark")) {
                    System.out.println("which tasks have you completed? e.g. 2 3");
                    String nums = sc.nextLine();
                    String[] first = nums.split(" ");
                    int i = 0;
                    for (String str : first) {
                        items.get(Integer.parseInt(first[i]) - 1).toMark();
                        i++;
                    }
                    saveTask("./gary.txt", items);
                    Gary.printList(2, items);

                } else if (nxt.equals("unmark")) {
                    System.out.println("made some mistakes?");
                    String nums = sc.nextLine();
                    String[] first = nums.split(" ");
                    int k = 0;
                    for (String str : first) {
                        items.get(Integer.parseInt(first[k]) - 1).toUnmark();
                        k++;
                    }
                    saveTask("./gary.txt", items);

                } else if (nxt.equals("delete")) {
                    System.out.println("Please key in what you would like to remove in descending order!");
                    try {
                        String nums = sc.nextLine();
                        String[] first = nums.split(" ");
                        int k = 0;
                        for (String str : first) {
                            items.remove(Integer.parseInt(first[k]) - 1);
                            k++;
                        }
                        Gary.printList(2, items);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Ah please enter a valid number or sequence e.g. 5 3 1");
                    }
                    saveTask("./gary.txt", items);

                } else {
                    String[] type = nxt.split(" ");
                    String theTask = type[0];
                    try {
                        if (!theTask.equals("todo") && !theTask.equals("event") && !theTask.equals("deadline")) {
                            throw new GaryException(nxt); // invalid input
                        }
                    } catch (GaryException e) {
                        e.GaryError();
                    }

                    try {
                        switch (theTask) {
                            case "todo":
                                items.add(new ToDo(nxt.substring(5)));
                                break;
                            case "event":
                                String[] e = nxt.split("/", 5);
                                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy,HHmm");
                                LocalDateTime e1 = LocalDateTime.parse(e[1].strip(), inputFormat);
                                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd LLL yyyy HH:mm a");
                                items.add(new Event(e[0].substring(6), e1.format(outputFormat)));
                                break;
                            case "deadline":
                                String[] d = nxt.split("/", 5);
                                DateTimeFormatter inFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy,HHmm");
                                LocalDateTime d1 = LocalDateTime.parse(d[1].strip(), inFormat);
                                DateTimeFormatter outFormat = DateTimeFormatter.ofPattern("dd LLL yyyy HH:mm a");
                                items.add(new Deadlines(d[0].substring(9), d1.format(outFormat)));
                                break;
                        }
                        saveTask("./gary.txt", items);
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Ah please enter a valid description e.g. task_type name / date");
                    } catch (DateTimeParseException e) {
                        System.out.println("Ah please enter a valid date e.g. 19-01-2022,2359");
                    }
                }
            } catch (IOException e) {
                File newFile = new File("./gary.txt");
                System.out.println("please try again");
            }
                nxt = sc.nextLine(); // continue getting inputs
            }
        System.out.println("Bye, hope you stay productive!\n");
    }

    private static void printList(int type, ArrayList<Task> item) {
        if (type == 1) {
            System.out.println("Tasks:");
        } else {
            System.out.println("Alright, this is your updated to do list");
        }
        int j = 1;
        for (Task str : item) {
            System.out.printf("%d. %s\n", j, str);
            j++;
        }
    }

    private static void saveTask(String fpath,ArrayList<Task> list) throws IOException {
        FileWriter fw = new FileWriter(fpath);
        fw.write("1. " + list.get(0).toString() + System.lineSeparator()); // overwrite first line
        fw.close();
        FileWriter fw2 = new FileWriter(fpath, true);
        int len = list.size();
        for (int i = 1; i < len; i++) {
            fw2.write(i+1 + ". " + list.get(i).toString() + System.lineSeparator()); // append
        }
        fw2.close();
    }

    private static void decode(String str, ArrayList<Task> items) {
        System.out.println(str);
        char type = str.charAt(3);
        boolean isDone = str.charAt(5) == 'X';
        switch (type) {
            case 'T':
                items.add(new ToDo(str.substring(8)));
                break;
            case 'E':
                String[] e = str.split("on:", 5);
                items.add(new Event(e[0].substring(8), e[1]));
                break;
            case 'D':
                String[] d = str.split("by:", 5);
                items.add(new Deadlines(d[0].substring(8), d[1]));
                break;
        }
        if(isDone) {
            int len = items.size();
            items.get(len - 1).toMark();
        }
    }
}
