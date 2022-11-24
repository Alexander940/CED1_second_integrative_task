package model;

public class Stack<T> {
    private StackNode top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    //Method to know the stack is empty
    public boolean isEmpty(){
        return top==null;
    }

    //Method to push a element in the stack
    public void push(T element){
        StackNode<T> newElement = new StackNode(element);
        newElement.next = top;
        top = newElement;
        size++;
    }

    //Method to pop up an element of the stack
    public T pop(){
        T aux = (T) top.fact;
        top = top.next;
        size--;
        return aux;
    }

    //Method to know what is the top
    public T top(){
        if(top!=null){
            return (T) top.fact;
        }
        return null;
    }

    //Method to return the size
    public int size(){
        return size;
    }

    //Method to empty the stack
    public void emptyStack(){
        while (!isEmpty()){
            pop();
        }
    }
}
