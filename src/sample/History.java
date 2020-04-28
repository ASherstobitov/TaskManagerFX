package sample;

public abstract class History {
    private String nameTask;


    public History(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getTask() {
        return nameTask;
    }
}




