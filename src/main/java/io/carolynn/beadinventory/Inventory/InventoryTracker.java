package io.carolynn.beadinventory.Inventory;

import io.carolynn.beadinventory.Beads.*;

import java.util.*;
import java.util.stream.Collectors;

import static io.carolynn.beadinventory.Beads.MaterialCategories.*;

public class InventoryTracker {

    private ArrayList<Bead> beads;


    public InventoryTracker(){
        this.beads = new ArrayList<>();
    }

    public InventoryTracker(ArrayList<Bead> beads){
        this.beads = beads;
    }

    public ArrayList<Bead> getBeads(){
        return this.beads;
    }


    public long countTotalBeads(){
        return beads.stream()
                .map(e->e.getQuantity())
                .reduce(0,Integer::sum);
    }

    public List<String> getCurrentShapeList(){
        return beads.stream()
                .map(e -> e.getShape()).distinct()
                .collect(Collectors.toList());
    }

    public List<String> getCurrentMaterialList(){
        return beads.stream()
                .map(e->e.getMaterial().getMaterial())
                .distinct()
                .collect(Collectors.toList());
    }

    public String printCurrentMaterials(){
        StringBuilder builder = new StringBuilder();
        getCurrentMaterialList().stream().forEach(e->builder.append(e).append("\n"));
        return builder.toString();
    }

    public long countCurrentMaterials(){
        return beads.stream()
                .map(e -> e.getMaterial())
                .distinct()
                .count();
    }

    public String getCurrentColorsOfMaterial(Material material) {
        StringBuilder builder = new StringBuilder();
        Collections.sort(beads, Comparator.comparing(Bead::getMaterial).thenComparing(Bead::getColorShade));
        beads.stream()
                .filter(e->e.getMaterial().equals(material))
                .forEach(bead -> builder.append(bead.getColorFamily().getColor())
                                        .append(": ")
                                        .append(bead.getColorShade())
                                        .append(", "));
        return builder.toString();
    }

    public String getCurrentColorsOfMaterialSize(Material material, int size){
        Collections.sort(beads, Comparator.comparing(Bead::getMaterial).thenComparing(Bead::getColorShade));
        StringBuilder builder = new StringBuilder();
        beads.stream()
                .filter(e-> e.getMaterial().equals(material))
                .filter(e->e.getSizeMM() == size)
                .forEach(bead -> builder.append(bead.getColorFamily().getColor())
                                        .append(": ")
                                        .append(bead.getColorShade())
                                        .append(", "));
        return builder.toString();
    }


    public long countCurrentShadesOfColorFamilyMaterial(Material material, ColorFamily cFamily){
        return beads.stream()
                .filter(e->e.getMaterial().equals(material))
                .filter(e->e.getColorFamily().equals(cFamily))
                .distinct()
                .count();
    }


    public long countOfMaterialSizeColor(Material material, int size, ColorFamily cFamily, String color){
        return beads.stream().filter(e-> e.getMaterial().equals(material))
                .filter(e -> e.getSizeMM() == size)
                .filter(e->e.getColorFamily().equals(cFamily))
                .filter(e->e.getColorShade().equals(color))
                .map(e->e.getQuantity())
                .findFirst()
                .get();
    }

    public String lowQuantityList(){
        StringBuilder builder = new StringBuilder("Low Quantity:\n");
        checkForLowQuantityNaturalStone().stream().forEach(bead -> builder.append(bead.toString()).append("\n"));
        return builder.toString();
    }

    private List<Bead> checkForLowQuantityNaturalStone(){
        return beads.stream()
                .filter(e->e.getQuantity()<10)
                .filter(e->e.getMaterialCategory().equals(NATURAL_STONE)|| e.getMaterialCategory().equals(SEMI_PRECIOUS_STONE))
                .collect(Collectors.toList());
    }

    public void changeQuantity(Bead bead, int quantity){
        bead.setQuantity(quantity);
    }

    public void changeQuantyFromDescription(Material material, int size, ColorFamily cFamily, String color, int newQuantity){
        Bead bead1 = beads.stream()
                .filter(e-> e.getMaterial().equals(material.getMaterial()))
                .filter(e -> e.getSizeMM() == size)
                .filter(e->e.getColorFamily().equals(cFamily))
                .filter(e->e.getColorShade().equals(color)).findFirst().get();
        bead1.setQuantity(newQuantity);
    }

}
