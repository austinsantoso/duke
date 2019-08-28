import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class DukeFileReader {
    private static ArrayList<Task> tasks = new ArrayList<Task>();

    /**
     * Returns the Task data present in the file path in the form of an arrayList
     * @param filePath the filepath to obtain data from
     * @return an arrayList that contains task data from the file path
     * @throws FileNotFoundException
     */
    public static ArrayList<Task> getData(String filePath) throws FileNotFoundException {
        ArrayList<Task> Tasks = new ArrayList<Task>();
        File f = new File(filePath);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineSplit = line.split("\\|");
            String eventType = lineSplit[0].trim();
            switch (eventType) {
                case "todo":
                    tasks.add(new ToDoTask(lineSplit[1].trim(), lineSplit[2].trim()));
                    break;
                case "event":
                    tasks.add(new EventsTask(lineSplit[1].trim(), lineSplit[2].trim(), lineSplit[3].trim()));
                    break;
                case "deadline":
                    tasks.add(new DeadlinesTask(lineSplit[1].trim(), lineSplit[2].trim(), lineSplit[3].trim()));
                    break;
                default:
                    throw new FileErrorDukeException(f.getAbsolutePath());
            }
        }
        return tasks;
    }

}

