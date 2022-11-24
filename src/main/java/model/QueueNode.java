package model;

public class QueueNode<T> {

    T fact;
    QueueNode next;

    public QueueNode(T fact) {
        this.fact = fact;
        next = null;
    }
}
