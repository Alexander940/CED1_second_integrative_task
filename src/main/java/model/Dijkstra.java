package model;

import javax.swing.*;
import java.awt.*;

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

    public Node dijkstra(final JPanel pinterGraph) {
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
                        if ((subAccumulated <= nodes[j].getAccumulator() && nodes[j].wasVisited() && !nodes[j].isTag()) || !nodes[j].wasVisited()) {
                            nodes[j].setAccumulator(subAccumulated);
                            nodes[j].setWasVisited(true);
                            nodes[j].setName(graph.getNameNode(j));
                            nodes[j].setPredecessor(nodes[positionPermanentNode]);
                        }
                    }
                }

                this.findNextNodePermanent();
                auxNumberMaxNodes++;
            } while (auxNumberMaxNodes < numberMaxNodes + 1);

            this.drawTheShortestPath(pinterGraph);
            return nodes[positionEndNode];
        }
    }

    private void findNextNodePermanent() {
        for(int i = 0; i < numberMaxNodes; i++) {
            if(nodes[i].wasVisited() && !nodes[i].isTag() && nodes[i].getAccumulator() <= auxAccumulated) {
                positionPermanentNode = i;
                namePermanentNode = graph.getNameNode(i);
                auxAccumulated = nodes[i].getAccumulator();
            }
        }
    }

    private void drawTheShortestPath(final JPanel pinterGraph) {

        auxNode = nodes[positionEndNode];
        if(auxNode.getPredecessor() == null) {
            JOptionPane.showMessageDialog(null, "We can not arrive at end node");
        }

        while (auxNode.getPredecessor() != null) {
            Pinter.highlightLine(pinterGraph.getGraphics(), graph.getCoordinatesX(graph.returnPosition(auxNode.getName())), graph.getCoordinatesY(graph.returnPosition(auxNode.getName())),
                    graph.getCoordinatesX(graph.returnPosition(auxNode.getPredecessor().getName())), graph.getCoordinatesY(graph.returnPosition(auxNode.getPredecessor().getName())), Color.GREEN);
            auxNode = auxNode.getPredecessor();
        }
    }
}
