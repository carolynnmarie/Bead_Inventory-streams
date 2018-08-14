package io.carolynn.beadinventory;

import io.carolynn.beadinventory.Beads.*;

import java.util.*;
import java.util.stream.Collectors;

public class InventoryTracker {

    ArrayList<Bead> beads;


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
                .map(e->e.getMaterial())
                .distinct()
                .collect(Collectors.toList());
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
            if(beads.get(i).getMaterial().equals(material.getMaterial())) {
                builder.append(beads.get(i).getColorFamily().getColor())
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
            if(beads.get(i).getMaterial().equals(material.getMaterial())) {
                if(beads.get(i).getSizeCM() == size) {
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
                .filter(e->e.getMaterial().equals(material.getMaterial()))
                .filter(e->e.getColorFamily().equals(cFamily))
                .distinct()
                .count();
    }


    public long countOfMaterialSizeColor(Material material, int size, ColorFamily cFamily, String color){
        return beads.stream().filter(e-> e.getMaterial().equals(material.getMaterial()))
                .filter(e -> e.getSizeCM() == size)
                .filter(e->e.getColorFamily().equals(cFamily))
                .filter(e->e.getColorShade().equals(color))
                .map(e->e.getQuantity())
                .findFirst()
                .get();
    }


    public void changeQuantity(Bead bead, int quantity){
        bead.setQuantity(quantity);
    }

    public void changeQuantyFromDescription(Material material, int size, ColorFamily cFamily, String color, int newQuantity){
        Bead bead1 = beads.stream()
                .filter(e-> e.getMaterial().equals(material.getMaterial()))
                .filter(e -> e.getSizeCM() == size)
                .filter(e->e.getColorFamily().equals(cFamily))
                .filter(e->e.getColorShade().equals(color)).findFirst().get();
        bead1.setQuantity(newQuantity);

    }

}
