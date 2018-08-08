package io.carolynn.beadinventory;

import org.junit.Test;

public class TestManageInventory {

    @Test
    public void testPrintMaterials(){
        InventoryManager management = new InventoryManager();
        System.out.println(management.printMaterials());
    }
}
