package io.carolynn.beadinventory.Inventory;

import io.carolynn.beadinventory.Beads.*;
import io.carolynn.beadinventory.CreateBeads;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class InventoryStorage {

    private Path filePath;
    private CreateBeads manager;

    public InventoryStorage(Path filePath){
        this.manager = new CreateBeads();
        this.filePath = filePath;
        try{
            if(Files.notExists(filePath)){
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.out.println("file creation error");
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

    public void addBeadObject(Bead bead){
        ArrayList<Bead> beads = deSerializeBeadObjects();
        beads.add(bead);
        serializeBeadObjectArray(beads);
    }

    public void deleteBeadObject(String beadId){
        ArrayList<Bead> beads = deSerializeBeadObjects();
        Bead b = new Bead();
        for (Bead bead1 : beads) {
            if (bead1.getId().equals(beadId)) {
                b = bead1;
            }
        }
        beads.remove(b);
        serializeBeadObjectArray(beads);
    }

    public String viewInventory(){
        String print = "";
        ArrayList<Bead> beads = deSerializeBeadObjects();
        Collections.sort(beads,Comparator.comparing(Bead::getMaterial).thenComparing(Bead::getShape).thenComparing(Bead::getSizeMM));
        for (Bead bead : beads) {
            print += bead.toString() + "\n";
        }
        return print;
    }

    public static void main(String[] args){

        InventoryStorage storage = new InventoryStorage(Paths.get("/Users/carolynn/dev/BeadInventoryOne.ser"));
        System.out.println(storage.viewInventory());
    }
}
