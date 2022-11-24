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

    public void generateRandomGraph(){

    }

    public void initializeGraph(int numberNodes){
        graph = new Graph(numberNodes);
    }

    public void createGraph(final Graphics graphics){
        graph = new Graph(50);

        assignPositionsNodes(graphics);
        assignEdges(graphics);
    }

    private void assignEdges(Graphics graphics) {
        for (int i = 0; i < 49; i++) {
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

    private void assignPositionsNodes(final Graphics graphics) {
        String positions = ManageDataUtil.getPositionsGraph();

        String [] separatePositions = positions.split(";");

        for (int i = 0; i < separatePositions.length; i++) {
            String [] eachPosition = separatePositions[i].split("-");
            Pinter.printNodeInGraph(graphics, Integer.parseInt(eachPosition[0]), Integer.parseInt(eachPosition[1]), String.valueOf(i));
            graph.setNameNodes(i, String.valueOf(i));
            graph.setCoordinatesX(i, Integer.parseInt(eachPosition[0]));
            graph.setCoordinatesY(i, Integer.parseInt(eachPosition[1]));
        }
    }

    public boolean dfs(int i, int f){
        boolean [] visited = new boolean[graph.getNodes().length];
        Stack<Node> actual = new Stack<>();
        actual.push(graph.getNodes()[i]);
        return dfs(i, f, visited, actual);
    }

    private boolean dfs(int a, int f, boolean [] visited, Stack<Node> actual){
        for (int i = 0; i < visited.length; i++) {
            if(graph.getMatrixAdjacency(a, i) == 1 && i == f){
                return true;
            } else if(graph.getMatrixAdjacency(a, i) == 1 && !visited[i]) {
                actual.push(graph.getNodes()[i]);
                visited[i] = true;
                return dfs(i, f, visited, actual);
            }
        }
        actual.pop();
        if(actual.top() != null){
            return dfs(graph.returnPosition(actual.top().getName()), f, visited, actual);
        }
        return false;
    }

    public Graph getGraph() {
        return graph;
    }

    public void calculateDijkstra(final JPanel pinterGraph, int node1, int node2){
        Dijkstra dijkstra = new Dijkstra(graph, graph.getNodes().length, node1, node2, String.valueOf(node1), String.valueOf(node2));
        dijkstra.dijkstra(pinterGraph);
    }
}
