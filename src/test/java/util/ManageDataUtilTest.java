package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ManageDataUtilTest {

    @Test
    public void read_position_nodes_graph() {
        String positions = "800-70;752-709;644-333;313-455;780-549;395-272;797-663;460-271;784-654;510-720;466-108;185-294;664-272;713-243;250-662;388-664;598-761;694-183;712-676;503-733;672-365;845-726;574-92;680-778;702-221;731-470;560-135;778-77;833-693;293-68;342-369;718-155;575-331;561-659;276-269;249-374;184-266;898-130;253-503;826-751;193-31;418-202;225-165;493-395;357-163;233-237;366-137;612-367;203-413";

        assertEquals(positions, ManageDataUtil.getPositionsGraph());
    }
}