package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DFSTest {

    private TrainStation trainStation;

    @Before
    public void setUp() throws Exception {
        trainStation = TrainStation.getInstance();
    }

    @Test
    public void assess_dfs() {
        TrainStation.getInstance().initializeGraph(3);

        TrainStation.getInstance().getGraph().setNameNodes(0, "algo1");
        TrainStation.getInstance().getGraph().setNameNodes(1, "algo2");
        TrainStation.getInstance().getGraph().setNameNodes(2, "algo3");

        TrainStation.getInstance().getGraph().setMatrixAdjacency(0, 2, 1);

        assertEquals(true, TrainStation.getInstance().calculateDFS(TrainStation.getInstance().getGraph(),0,2));
    }

    @Test
    public void assess_dfs_when_dont_have_a_path() {
        TrainStation.getInstance().initializeGraph(3);

        TrainStation.getInstance().getGraph().setNameNodes(0, "algo1");
        TrainStation.getInstance().getGraph().setNameNodes(1, "algo2");
        TrainStation.getInstance().getGraph().setNameNodes(2, "algo3");

        TrainStation.getInstance().getGraph().setMatrixAdjacency(0, 2, 1);

        assertEquals(false, TrainStation.getInstance().calculateDFS(TrainStation.getInstance().getGraph(),1,2));
    }

}