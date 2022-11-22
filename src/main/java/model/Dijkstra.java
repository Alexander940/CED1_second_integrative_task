package model;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Dijkstra {

    private Graph graph;
    private Node auxNode = null;
    private int auxAccumulated;
    private int subAccumulated;
    private Node nodes[];
    private int auxNumberMaxNodes;
    private int numberMaxNodes;
    private int positionPermanentNode;
    private int positionEndNode;
    private String namePermanentNode;
    private String nameEndNode;


    public Dijkstra(Graph graph, int numberMaxNodes, int positionPermanentNode, int positionEndNode, String namePermanentNode, String nameEndNode) {
        this.graph = graph;
        this.nodes = new Node[numberMaxNodes];
        this.numberMaxNodes = numberMaxNodes;
        this.positionPermanentNode = positionPermanentNode;
        this.positionEndNode = positionEndNode;
        this.namePermanentNode = namePermanentNode;
        this.nameEndNode = nameEndNode;
    }


    public int getAccumulated() {
        return nodes[positionEndNode].getAccumulator();
    }

    public void dijkstra(final JPanel pinterGraph) {
        for(int i = 0; i < numberMaxNodes; i++) nodes[i] = new Node();

        if(positionPermanentNode != positionEndNode) {

            do {
                nodes[positionPermanentNode].setWasVisited(true);
                nodes[positionPermanentNode].setName(namePermanentNode);
                nodes[positionPermanentNode].setTag(true);

                subAccumulated = 0;
                auxAccumulated = Integer.MAX_VALUE;
                for (int j = 0; j < numberMaxNodes; j++) {
                    if (graph.getMatrixAdjacency(positionPermanentNode, j) == 1) {
                        subAccumulated = nodes[positionPermanentNode].getAccumulator() + graph.getMatrixCoefficient(positionPermanentNode, j);
                        if (subAccumulated <= nodes[j].getAccumulator() && nodes[j].wasVisited() && !nodes[j].isTag()) {
                            nodes[j].setAccumulator(subAccumulated);
                            nodes[j].setWasVisited(true);
                            nodes[j].setName(graph.getNameNodes(j));
                            nodes[j].setPredecessor(nodes[positionPermanentNode]);
                        } else if(!nodes[j].wasVisited()) {
                            nodes[j].setAccumulator(subAccumulated);
                            nodes[j].setWasVisited(true);
                            nodes[j].setName(graph.getNameNodes(j));
                            nodes[j].setPredecessor(nodes[positionPermanentNode]);
                        }
                    }
                }

                for(int i = 0; i < numberMaxNodes; i++) {
                    if(nodes[i].wasVisited() && !nodes[i].isTag() && nodes[i].getAccumulator() <= auxAccumulated) {
                        positionPermanentNode = i;
                        namePermanentNode = graph.getNameNodes(i);
                        auxAccumulated = nodes[i].getAccumulator();
                    }
                }
                auxNumberMaxNodes++;
            } while (auxNumberMaxNodes < numberMaxNodes + 1);

            auxNode = nodes[positionEndNode];
            if(auxNode.getPredecessor() == null) {
                JOptionPane.showMessageDialog(null, "We can not arrive at end node");
            }

            while (auxNode.getPredecessor() != null) {
                Pinter.printTheShortestPath(pinterGraph.getGraphics(), graph.getCoordinatesX(graph.returnPosition(auxNode.getName())), graph.getCoordinatesY(graph.returnPosition(auxNode.getName())),
                        graph.getCoordinatesX(graph.returnPosition(auxNode.getPredecessor().getName())), graph.getCoordinatesY(graph.returnPosition(auxNode.getPredecessor().getName())), Color.GREEN);
                auxNode = auxNode.getPredecessor();
            }
        }
    }

    @Override
    public String toString() {
        return "Dijkstra{" +
                "graph=" + graph +
                ", auxNode=" + auxNode.toString() +
                ", auxAccumulated=" + auxAccumulated +
                ", subAccumulated=" + subAccumulated +
                ", nodes=" + Arrays.toString(nodes) +
                ", auxNumberMaxNodes=" + auxNumberMaxNodes +
                ", numberMaxNodes=" + numberMaxNodes +
                ", positionPermanentNode=" + positionPermanentNode +
                ", positionEndNode=" + positionEndNode +
                ", namePermanentNode='" + namePermanentNode + '\'' +
                ", nameEndNode='" + nameEndNode + '\'' +
                '}';
    }
}
