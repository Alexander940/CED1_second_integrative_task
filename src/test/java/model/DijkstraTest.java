package model;

import org.junit.Before;
import org.junit.Test;
import util.ManageDataUtil;

import javax.swing.*;

import static org.junit.Assert.*;

public class DijkstraTest {

    private Graph graph;
    private Dijkstra dijkstra;

    @Before
    public void setUp() throws Exception {
        graph = new Graph(50);
    }

    private void fillGraph1(){
        String positions = ManageDataUtil.getPositionsGraph();

        String [] separatePositions = positions.split(";");

        for (int i = 0; i < separatePositions.length; i++) {
            String [] eachPosition = separatePositions[i].split("-");
            graph.setNameNodes(i, String.valueOf(i+1));
            graph.setCoordinatesX(i, Integer.parseInt(eachPosition[0]));
            graph.setCoordinatesY(i, Integer.parseInt(eachPosition[1]));
        }

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
                    int positionXNode1 = graph.getCoordinatesX(i);
                    int positionYNode1 = graph.getCoordinatesY(i);
                    int positionXNode2 = graph.getCoordinatesY(j);
                    int positionYNode2 = graph.getCoordinatesY(j);
                    weight = TrainStation.getInstance().calculateWeight(positionXNode1, positionYNode1, positionXNode2, positionYNode2);
                }

                graph.setMatrixCoefficient(i, j, weight);
            }
        }
    }

    private void fillGraph2(){
        String positions = ManageDataUtil.getPositionsGraph();

        String [] separatePositions = positions.split(";");

        for (int i = 0; i < separatePositions.length; i++) {
            String [] eachPosition = separatePositions[i].split("-");
            graph.setNameNodes(i, String.valueOf(i+1));
            graph.setCoordinatesX(i, Integer.parseInt(eachPosition[0]));
            graph.setCoordinatesY(i, Integer.parseInt(eachPosition[1]));
        }

        String read = ManageDataUtil.getEdgesGraphRelated();

        String [] adjacency = read.split(";");

        for (int i = 0; i < graph.getNumberNodes(); i++) {
            String [] eachAdjacency = adjacency[i].split("-");
            for (int j = 0; j < graph.getNumberNodes(); j++) {
                int weight = 0;

                graph.setMatrixAdjacency(i, j, Integer.parseInt(eachAdjacency[j]));

                if(graph.getMatrixAdjacency(j, i) == 1){
                    weight = graph.getMatrixCoefficient(j, i);
                } else {
                    int positionXNode1 = graph.getCoordinatesX(i);
                    int positionYNode1 = graph.getCoordinatesY(i);
                    int positionXNode2 = graph.getCoordinatesY(j);
                    int positionYNode2 = graph.getCoordinatesY(j);
                    weight = TrainStation.getInstance().calculateWeight(positionXNode1, positionYNode1, positionXNode2, positionYNode2);
                }

                graph.setMatrixCoefficient(i, j, weight);
            }
        }
    }

    @Test
    public void when_there_are_too_many_routes_but_choose_the_better1() {
        fillGraph2();

        dijkstra = new Dijkstra(graph, graph.getNumberNodes(), graph.returnPosition("1"), graph.returnPosition("30"), "1", "30");

        Node node = dijkstra.dijkstra(null);

        assertEquals("30", node.getName());

        node = node.getPredecessor();

        assertEquals("2", node.getName());

        node = node.getPredecessor();

        assertEquals("1", node.getName());
    }

    @Test
    public void when_there_are_too_many_routes_but_choose_the_better2() {
        fillGraph2();

        dijkstra = new Dijkstra(graph, graph.getNumberNodes(), graph.returnPosition("1"), graph.returnPosition("23"), "1", "23");

        Node node = dijkstra.dijkstra(null);

        assertEquals("23", node.getName());

        node = node.getPredecessor();

        assertEquals("24", node.getName());

        node = node.getPredecessor();

        assertEquals("13", node.getName());

        node = node.getPredecessor();

        assertEquals("7", node.getName());

        node = node.getPredecessor();

        assertEquals("4", node.getName());

        node = node.getPredecessor();

        assertEquals("3", node.getName());

        node = node.getPredecessor();

        assertEquals("1", node.getName());
    }

    @Test
    public void when_there_are_too_many_routes_but_choose_the_better3() {
        fillGraph2();

        dijkstra = new Dijkstra(graph, graph.getNumberNodes(), graph.returnPosition("28"), graph.returnPosition("36"), "28", "36");

        Node node = dijkstra.dijkstra(null);

        assertEquals("36", node.getName());

        node = node.getPredecessor();

        assertEquals("28", node.getName());
    }

    @Test
    public void when_there_are_not_some_route1() {
        fillGraph1();

        dijkstra = new Dijkstra(graph, graph.getNumberNodes(), graph.returnPosition("1"), graph.returnPosition("40"), "1", "40");

        Node node = dijkstra.dijkstra(null);

        assertEquals("" ,node.getName());
    }

    @Test
    public void when_there_are_not_some_route2() {
        fillGraph1();

        dijkstra = new Dijkstra(graph, graph.getNumberNodes(), graph.returnPosition("24"), graph.returnPosition("25"), "24", "25");

        Node node = dijkstra.dijkstra(null);

        assertEquals("" ,node.getName());
    }
}