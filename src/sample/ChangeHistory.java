package sample;

public class ChangeHistory extends History{
    private String oldValue;

    private int index;


    public ChangeHistory(String nameTask, String oldValue, int index) {
        super(nameTask);
        this.oldValue = oldValue;
        this.index = index;
    }


    public int getIndex() {
        return index;
    }

    public String getOldValue() {
        return oldValue;
    }
}
