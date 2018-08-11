package io.carolynn.beadinventory;

import io.carolynn.beadinventory.Beads.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InventoryTracker {

    ArrayList<Bead> beads;


    public InventoryTracker(){
        this.beads = new ArrayList<>();

    }

    public InventoryTracker(ArrayList<Bead> beads){
        this.beads = beads;
    }

    public long getCurrentMaterialCount(){
        return beads.stream().map(e -> e.getMaterial()).count();
    }

    public long getColorCount(String color){
        return beads.stream().filter(e -> e.getColor().contains(color)).count();
    }

    public List<String> getCurrentColorList(){
        return beads.stream().map(e -> e.getColor()).distinct().collect(Collectors.toList());
    }

    public List<String> getCurrentShapeList(){
        return beads.stream().map(e -> e.getShape()).distinct().collect(Collectors.toList());
    }

    public long getTotalBeadCount(){
        return beads.stream().map(e->e.getQuantity()).collect(Collectors.counting());
    }

    public String getCurrentColorsOfMaterial(Material material){
        List<String> colors = beads.stream().filter(e->e.getMaterial().equals(material.getMaterial())).map(e->e.getColor())
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder(material.getMaterial());
        for(String color: colors){
            builder.append(": ").append(color).append(", ");
        }
        return builder.toString();
    }

    public String getCurrentColorsOfMaterialSize(Material material, int size){
        List<String> colors = beads.stream().filter(e->e.getMaterial().equals(material.getMaterial())).filter(e->e.getSizeCM()== size)
                .map(e->e.getColor()).collect(Collectors.toList());
        String x = material.getMaterial() + ", size " + size + ":\n";
        StringBuilder builder = new StringBuilder(x);
        for(String color: colors){
            builder.append(": ").append(color).append(", ");
        }
        return builder.toString();
    }

    public long getQuantityOfMaterialSize(Material material, int size){
        return beads.stream().filter(e->e.getMaterial().equals(material.getMaterial())).filter(e->e.getSizeCM()==size)
                .collect(Collectors.counting());
    }

    public long getQuantityOfMaterialSizeColor(Material material, int size, String color){
        return beads.stream().filter(e-> e.getMaterial().equals(material.getMaterial())).filter(e -> e.getSizeCM() == size)
                .filter(e->e.getColor().equals(color)).map(e->e.getQuantity()).collect(Collectors.counting());
    }

    public String getBeadIdFromAttributes(Material material, int size, Shape shape, String color){
        String id = "";
        for(Bead bead: beads){
            if(bead.getMaterial().equals(material.getMaterial()) && bead.getSizeCM()==size
                    && bead.getColor().equals(color) && bead.getShape().equals(shape.getShape())){
                id = bead.getId();
            }
        }
        return id;
    }

    public int getQuantityById(String id){
        return beads.stream().filter(e-> e.getId().equals(id)).mapToInt(Bead::getQuantity).sum();
    }

    public String getBeadById(String id){
        return beads.stream().filter(e->e.getId().equals(id)).map(e->e.toString()).collect(Collectors.joining("\n"));
    }

    public void changeQuantity(String id, int quantity){
        for(Bead bead: beads){
            if(bead.getId().equals(id)){
                bead.setQuantity(quantity);
            }
        }
    }

}
