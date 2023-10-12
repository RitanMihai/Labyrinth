package org.example.backend;

public class Node {
    private String label;
    private Integer position;
    private static Integer positionCounter = 0;

    public Node(String label) {
        this.label = label;
        position = Node.positionCounter++;
    }
    public Node() {
        position = Node.positionCounter++;
        this.label = this.position.toString();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getPosition() {
        return this.position;
    }

    public  void setPosition(Integer position) {
        this.position = position;
    }
}
