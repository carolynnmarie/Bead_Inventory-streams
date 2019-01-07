package io.carolynn.beadinventory.Inventory;

import io.carolynn.beadinventory.Beads.Bead;

import java.util.ArrayList;
import java.util.Arrays;

import static io.carolynn.beadinventory.Beads.ColorFamily.*;
import static io.carolynn.beadinventory.Material.*;
import static io.carolynn.beadinventory.Quality.GOOD;
import static io.carolynn.beadinventory.Beads.Shape.ROUND;

public class BeadInventoryList {

    private ArrayList<Bead> inventory;

    public BeadInventoryList() {
        Bead adXSm =new Bead(ADVENTURINE,GREEN,"light",4,ROUND," ", GOOD,34, .05);
        Bead adSm = new Bead(ADVENTURINE,GREEN,"light",6,ROUND," ", GOOD,78, .05);
        Bead adMedDark = new Bead(ADVENTURINE,GREEN,"dark",8,ROUND," ", GOOD,25, .05);
        Bead adMed = new Bead(ADVENTURINE,GREEN,"medium",8,ROUND," ", GOOD,80, .05);
        Bead adMedLight = new Bead(ADVENTURINE,GREEN,"light",8,ROUND," ", GOOD,35, .05);
        Bead adLg = new Bead(ADVENTURINE,GREEN,"medium",10,ROUND," ", GOOD,60, .05);

        Bead bAdSmDark = new Bead(BLUE_ADVENTURINE,BLUE,"dark",6,ROUND," ", GOOD,44, .05);
        Bead bAdSmBright = new Bead(BLUE_ADVENTURINE,BLUE,"bright",6,ROUND," ", GOOD,41, .05);
        Bead bAdSm = new Bead(BLUE_ADVENTURINE,BLUE,"light",6,ROUND," ", GOOD,66, .05);
        Bead bAdXSm = new Bead(BLUE_ADVENTURINE,BLUE,"bluepurple",4,ROUND," ", GOOD,71, .05);

        Bead jasperLg = new Bead(JASPER, BLACK, "",10,ROUND,"",GOOD, 5, .05);
        Bead jasperMed = new Bead(JASPER,BLACK,"",8,ROUND,"",GOOD,90, .05);
        Bead jasperSm = new Bead(JASPER,BLACK,"",6,ROUND,"",GOOD,91, .05);
        Bead jasperXSm = new Bead(JASPER,BLACK,"",4,ROUND,"",GOOD,100, .05);

        Bead amLg = new Bead(AMETHYST,PURPLE,"dark",10,ROUND,"",GOOD,40, .05);

        this.inventory = new ArrayList<>(Arrays.asList(adXSm,adSm,adMedDark,adMed,adMedLight,adLg,bAdSmDark,bAdSmBright,
                bAdSm,bAdXSm, jasperLg,jasperMed,jasperSm,jasperXSm,amLg));
    }

    public BeadInventoryList(ArrayList<Bead> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Bead> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Bead> inventory) {
        this.inventory = inventory;
    }
}
