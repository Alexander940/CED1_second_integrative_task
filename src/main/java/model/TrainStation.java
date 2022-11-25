package model;

import util.ManageDataUtil;

import javax.swing.*;
import java.awt.*;

public class TrainStation {

    private static TrainStation instance;

    public static TrainStation getInstance(){
        if(instance == null){
            instance = new TrainStation();
        }
        return instance;
    }

    private Graph graph;

    private TrainStation(){
    }

    public void initializeGraph(int numberNodes){
        graph = new Graph(numberNodes);
    }

    public void generateSavedGraph(final Graphics graphics){
        initializeGraph(50);
        assignPositionsNodesSavedGraph(graphics);
        assignEdgesSavedGraph(graphics);
    }

    private void assignPositionsNodesSavedGraph(Graphics graphics) {
        String positions = ManageDataUtil.getPositionsGraph();

        String [] separatePositions = positions.split(";");

        for (int i = 0; i < separatePositions.length; i++) {
            String [] eachPosition = separatePositions[i].split("-");
            Pinter.printNodeInGraph(graphics, Integer.parseInt(eachPosition[0]), Integer.parseInt(eachPosition[1]), String.valueOf(i+1));
            graph.setNameNodes(i, String.valueOf(i+1));
            graph.setCoordinatesX(i, Integer.parseInt(eachPosition[0]));
            graph.setCoordinatesY(i, Integer.parseInt(eachPosition[1]));
        }
    }

    private void assignEdgesSavedGraph(Graphics graphics) {
        String read = ManageDataUtil.getEdgesGraph();

        String [] adjacency = read.split(";");

        for (int i = 0; i < graph.getNumberNodes(); i++) {
            String [] eachAdjacency = adjacency[i].split("-");
            for (int j = 0; j < graph.getNumberNodes(); j++) {
                int weight = 0;

                graph.setMatrixAdjacency(i, j, Integer.parseInt(eachAdjacency[j]));

                if(graph.getMatrixAdjacency(j, i) == 1){
                    weight = graph.getMatrixCoefficient(j, i);
                } else {
                    weight = (int)(Math.random()*9+1);
                }

                graph.setMatrixCoefficient(i, j, weight);
                if(Integer.parseInt(eachAdjacency[j]) == 1){
                    Pinter.printEdge(graphics, graph.getCoordinatesX(i), graph.getCoordinatesY(i), graph.getCoordinatesX(j), graph.getCoordinatesY(j), weight);
                }
            }
        }
    }

    public void generateRandomGraph(final Graphics graphics){
        initializeGraph(50);
        assignPositionsNodesRandomGraph(graphics);
        assignEdgesRandomGraph(graphics);
    }

    private void assignEdgesRandomGraph(Graphics graphics) {
        for (int i = 0; i < graph.getNumberNodes()*2; i++) {
            int weight = (int)(Math.random()*9+1);
            int node1 = (int)(Math.random()*49);
            int node2 = (int)(Math.random()*49);

            if(node1 == node2){
                i--;
            } else if(graph.getMatrixAdjacency(node1, node2) == 1){
                i--;
            } else {
                graph.setMatrixAdjacency(node1, node2, 1);
                graph.setMatrixCoefficient(node1, node2, weight);
                Pinter.printEdge(graphics, graph.getCoordinatesX(node1), graph.getCoordinatesY(node1), graph.getCoordinatesX(node2), graph.getCoordinatesY(node2), weight);
            }
        }
    }

    private void assignPositionsNodesRandomGraph(final Graphics graphics) {
        for (int i = 0; i < graph.getNumberNodes(); i++) {
            int positionX = (int)(Math.random()*700+200);
            int positionY = (int)(Math.random()*810+1);
            Pinter.printNodeInGraph(graphics, positionX, positionY, String.valueOf(i));
            graph.setNameNodes(i, String.valueOf(i));
            graph.setCoordinatesX(i, positionX);
            graph.setCoordinatesY(i, positionY);
        }
    }

    public boolean calculateDFS(Graph graph, String node1, String node2){
        DFS dfs = new DFS(graph, node1, node2);
        return dfs.dfs();
    }

    public void calculateDijkstra(final JPanel pinterGraph, String node1, String node2){
        Dijkstra dijkstra = new Dijkstra(graph, graph.getNodes().length, graph.returnPosition(node1), graph.returnPosition(node2), node1, node2);
        dijkstra.dijkstra(pinterGraph);
    }

    public Graph getGraph() {
        return graph;
    }
}
