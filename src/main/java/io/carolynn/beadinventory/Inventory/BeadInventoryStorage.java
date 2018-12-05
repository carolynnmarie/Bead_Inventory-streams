package io.carolynn.beadinventory.Inventory;

import io.carolynn.beadinventory.Beads.*;
import io.carolynn.beadinventory.Beads.CreateBeads;
import io.carolynn.beadinventory.Material;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class BeadInventoryStorage {

    private Path filePath;
    private ArrayList<Bead> beads;

    public BeadInventoryStorage(Path filePath){
        this.beads = new ArrayList<>();
        try{
            if(Files.notExists(filePath)){
                Files.createFile(filePath);
                this.filePath = filePath;
            } else {
                this.filePath = filePath;
            }
        } catch (IOException e) {
            System.out.println("file creation error");
        }
        this.filePath = filePath;
    }


    public void serializeBeadObjectArray(ArrayList<Bead> bead){
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filePath.toFile()))) {
            out.writeObject(bead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Bead> deSerializeBeadObjects(){
        ArrayList<Bead> beadList = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filePath.toFile()))) {
                beadList = (ArrayList<Bead>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }
        return beadList;
    }

    public void setBeads(ArrayList<Bead> beads){
        serializeBeadObjectArray(beads);
    }

    public ArrayList<Bead> getBeads(){
        this.beads = deSerializeBeadObjects();
        return beads;
    }

    public String viewInventory(){
        beads = getBeads();
        StringBuilder print = new StringBuilder();
        Collections.sort(beads,
                Comparator.comparing(Bead::getMaterial)
                        .thenComparing(Bead::getShape)
                        .thenComparing(Bead::getSizeMM));
        beads.stream().forEach(bead -> print.append(bead.toString()).append("\n"));
        return print.toString();
    }

    public void addBead(Bead bead){
        beads = getBeads();
        beads.add(bead);
        serializeBeadObjectArray(beads);
    }

    public Bead addBeadFromUserInput(){
        CreateBeads create = new CreateBeads();
        Bead bead = create.beadFromUserInput();
        addBead(bead);
        return bead;
    }

    public void deleteBeadById(String beadId){
        beads = getBeads();
        Bead b = new Bead();
        for (Bead bead1 : beads) {
            if (bead1.getId().equals(beadId)) {
                b = bead1;
            }
        }
        beads.remove(b);
        serializeBeadObjectArray(beads);
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


    public static void main(String[] args){

        BeadInventoryStorage storage = new BeadInventoryStorage(Paths.get("/Users/carolynn/dev/BeadInventoryOne.ser"));
        BeadInventoryList beadList = new BeadInventoryList();
        ArrayList<Bead> beads = beadList.getInventory();
        beads.forEach(e->storage.addBead(e));
        System.out.println(storage.viewInventory());
    }
}
