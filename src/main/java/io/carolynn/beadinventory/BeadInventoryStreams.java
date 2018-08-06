package io.carolynn.beadinventory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BeadInventoryStreams {

    ArrayList<Bead> beads;


    public BeadInventoryStreams(){
        this.beads = new ArrayList<>();
    }

    public BeadInventoryStreams(ArrayList<Bead> beads){
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
        List<Integer> quantityEach = beads.stream().map(e->e.getQuantity()).collect(Collectors.toList());
        return quantityEach.stream().reduce(0, Integer::sum);
    }

    public int getQuantityById(int id){
        return beads.stream().filter(e-> e.getId()==id).mapToInt(Bead::getQuantity).sum();
    }

    public String getBeadById(int id){
        return beads.stream().filter(e->e.getId() == id).map(e->e.toString()).collect(Collectors.joining("\n"));
    }



}
