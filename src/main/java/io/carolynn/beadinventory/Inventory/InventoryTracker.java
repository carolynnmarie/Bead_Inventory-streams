package io.carolynn.beadinventory.Inventory;

import io.carolynn.beadinventory.Beads.*;
import io.carolynn.beadinventory.Material;

import java.util.*;
import java.util.stream.Collectors;

import static io.carolynn.beadinventory.MaterialCategories.*;

public class InventoryTracker {

    private ArrayList<Bead> beads;

    public InventoryTracker(ArrayList<Bead> beads1){
        this.beads = beads1;
        Collections.sort(beads, Comparator.comparing(Bead::getMaterial)
                .thenComparing(Bead::getShape)
                .thenComparing(Bead::getSizeMM)
                .thenComparing(Bead::getColorFamily));
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
        beads.stream()
                .filter(e->e.getMaterial().equals(material))
                .forEach(bead -> builder.append(bead.getColorFamily().getColor())
                                        .append(": ")
                                        .append(bead.getColorShade())
                                        .append(", "));
        return builder.toString();
    }

    public String getCurrentColorsOfMaterialSize(Material material, int size){
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
        checkForLowQuantity()
                .stream()
                .forEach(bead -> builder.append(bead.toString()).append("\n"));
        return builder.toString();
    }

    private List<Bead> checkForLowQuantity(){
        List<Bead> low = beads.stream()
                .filter(e->e.getQuantity()<10)
                .filter(e->e.getMaterialCategory().equals(NATURAL_STONE)|| e.getMaterialCategory().equals(SEMI_PRECIOUS_STONE))
                .collect(Collectors.toList());
        low.addAll(beads.stream()
                .filter(e->e.getQuantity()<5)
                .filter(e->e.getMaterial().equals(Material.SWAROVSKI_CRYSTAL) || e.getMaterialCategory().equals(PRECIOUS_METAL))
                .collect(Collectors.toList()));
        Collections.sort(low,Comparator.comparing(Bead::getMaterialCategory).thenComparing(Bead::getMaterial));
        return low;
    }

    public void changeQuantity(Bead bead, int quantity){
        bead.setQuantity(quantity);
    }

    public void changeQuantityFromDescription(Material material, int size, ColorFamily cFamily, String color, int newQuantity){
        Bead bead1 = beads.stream()
                .filter(e-> e.getMaterial().equals(material.getMaterial()))
                .filter(e -> e.getSizeMM() == size)
                .filter(e->e.getColorFamily().equals(cFamily))
                .filter(e->e.getColorShade().equals(color)).findFirst().get();
        bead1.setQuantity(newQuantity);
    }

}
