package io.carolynn.beadinventory.Inventory;

import io.carolynn.beadinventory.Beads.*;
import io.carolynn.beadinventory.CreateBeads;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static io.carolynn.beadinventory.Beads.ColorFamily.*;
import static io.carolynn.beadinventory.Beads.Material.*;
import static io.carolynn.beadinventory.Beads.Shape.*;
import static io.carolynn.beadinventory.Beads.Quality.*;

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

        try(ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filePath.toFile()))) {
                beadList = (ArrayList<Bead>) in.readObject();
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

    public void deleteBeadObject(Bead bead){
        ArrayList<Bead> beads = deSerializeBeadObjects();
        Bead temp = null;
        int index = 0;
        for(int i = 0; i<beads.size(); i++){
            if(beads.get(i).getId().equals(bead.getId())){
                temp = beads.get(i);
                index = i;
            }
        }
        if(temp != null){
            beads.remove(index);
        }
        serializeBeadObject(beads);
    }

    public static void main(String[] args){

        InventoryStorage storage = new InventoryStorage(Paths.get("/Users/carolynn/dev/BeadInventoryOne.ser"));
        InventoryList inventory = new InventoryList();
        ArrayList<Bead> beads = inventory.getInventory();

        storage.serializeBeadObject(beads);

        ArrayList<Bead> beads1 = storage.deSerializeBeadObjects();

        InventoryTracker tracker = new InventoryTracker(beads1);
        System.out.println(tracker.printInventory());

    }
}
