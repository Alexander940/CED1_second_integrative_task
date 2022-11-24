package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ManageDataUtilTest {

    @Test
    public void read_position_nodes_graph() {
        String positions = "272-140;490-200;307-360;497-580;750-364;334-619;727-171;530-409;749-643;521-711;611-66;631-295;674-527;395-482;450-122;873-294;400-269;842-138;671-756;813-481;355-56;398-764;756-90;506-320;279-254;874-733;571-522;264-493;763-251;588-187;528-63;884-590;370-185;611-670;407-564;219-407;261-743;886-64;206-58;203-283;239-610;200-166;899-436;659-426;410-382;664-614;440-690;773-758;557-788;659-136";

        assertEquals(positions, ManageDataUtil.getPositionsGraph());
    }
}