package model;

import java.util.Arrays;

public class Graph {

    // Sizes by default
    private int matrixCoefficient[][];
    private int matrixAdjacency[][];
    private int coordinatesX[];
    private int coordinatesY[];
    private String nameNodes[];

    public Graph() {}

    public Graph(final int numberNodes) {
        this.matrixCoefficient = new int[numberNodes][numberNodes];
        this.matrixAdjacency = new int[numberNodes][numberNodes];
        this.coordinatesX = new int[numberNodes];
        this.coordinatesY = new int[numberNodes];
        this.nameNodes = new String[numberNodes];
    }


    public boolean checkIfNameAlreadyExist(String nameNode) {
        return Arrays.stream(this.nameNodes).filter(name -> nameNode.equalsIgnoreCase(name)).count() >= 1;
    }

    public int returnPosition(String nameNode) {

        int position = 0;

        for (int i = 0; i < this.nameNodes.length; i++) {
            if (nameNodes[i].equalsIgnoreCase(nameNode)) {
                position = i;
            }
        }

        return position;
    }

    public int getMatrixCoefficient(int node1, int node2) {
        return matrixCoefficient[node1][node2];
    }

    public void setMatrixCoefficient(int positionX, int positionY, int coefficient) {
        this.matrixCoefficient[positionX][positionY] = coefficient;
    }

    public int getMatrixAdjacency(int positionX, int positionY) {
        return matrixAdjacency[positionX][positionY];
    }

    public void setMatrixAdjacency(int positionX, int positionY, int adjacency) {
        this.matrixAdjacency[positionX][positionY] = adjacency;
    }

    public int getCoordinatesX(int position) {
        return coordinatesX[position];
    }

    public void setCoordinatesX(int position, int coordinateX) {
        this.coordinatesX[position] = coordinateX;
    }

    public int getCoordinatesY(int position) {
        return coordinatesY[position];
    }

    public void setCoordinatesY(int position, int coordinateY) {
        this.coordinatesY[position] = coordinateY;
    }

    public String getNameNodes(int position) {
        return nameNodes[position];
    }

    public void setNameNodes(int position, String name) {
        this.nameNodes[position] = name;
    }
}
