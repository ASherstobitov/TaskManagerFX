package sample;

import java.util.LinkedList;

public class LimitedSizeStack<E> {
    private LinkedList<E> linkedList = new LinkedList<>();
    private int limit;

    public LimitedSizeStack(int limit) {
        this.limit = limit;
    }

    public void push(E e) {
        if (linkedList.size() == limit) {
            linkedList.removeFirst();
        }
        linkedList.add(e);
    }

    public E pop() {
        E e = linkedList.getLast();
        linkedList.removeLast();
        return e;
    }

    public E peek() {
        return linkedList.getLast();
    }
    public int size() {
        return linkedList.size();
    }

}
