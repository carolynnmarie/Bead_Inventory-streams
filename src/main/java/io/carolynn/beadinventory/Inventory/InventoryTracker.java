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

    public String printInventory(){
        StringBuilder builder = new StringBuilder();
        Collections.sort(beads,Comparator.comparing(Bead::getMaterial));
        for(Bead bead: beads){
            builder.append(bead.toString())
                    .append("\n");
        }
        return builder.toString();
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
        List<String> list = getCurrentMaterialList();
        StringBuilder builder = new StringBuilder();
        for(String item: list){
            builder.append(item)
                    .append("\n");
        }
        return builder.toString();
    }

    public long countCurrentMaterials(){
        return beads.stream()
                .map(e -> e.getMaterial())
                .distinct()
                .count();
    }

    public String getCurrentColorsOfMaterial(Material material) {
        Collections.sort(beads, Comparator.comparing(Bead::getMaterial).thenComparing(Bead::getColorShade));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < beads.size(); i++) {
            if(beads.get(i).getMaterial().equals(material)) {
                builder.append(beads.get(i).getColorFamily())
                        .append(": ")
                        .append(beads.get(i).getColorShade())
                        .append(", ");
            }
        }
        return builder.toString();
    }

    public String getCurrentColorsOfMaterialSize(Material material, int size){
        Collections.sort(beads, Comparator.comparing(Bead::getMaterial).thenComparing(Bead::getColorShade));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < beads.size(); i++) {
            if(beads.get(i).getMaterial().equals(material)) {
                if(beads.get(i).getSizeMM() == size) {
                    builder.append(beads.get(i).getColorFamily().getColor())
                            .append(": ")
                            .append(beads.get(i).getColorShade())
                            .append(", ");
                }
            }
        }
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
        List<Bead> list = checkForLowQuantityNaturalStone();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<list.size(); i++){
            builder.append(i+1)
                    .append(".) ")
                    .append(list.get(i).toString())
                    .append("\n");
        }
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
