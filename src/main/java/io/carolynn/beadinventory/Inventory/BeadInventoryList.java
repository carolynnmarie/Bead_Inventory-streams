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
        Bead adXSm =new Bead(ADVENTURINE,GREEN,"light",4,ROUND," ", GOOD,34);
        Bead adSm = new Bead(ADVENTURINE,GREEN,"light",6,ROUND," ", GOOD,78);
        Bead adMedDark = new Bead(ADVENTURINE,GREEN,"dark",8,ROUND," ", GOOD,25);
        Bead adMed = new Bead(ADVENTURINE,GREEN,"medium",8,ROUND," ", GOOD,80);
        Bead adMedLight = new Bead(ADVENTURINE,GREEN,"light",8,ROUND," ", GOOD,35);
        Bead adLg = new Bead(ADVENTURINE,GREEN,"medium",10,ROUND," ", GOOD,60);

        Bead bAdSmDark = new Bead(BLUE_ADVENTURINE,BLUE,"dark",6,ROUND," ", GOOD,44);
        Bead bAdSmBright = new Bead(BLUE_ADVENTURINE,BLUE,"bright",6,ROUND," ", GOOD,41);
        Bead bAdSm = new Bead(BLUE_ADVENTURINE,BLUE,"light",6,ROUND," ", GOOD,66);
        Bead bAdXSm = new Bead(BLUE_ADVENTURINE,BLUE,"bluepurple",4,ROUND," ", GOOD,71);

        Bead jasperLg = new Bead(JASPER, BLACK, "",10,ROUND,"",GOOD, 5);
        Bead jasperMed = new Bead(JASPER,BLACK,"",8,ROUND,"",GOOD,90);
        Bead jasperSm = new Bead(JASPER,BLACK,"",6,ROUND,"",GOOD,91);
        Bead jasperXSm = new Bead(JASPER,BLACK,"",4,ROUND,"",GOOD,100);

        Bead amLg = new Bead(AMETHYST,PURPLE,"dark",10,ROUND,"",GOOD,40);

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
