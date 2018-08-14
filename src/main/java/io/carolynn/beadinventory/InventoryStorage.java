package io.carolynn.beadinventory;

import io.carolynn.beadinventory.Beads.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class InventoryStorage {

    Path filePath;
    CreateBeads manager;

    public InventoryStorage(Path filePath){
        this.manager = new CreateBeads();
        this.filePath = filePath;
        try{
            if(Files.notExists(filePath)){
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializeBeadObject(){
        Bead bead = manager.beadFromUserInput();
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filePath.toFile()))) {
            out.writeObject(bead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializeBeadObject(ArrayList<Bead> bead){
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
//        Bead bead = null;
        try(ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filePath.toFile()))) {
//
                beadList = (ArrayList<Bead>) in.readObject();
//                beadList.add(bead);
//
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return beadList;
    }

    public void addBeadObject(Bead bead){
        ArrayList<Bead> beads = deSerializeBeadObjects();
        beads.add(bead);
        serializeBeadObject(beads);
    }

    public static void main(String[] args){

        InventoryStorage storage = new InventoryStorage(Paths.get("/Users/carolynn/dev/BeadInventoryOne.ser"));
        Bead bead = new Bead(Material.ADVENTURINE,ColorFamily.GREEN,"dark",6,Shape.ROUND," ",
                Quality.GOOD,10);
        Bead bead2 = new Bead(Material.ADVENTURINE,ColorFamily.GREEN,"light",8,Shape.ROUND," ",
                Quality.GOOD,20);
        Bead bead3 = new Bead(Material.BLUE_ADVENTURINE,ColorFamily.BLUE,"light",8,Shape.ROUND," ",
                Quality.GOOD,30);
        ArrayList<Bead> beads = new ArrayList<>(Arrays.asList(bead, bead2));

        storage.serializeBeadObject(beads);
        storage.addBeadObject(bead3);
        ArrayList<Bead> beads1 = storage.deSerializeBeadObjects();

        InventoryTracker tracker = new InventoryTracker(beads1);
        System.out.println(tracker.countCurrentMaterials());
        System.out.println(tracker.countTotalBeads());
        System.out.println(tracker.getCurrentColorsOfMaterial(Material.ADVENTURINE));
    }
}
