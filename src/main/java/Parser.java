package gary;
import gary.ToDo;
import gary.Event;
import gary.Deadlines;
import gary.TaskList;
import gary.GaryException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Helps to decode the user input and
 * invoke the corresponding operation to be done
 */
public class Parser {
    String command = "";

    /**
     * Parse user input
     * @param input User input
     * @param tsk TaskList to be used
     * @return indication to end of user input
     */
    public boolean parse(String input, TaskList tsk) {
        try {
            String[] type = input.split(" ");
            String theTask = type[0];
            switch (theTask) {
                case "bye":
                    System.out.println("Bye, have a productive day!");
                    return true;
                case "todo":
                    tsk.addTodo(input.substring(5));
                    break;
                case "event":
                    String[] e = input.split("/", 5);
                    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy,HHmm");
                    LocalDateTime e1 = LocalDateTime.parse(e[1].strip(), inputFormat);
                    DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd LLL yyyy HH:mm a");
                    tsk.addEvent(e[0].substring(6), e1.format(outputFormat));
                    break;
                case "deadline":
                    String[] d = input.split("/", 5);
                    DateTimeFormatter inFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy,HHmm");
                    LocalDateTime d1 = LocalDateTime.parse(d[1].strip(), inFormat);
                    DateTimeFormatter outFormat = DateTimeFormatter.ofPattern("dd LLL yyyy HH:mm a");
                    tsk.addDeadline(d[0].substring(9), d1.format(outFormat));
                    break;
                default:
                    command = input;
                    tsk.invoke(input);
            }
        } catch (StringIndexOutOfBoundsException | GaryException e) {
            System.out.println("Ah please enter a valid description e.g. task_type name / date");
        } catch (DateTimeParseException e) {
            System.out.println("Ah please enter a valid date e.g. 19-01-2022,2359");
        }
        return false;
    }
}
