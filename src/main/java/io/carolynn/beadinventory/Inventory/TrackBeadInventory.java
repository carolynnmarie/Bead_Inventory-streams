package io.carolynn.beadinventory.Inventory;

import io.carolynn.beadinventory.Beads.*;
import io.carolynn.beadinventory.Material;
import static io.carolynn.beadinventory.MaterialCategories.*;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class TrackBeadInventory {


    private BeadInventoryStorage inventory;
    private ArrayList<Bead> beads;

    public TrackBeadInventory(Path filePath){
        this.inventory = new BeadInventoryStorage(filePath);
        this.beads = inventory.getBeads();
    }

    public BeadInventoryStorage getInventory(){
        return inventory;
    }


    public long getBeadCount(){
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


    public long getCurrentMaterialCount(){
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


    public long countMaterialSizeColor(Material material, int size, ColorFamily cFamily, String color){
        return beads.stream().filter(e-> e.getMaterial().equals(material))
                .filter(e -> e.getSizeMM() == size)
                .filter(e->e.getColorFamily().equals(cFamily))
                .filter(e->e.getColorShade().equals(color))
                .map(e->e.getQuantity())
                .findFirst()
                .get();
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

    public String printLowQuantityList(){
        StringBuilder builder = new StringBuilder("Low Quantity:\n");
        checkForLowQuantity()
                .stream()
                .forEach(bead -> builder.append(bead.toString()).append("\n"));
        return builder.toString();
    }


    public String printBeadsOfShape(Shape shape){
        StringBuilder builder = new StringBuilder();
        beads.stream().filter(e-> e.getShape().equals(shape)).forEach(e-> builder.append(e).append("\n"));
        return builder.toString();
    }

    public String printCurrentMaterials(){
        StringBuilder builder = new StringBuilder();
        getCurrentMaterialList().stream().forEach(e->builder.append(e).append("\n"));
        return builder.toString();
    }

    public double getTotalIndividualBeadValue(Bead bead){
        return bead.getQuantity() * bead.getPricePoint();
    }

    public double getTotalInventoryValue(){
        double total = 0;
        for(Bead bead: beads){
            total += bead.getPricePoint()*bead.getQuantity();
        }
        return total;
    }
}
