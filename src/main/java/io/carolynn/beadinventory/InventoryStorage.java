package io.carolynn.beadinventory;

import io.carolynn.beadinventory.Beads.Bead;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
        Bead bead = manager.addBead();
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
        Bead bead = null;
        try(ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filePath.toFile()))) {
            while((bead = (Bead) in.readObject()) != null ){
                beadList.add(bead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return beadList;
    }

    public static void main(String[] args){

        InventoryStorage storage = new InventoryStorage(Paths.get("/Users/carolynn/dev/BeadInventory.ser"));

    }
}
