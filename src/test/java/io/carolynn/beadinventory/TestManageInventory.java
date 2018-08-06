package io.carolynn.beadinventory;

import org.junit.Test;

public class TestManageInventory {

    @Test
    public void testPrintMaterials(){
        ManageInventory management = new ManageInventory();
        System.out.println(management.printMaterials());
    }
}
