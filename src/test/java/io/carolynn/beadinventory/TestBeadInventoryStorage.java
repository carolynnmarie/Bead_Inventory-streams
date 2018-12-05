package io.carolynn.beadinventory;


import io.carolynn.beadinventory.Beads.*;
import io.carolynn.beadinventory.Inventory.BeadInventoryStorage;
import io.carolynn.beadinventory.Inventory.TrackBeadInventory;
import java.nio.file.Paths;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.carolynn.beadinventory.Material.*;


public class TestBeadInventoryStorage {

    Bead bead = new Bead(Material.ADVENTURINE,ColorFamily.GREEN,"dark",6,Shape.ROUND,
            " ",Quality.GOOD,17);
    Bead bead2 = new Bead(Material.ADVENTURINE,ColorFamily.GREEN,"light",8,Shape.ROUND,
            " ",Quality.GOOD,17);
    Bead bead3 = new Bead(Material.BLUE_ADVENTURINE,ColorFamily.BLUE,"light",8,Shape.ROUND,
            " ",Quality.GOOD,20);

    private ArrayList<Bead> beads = new ArrayList<>(Arrays.asList(bead, bead2, bead3));
    private TrackBeadInventory inventory = new TrackBeadInventory(Paths.get("/Users/carolynn/dev/BeadInventoryTesty.ser"));

    @Before
    public void setup(){
        inventory.getInventory().setBeads(beads);
    }

    @Test
    public void testGetTotalBeadCount(){
        long expected = 54;
        long actual = inventory.getBeadCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentMaterialCount(){
        long expected = 2;
        long actual = inventory.getCurrentMaterialCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentMaterialList(){
//        List<String> expected = new ArrayList<>(Arrays.asList("adventurine, blue adventurine"));
        String expected = "adventurine, blue adventurine, ";
        List<String> actual1 = inventory.getCurrentMaterialList();
        StringBuilder builder = new StringBuilder();
        actual1.stream().forEach(e->builder.append(e).append(", "));
        String actual = builder.toString();
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
        String expected = "green: dark, green: light, ";
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
        long actual = inventory.countMaterialSizeColor(ADVENTURINE,8,ColorFamily.GREEN,"light");
        Assert.assertEquals(expected,actual);
    }

}
