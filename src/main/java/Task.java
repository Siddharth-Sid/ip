public class Task {
    protected String description;
    protected boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public Task(String isCompleted, String description) {
        this.description = description;
        this.isCompleted = isCompleted.equals("1") ? true : false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIsCompleted() {
        return this.isCompleted ? "1" : "0";
    }

    public String getStatusIcon() {
        return (isCompleted ? "X" : " "); // mark done task with X
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), this.getDescription());
    }
}