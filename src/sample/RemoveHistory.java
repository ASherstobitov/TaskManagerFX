package sample;

public class RemoveHistory extends History {
    private int index;


    public RemoveHistory(String nameTask, int index) {
        super(nameTask);
        this.index = index;
    }


    public int getIndex() {
        return index;
    }
}
