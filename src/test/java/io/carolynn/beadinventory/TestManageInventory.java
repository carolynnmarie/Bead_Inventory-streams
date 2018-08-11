package io.carolynn.beadinventory;

import org.junit.Test;

public class TestManageInventory {

    @Test
    public void testPrintMaterials(){
        CreateBeads management = new CreateBeads();
        System.out.println(management.printMaterials());
    }
}
