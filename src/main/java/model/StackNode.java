package model;

public class StackNode<T> {
    T fact;
    StackNode next;

    public StackNode(T data) {
        this.fact = data;
        next = null;
    }
}
