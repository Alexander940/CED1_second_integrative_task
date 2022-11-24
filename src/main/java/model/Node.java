package model;

public class Node {

    private String name;
    private boolean wasVisited;
    private int accumulator;
    private Node predecessor;
    private boolean isTag;

    public Node() {
        this.name = "";
        this.wasVisited = false;
        this.accumulator = 0;
        this.predecessor = null;
        this.isTag = false;
    }

    public Node(String name) {
        this.name = name;
        this.wasVisited = false;
        this.accumulator = 0;
        this.predecessor = null;
        this.isTag = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean wasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    public boolean isTag() {
        return isTag;
    }

    public void setTag(boolean tag) {
        isTag = tag;
    }
}
