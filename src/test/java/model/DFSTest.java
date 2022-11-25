package model;

import org.junit.Before;
import org.junit.Test;
import util.ManageDataUtil;

import static org.junit.Assert.*;

public class DFSTest {

    private Graph graph;
    private DFS dfs;

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
    public void when_it_is_connected1() {
        fillGraph1();
        dfs = new DFS(graph, "1", "30");

        assertEquals(true, dfs.dfsNodeToNode());
    }

    @Test
    public void when_it_is_connected2() {
        fillGraph1();
        dfs = new DFS(graph, "6", "16");

        assertEquals(true, dfs.dfsNodeToNode());
    }

    @Test
    public void when_it_is_connected3() {
        fillGraph1();
        dfs = new DFS(graph, "11", "23");

        assertEquals(true, dfs.dfsNodeToNode());
    }

    @Test
    public void when_it_is_not_connected1() {
        fillGraph1();
        dfs = new DFS(graph, "1", "27");

        assertEquals(false, dfs.dfsNodeToNode());
    }

    @Test
    public void when_it_is_not_connected2() {
        fillGraph1();
        dfs = new DFS(graph, "9", "24");

        assertEquals(false, dfs.dfsNodeToNode());
    }

    @Test
    public void when_it_is_not_connected3() {
        fillGraph1();
        dfs = new DFS(graph, "46", "43");

        assertEquals(false, dfs.dfsNodeToNode());
    }

    @Test
    public void when_there_is_a_node_without_with_others_1() {
        fillGraph1();
        dfs = new DFS(graph, "20", "35");

        assertEquals(false, dfs.dfsNodeToNode());
    }

    @Test
    public void when_there_is_a_node_without_with_others_2() {
        fillGraph1();
        dfs = new DFS(graph, "41", "35");

        assertEquals(false, dfs.dfsNodeToNode());
    }

    @Test
    public void when_there_is_a_node_without_with_others_3() {
        fillGraph1();
        dfs = new DFS(graph, "44", "35");

        assertEquals(false, dfs.dfsNodeToNode());
    }

    @Test
    public void when_the_all_graph_is_related() {
        fillGraph2();
        dfs = new DFS(graph);

        assertTrue(dfs.dfsAllRelated());
    }

    @Test
    public void when_the_all_graph_is_not_related() {
        fillGraph1();
        dfs = new DFS(graph);

        assertFalse(dfs.dfsAllRelated());
    }
}