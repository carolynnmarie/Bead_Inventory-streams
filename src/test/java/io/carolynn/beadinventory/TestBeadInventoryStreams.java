package io.carolynn.beadinventory;



import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.carolynn.beadinventory.Material.*;
import static io.carolynn.beadinventory.Shape.*;
import static io.carolynn.beadinventory.Quality.*;


public class TestBeadInventoryStreams {

    private Bead bead1 = new Bead(ADVENTURINE, "light green", 6, ROUND, "","",GOOD,
            30, 1);
    private Bead bead2 = new Bead(BLUE_ADVENTURINE, "dark blue", 4, ROUND, "","",GOOD,
            20, 2);
    private Bead bead3 = new Bead(GLASS, "light blue", 0, SEED_SMALL,"","",GOOD,
            150, 3);
    private ArrayList<Bead> beads = new ArrayList<>(Arrays.asList(bead1, bead2, bead3));
    private BeadInventoryStreams inventory = new BeadInventoryStreams(beads);

    @Test
    public void testGetTotalBeadCount(){
        long expected = 200;
        long actual = inventory.getTotalBeadCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentMaterialCount(){
        long expected = 3;
        long actual = inventory.getCurrentMaterialCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentColorList(){
        List<String> expected = new ArrayList<>(Arrays.asList("light green","dark blue", "light blue"));
        List<String> actual = inventory.getCurrentColorList();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentColorCount(){
        long expected = 2;
        long actual = inventory.getColorCount("blue");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentShapeList(){
        List<String> expected = new ArrayList<>(Arrays.asList("round","small seed"));
        List<String> actual = inventory.getCurrentShapeList();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetQuantityById(){
        int expected = 150;
        int actual = inventory.getQuantityById(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBeadById(){
        System.out.println(inventory.getBeadById(3));
    }

}
