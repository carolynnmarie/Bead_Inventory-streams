package io.carolynn.beadinventory;



import io.carolynn.beadinventory.Beads.*;
import io.carolynn.beadinventory.Inventory.InventoryTracker;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.carolynn.beadinventory.Material.*;


public class TestBeadInventoryStreams {

    Bead bead = new Bead(Material.ADVENTURINE,ColorFamily.GREEN,"dark",6,Shape.ROUND,
            " ",Quality.GOOD,17);
    Bead bead2 = new Bead(Material.ADVENTURINE,ColorFamily.GREEN,"light",8,Shape.ROUND,
            " ",Quality.GOOD,17);
    Bead bead3 = new Bead(Material.BLUE_ADVENTURINE,ColorFamily.BLUE,"light",8,Shape.ROUND,
            " ",Quality.GOOD,20);

    private ArrayList<Bead> beads = new ArrayList<>(Arrays.asList(bead, bead2, bead3));
    private InventoryTracker inventory = new InventoryTracker(beads);

    @Test
    public void testGetTotalBeadCount(){
        long expected = 54;
        long actual = inventory.countTotalBeads();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentMaterialCount(){
        long expected = 3;
        long actual = inventory.countCurrentMaterials();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentMaterialList(){
        List<String> expected = new ArrayList<>(Arrays.asList("adventurine, blue adventurine"));
        List<String> actual = inventory.getCurrentMaterialList();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testGetCurrentShapeList(){
        List<String> expected = new ArrayList<>(Arrays.asList("round"));
        List<String> actual = inventory.getCurrentShapeList();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentColorsOfMaterial(){
        String expected = "GREEN: dark, GREEN: light, ";
        String actual = inventory.getCurrentColorsOfMaterial(ADVENTURINE);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentColorsOfMaterialSize(){
        String expected = "green: dark, ";
        String actual = inventory.getCurrentColorsOfMaterialSize(ADVENTURINE,6);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testCountOfMaterialSizeColor(){
        long expected = 17;
        long actual = inventory.countOfMaterialSizeColor(ADVENTURINE,8,ColorFamily.GREEN,"light");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testChangeQuantity(){
        int expected = 50;
        inventory.changeQuantity(bead,50);
        int actual = bead.getQuantity();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testChangeQuantyFromDescription(){
        int expected = 50;
        inventory.changeQuantityFromDescription(ADVENTURINE,6, ColorFamily.GREEN,"dark",50);
        int actual = bead.getQuantity();
        Assert.assertEquals(expected,actual);
    }

}
