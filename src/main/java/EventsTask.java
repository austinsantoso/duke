public class EventsTask extends Task {
    String taskName;
    String taskTime;

    public EventsTask(String task) {
        super(task);
        String[] taskSplit = task.split("/");
        if(taskSplit.length < 2) {
            throw new EmptyDescriptionDukeException("event");
        }
        taskName = taskSplit[0].trim();
        String taskTimeOriginal = taskSplit[1];
        int firstWordLength = taskTimeOriginal.split(" ")[0].length();
        taskTime = taskTimeOriginal.split(" ")[0] + ": " + taskTimeOriginal.substring(firstWordLength).trim();
    }

    @Override
    public String toString() {
        String output = "[E]";
        if (super.completed) {
            output += "[✓]";
        } else {
            output += "[✗]";
        }
        output += " " + this.taskName + " (" + this.taskTime + ")";
        return output;
    }
}