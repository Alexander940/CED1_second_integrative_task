package model;

import org.junit.Before;
import util.ManageDataUtil;

import static org.junit.Assert.*;

public class DijkstraTest {

    private Graph graph;
    private Dijkstra dijkstra;

    @Before
    public void setUp() throws Exception {
        graph = new Graph(50);
        fillGraph();
    }

    private void fillGraph(){
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



}